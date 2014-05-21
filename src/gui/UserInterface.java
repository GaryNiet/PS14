package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.GameLogic;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class UserInterface extends JFrame
{
	JPanel panel;
	GameMap gameMap;
	ScheduleBox scheduleBox;
	InfoBox infoBox;
	MigLayout mainLayout;
	GameLogic gameLogic;
	
	public UserInterface(GameLogic _gameLogic)
	{
		gameLogic = _gameLogic;
		panel = new JPanel(new MigLayout("fill"));
		infoBox = new InfoBox();
		gameMap = new GameMap(this);
		scheduleBox = new ScheduleBox(this);
		
		
		
		
		panel.add(gameMap, "w 70%, h 80%");
		panel.add(infoBox, "h 20%, dock south");
		panel.add(scheduleBox, "w 30%, dock east");
		
		panel.add(gameMap, "x 0, y 0, w 717, h 611");
		panel.add(infoBox, "x 0, y 611, w 717, h 153");
		panel.add(scheduleBox, "x 718, y 0, w 307, h 764");
		
		gameMap.setBackground(Color.green);
		infoBox.setBackground(Color.red);
		scheduleBox.setBackground(Color.black);
		
		
		
		
		this.add(panel);
		
		pack();
		scheduleBox.set();
	}
	
	public GameLogic getGameLogic()
	{
		return gameLogic;
	}

	public InfoBox getInfoBox() {
		return infoBox;
	}
}
