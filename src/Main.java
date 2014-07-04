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
	static JFrame frame;

	/**
	 * @param args
	 *            this part creates the opening window, which presents the game
	 *            and asks for the resolution and on press of the OK button launches the game 
	 */
	public static void main(String[] args)
	{

		frame = new JFrame();
		frame.setSize(500, 500);

		JPanel panel = new JPanel(new MigLayout(Messages.getString("Main.0"))); //$NON-NLS-1$
		frame.add(panel);
		final JButton button = new JButton(Messages.getString("Main.1")); //$NON-NLS-1$
		panel.add(button, Messages.getString("Main.2")); //$NON-NLS-1$
		panel.add(
				new JLabel(Messages.getString("Main.3")), Messages.getString("Main.4")); //$NON-NLS-1$ //$NON-NLS-2$
		panel.add(
				new JLabel(Messages.getString("Main.5")), Messages.getString("Main.6")); //$NON-NLS-1$ //$NON-NLS-2$
		
		JLabel label = new JLabel(Messages.getString("Main.17")); //$NON-NLS-1$
		panel.add(label, Messages.getString("Main.18")); //$NON-NLS-1$

		try
		{
			logo = ImageIO.read(new File(Messages.getString("Main.7"))); //$NON-NLS-1$
		} catch (IOException e1)
		{
			System.out.println(Messages.getString("Main.8")); //$NON-NLS-1$
		}

		JLabel picLabel = new JLabel(new ImageIcon(logo));
		panel.add(picLabel, Messages.getString("Main.9")); //$NON-NLS-1$

		String[] resStrings =
		{
				Messages.getString("Main.10"), Messages.getString("Main.11"), Messages.getString("Main.12"), Messages.getString("Main.13"), Messages.getString("Main.14"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				Messages.getString("Main.15") }; //$NON-NLS-1$
		@SuppressWarnings(
		{ "rawtypes", "unchecked" })
		final JComboBox combo = new JComboBox(resStrings);

		panel.add(combo, Messages.getString("Main.16")); //$NON-NLS-1$

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

			/* (non-Javadoc)
			 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
			 * sets the right size for the game
			 */
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
					
					launchGame();
					
					
				}

			}
		});

	}

	/**
	 * launches the game
	 */
	protected static void launchGame()
	{
		@SuppressWarnings("unused")
		GameLogic gamelogic = new GameLogic();
		
		frame.dispose();
		
	}

}
