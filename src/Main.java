import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.GameLogic;
import logic.Variables;
import net.miginfocom.swing.MigLayout;

public class Main
{
	static BufferedImage logo;

	public static void main(String[] args)
	{

		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		
		JPanel panel = new JPanel(new MigLayout("fill"));
		frame.add(panel);
		final JButton button = new JButton("ok");
		panel.add(button, "x 80%,y 80%,w 10%,h 5%");
		panel.add(new JLabel("Welcome to Prison Simulator"), "x 10, y 10, w 80% , h 40%");
		panel.add(new JLabel(" Please chose a resolution at which to run the game: "), "x 10, y 60, w 80% , h 40%");
		
		try
		{
			logo = ImageIO.read(new File("ressources/logo.png"));
		} catch (IOException e1)
		{
			System.out.println("he-arc logo not found");
		}
		
		
		JLabel picLabel = new JLabel(new ImageIcon(logo));
		panel.add(picLabel, "x 0 ,y 395, w 50%, h 20%");

		String[] resStrings =
		{ "1024x768", "1152x864", "1280x960", "1440x1080", "1600x1200",
				"2048x1536" };
		final JComboBox combo = new JComboBox(resStrings);

		panel.add(combo, "x 10%,y 40%,w 80%, h 10%");

		frame.setVisible(true);

		
		

		

		button.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseReleased(MouseEvent e)
			{

			}

			@Override
			public void mousePressed(MouseEvent e)
			{

			}

			@Override
			public void mouseExited(MouseEvent e)
			{

			}

			@Override
			public void mouseEntered(MouseEvent e)
			{

			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (button.contains(e.getPoint()))
				{
					if (combo.getSelectedIndex() == 0)
					{
						Variables.setResolutionMultiplier(1);
					} else if (combo.getSelectedIndex() == 1)
					{
						Variables.setResolutionMultiplier(1.125);
					} else if (combo.getSelectedIndex() == 2)
					{
						Variables.setResolutionMultiplier(1.25);
					} else if (combo.getSelectedIndex() == 3)
					{
						Variables.setResolutionMultiplier(1.40625);
					} else if (combo.getSelectedIndex() == 4)
					{
						Variables.setResolutionMultiplier(1.5625);
					} else if (combo.getSelectedIndex() == 5)
					{
						Variables.setResolutionMultiplier(2);
					}

					@SuppressWarnings("unused")
					GameLogic gamelogic = new GameLogic();
				}

			}
		});

	}
	

}
