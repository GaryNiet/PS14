package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import places.Free;

import schedule.Blackmail;
import schedule.Corrupt;
import schedule.Dig;
import schedule.Evasion;
import schedule.PrisonAction;
import schedule.StealWeaponTool;
import schedule.Train;
import schedule.WellBeing;

import aiMachine.ActionCalculator;

import characters.CharacterPH;


public class GameLogic {
	
	List<CharacterPH> characterList = new ArrayList<>();
	ActionCalculator actionCalculator;
	int currentTime;
	
	//beware have to change this value
	public final int timeZones = 9;
	

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
		
		
		String leftAlignFormat = "| %-11s | %-6d | %-10d | %-4d | %-10s | %-9s | %-10s | %-7d | %-5d | %-9d |%n";
		
		System.out.format("+--------------------------------------------------------------------------------------------------------------+%n");
		System.out.printf("|    name     |strength|intelligence|health|   action   | schedule  |currentPlace|influence| money | materials |%n");
		System.out.format("+--------------------------------------------------------------------------------------------------------------+%n");
		for(CharacterPH character: characterList)
		{
			System.out.format(leftAlignFormat, character.getName(), (int)character.getStrength(), (int)character.getIntelligence(), 
					character.getHealth(), character.getFixedAction().name, character.getSchedule().getPlace(currentTime).name, character.getCurrentPlace().name, 
					character.getInfluence(), character.getMoney(), character.getMaterials());
			
		}
		System.out.format("+--------------------------------------------------------------------------------------------------------------+%n");
	}


	private void init()
	{
		for(int i = 0; i<1; i++)
		{
			CharacterPH character1 = new CharacterPH("name" , 100, 10, 10, 0, 0);
			characterList.add(character1);
			System.out.println(character1.getSchedule().getPlace(3));
		}
		
		
	}
	
	public class OnTimer extends TimerTask
	{

		@Override
		public void run()
		{
			for(CharacterPH character: characterList)
			{
				updateVariablesAndCheckIntegrity(character);
				
				PrisonAction bestAction = actionCalculator.calculateBestAction(character, currentTime);
				
				
				bestAction.resolve(character, currentTime);
				character.setFixedAction(bestAction);
				setCurrentPlace(character, bestAction);
				
			}
			showTable();
			passTime();
			
			
		}
		
	}
	
	private void updateVariablesAndCheckIntegrity(CharacterPH character)
	{
		character.naturalHealthLoss();
	}
	
	private void passTime()
	{
		currentTime += 1;
		if(currentTime > timeZones -1)
		{
			currentTime = 0;
		}
	}
	
	private void setCurrentPlace(CharacterPH character, PrisonAction action)
	{
		if(character.getSchedule().getPlace(currentTime).name == "free")
		{
			
			character.setCurrentPlace(Free.chosePlace(action));
		}
		else if(character.getSchedule().getPlace(currentTime).name == "job")
		{
			character.setCurrentPlace(Free.chosePlace(action));
		}
		else
		{
			character.setCurrentPlace(character.getSchedule().getPlace(currentTime));
		}
	}
}