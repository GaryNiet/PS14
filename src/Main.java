import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import logic.GameLogic;
import logic.Variables;

public class Main
{

	public static void main(String[] args)
	{

		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		
		JPanel panel = new JPanel(new MigLayout("fill"));
		frame.add(panel);
		final JButton button = new JButton("ok");
		panel.add(button, "x 80%,y 80%,w 10%,h 5%");
		panel.add(new JLabel("chose a resolution at which to run PrisonSimulator: "), "x 10, y 10, w 80% , h 40%");

		String[] resStrings =
		{ "1024x768", "1152x864", "1280x960", "1440x1080", "1600x1200",
				"2048x1536" };
		final JComboBox combo = new JComboBox(resStrings);

		panel.add(combo, "x 10%,y 10%,w 80%, h 80%");

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
