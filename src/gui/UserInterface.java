package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.GameLogic;
import logic.Variables;
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
		
		
		
		panel.add(gameMap, "w 75%, h 75%");
		panel.add(infoBox, "h 25%, dock south");
		panel.add(scheduleBox, "w 25%, dock east");
		
		panel.add(gameMap, "x 0, y 0, w 768, h 576");
		panel.add(infoBox, "x 0, y 576, w 768, h 192");
		panel.add(scheduleBox, "x 768, y -48, w 256, h 720");
		
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
	
	public void showAction()
	{
		gameMap.showAction();
	}
}
