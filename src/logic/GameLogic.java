package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import places.Free;
import schedule.PrisonAction;
import aiMachine.AIValidator;
import aiMachine.ActionCalculator;
import characters.CharacterPH;


public class GameLogic {
	
	List<CharacterPH> characterList = new ArrayList<>();
	ActionCalculator actionCalculator;
	int currentTime;
	AIValidator aiValidator;
	Random random;
	
	//beware have to change this value
	public final int timeZones = 9;
	

	public GameLogic()
	{
		init();

		random = new Random();
		actionCalculator = new ActionCalculator();
		OnTimer timerTask = new OnTimer();
		Timer timer = new Timer("Clock");
		timer.scheduleAtFixedRate(timerTask, 0, 2*1000);
		aiValidator = new AIValidator();
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
		aiValidator.showUsage();
		
		
	}


	private void init()
	{
		
		CharacterPH character1 = new CharacterPH("george" , 100, 12, 10, 0, 0);
		characterList.add(character1);
		CharacterPH character2 = new CharacterPH("foreman" , 100, 13, 10, 0, 0);
		characterList.add(character2);
		CharacterPH character3 = new CharacterPH("snip" , 100, 11, 10, 0, 0);
		characterList.add(character3);
		CharacterPH character4 = new CharacterPH("sprool" , 100, 8, 10, 0, 0);
		characterList.add(character4);
		CharacterPH character5 = new CharacterPH("tuck" , 100, 1, 15, 0, 0);
		characterList.add(character5);
//		CharacterPH character6 = new CharacterPH("duck" , 100, 3, 10, 0, 0);
//		characterList.add(character6);
//		CharacterPH character7 = new CharacterPH("schnaps" , 7, 10, 10, 0, 0);
//		characterList.add(character7);
//		CharacterPH character8 = new CharacterPH("large" , 10, 10, 10, 0, 0);
//		characterList.add(character8);
		
		
		Variables.setCharacterList(characterList);
		
		
		
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
				
				
				character.setFixedAction(bestAction);
				setCurrentPlace(character, bestAction);
				bestAction.resolve(character, currentTime, true);
				aiValidator.update(character.getCurrentPlace(), character.getFixedAction());
				
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