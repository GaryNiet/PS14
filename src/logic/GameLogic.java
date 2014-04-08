package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import schedule.PrisonAction;

import aiMachine.ActionCalculator;

import characters.CharacterPH;


public class GameLogic {
	
	List<CharacterPH> characterList = new ArrayList<>();
	ActionCalculator actionCalculator;
	int currentTime;
	
	//beware have to change this value
	public final int timeZones = 3;
	

	public GameLogic()
	{
		init();
		actionCalculator = new ActionCalculator();
		OnTimer timerTask = new OnTimer();
		Timer timer = new Timer("Clock");
		timer.scheduleAtFixedRate(timerTask, 0, 2*1000);
		currentTime = 0;
	}
	

	
	private void showTable()
	{
		
		String leftAlignFormat = "| %-24s | %-12d | %-14d | %-9d | %-17s | %-17s |%n";
		
		System.out.format("+--------------------------------------------------------------------------------------------------------------+%n");
		System.out.printf("|            name          |   strength   |  intelligence  |   health  |       action      |       place       |%n");
		System.out.format("+--------------------------------------------------------------------------------------------------------------+%n");
		for(CharacterPH character: characterList)
		{
			System.out.format(leftAlignFormat, character.getName(), character.getStrength(), character.getIntelligence(), 
					character.getHealth(), character.getFixedAction().name, character.getSchedule().getPlace(currentTime).name);
			
		}
		System.out.format("+--------------------------------------------------------------------------------------------------------------+%n");
	}


	private void init()
	{
		for(int i = 0; i<4; i++)
		{
			CharacterPH character1 = new CharacterPH("name" , 100, 10, 10, 0, 0);
			characterList.add(character1);
		}
		
		
	}
	
	public class OnTimer extends TimerTask
	{

		@Override
		public void run()
		{
			for(CharacterPH character: characterList)
			{
				character.naturalHealthLoss();
				
				//System.out.println(currentTime);
				
				PrisonAction bestAction = actionCalculator.calculateBestAction(character, currentTime);
				bestAction.resolve(character);
				character.setFixedAction(bestAction);
				
			}
			showTable();
			passTime();
			
			
		}
		
	}
	
	private void passTime()
	{
		currentTime += 1;
		if(currentTime > timeZones -1)
		{
			currentTime = 0;
		}
	}
}