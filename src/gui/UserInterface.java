package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class UserInterface extends JFrame
{
	JPanel panel;
	GameMap gameMap;
	ScheduleBox scheduleBox;
	InfoBox infoBox;
	MigLayout mainLayout;
	
	public UserInterface()
	{
		panel = new JPanel(new MigLayout("fill"));
		gameMap = new GameMap();
		scheduleBox = new ScheduleBox();
		infoBox = new InfoBox();
		
		
		
		panel.add(gameMap, "w 70%, h 80%");
		panel.add(infoBox, "h 20%, dock south");
		panel.add(scheduleBox, "w 30%, dock east");
		
		panel.add(gameMap, "x 0, y 0, w 717, h 611");
		panel.add(infoBox, "x 0, y 611, w 1024, h 153");
		panel.add(scheduleBox, "x 718, y 0, w 307, h 611");
		
		gameMap.setBackground(Color.green);
		infoBox.setBackground(Color.red);
		scheduleBox.setBackground(Color.black);
		
		
		
		
		this.add(panel);
		
		pack();
		System.out.println(gameMap.getBounds());
		scheduleBox.set();
	}
}
