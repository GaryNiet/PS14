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
	
	public UserInterface(GameLogic _gameLogic, double resolutionMultiplier)
	{
		gameLogic = _gameLogic;
		panel = new JPanel(new MigLayout("fill"));
		infoBox = new InfoBox();
		gameMap = new GameMap(this);
		scheduleBox = new ScheduleBox(this);
		
		
		
		panel.add(gameMap, "w 75%, h 75%");
		
		panel.add(infoBox, "h 25%, dock south");
		panel.add(scheduleBox, "w 25%, dock east");
		
		
		
		String string = new String("x 0, y 0, w " + Variables.getRightwidth1024() * resolutionMultiplier + ", h " + Variables.getTopheight1024()* resolutionMultiplier);
		panel.add(gameMap, string);
		
		string = "x 0, y " + Variables.getTopheight1024()* resolutionMultiplier + ", w " + Variables.getRightwidth1024()* resolutionMultiplier + ", h " + Variables.getBottomheight1024()* resolutionMultiplier;
		panel.add(infoBox, string);
		
		string = "x " + Variables.getRightwidth1024()* resolutionMultiplier + ", y " + Variables.getShouldbe0()* resolutionMultiplier + ", w " + Variables.getLeftwidth1024()* resolutionMultiplier + ", h " + Variables.getScheduleheight1024()* resolutionMultiplier;
		panel.add(scheduleBox, string);
		
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
	
	public void pulse(int currentTime)
	{
		gameMap.showAction();
		scheduleBox.pulse(currentTime);
		
	}

	public GameMap getGameMap()
	{
		return gameMap;
	}

	public ScheduleBox getScheduleBox()
	{
		return scheduleBox;
	}
}
