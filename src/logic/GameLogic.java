package logic;

import gui.UserInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import places.Free;
import schedule.PrisonAction;
import aiMachine.AIValidator;
import aiMachine.ActionCalculator;

import characters.AICharacter;
import characters.AbstractCharacter;
import characters.PlayerCharacter;


public class GameLogic {
	
	List<AICharacter> aiCharacterList = new ArrayList<>();
	PlayerCharacter playerCharacter;
	ActionCalculator actionCalculator;
	int currentTime;
	AIValidator aiValidator;
	Random random;
	UserInterface userInterface;
	
	
	//beware have to change this value
	public final int timeZones = 9;
	

	public GameLogic()
	{
		init();
		
		userInterface = new UserInterface(this);
		userInterface.setTitle("test");
		userInterface.setSize(1024, 768);
		userInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userInterface.setVisible(true);

		random = new Random();
		actionCalculator = new ActionCalculator();
		OnTimer timerTask = new OnTimer();
		Timer timer = new Timer("Clock");
		timer.scheduleAtFixedRate(timerTask, 0, 5*1000);
		aiValidator = new AIValidator();
		currentTime = 0;
		
		
	}
	

	
	private void showTable()
	{
		
		
		String leftAlignFormat = "| %-11s | %-6d | %-10d | %-4d | %-10s | %-9s | %-10s | %-7d | %-5d | %-9d |%n";
		
		System.out.format("+--------------------------------------------------------------------------------------------------------------+%n");
		System.out.printf("|    name     |strength|intelligence|health|   action   | schedule  |currentPlace|influence| money | materials |%n");
		System.out.format("+--------------------------------------------------------------------------------------------------------------+%n");
		for(AbstractCharacter character: aiCharacterList)
		{
			
			System.out.format(leftAlignFormat, character.getName(), (int)character.getStrength(), (int)character.getIntelligence(), 
					character.getHealth(), character.getFixedAction().name, character.getSchedule().getPlace(currentTime).name, character.getCurrentPlace().name, 
					character.getInfluence(), character.getMoney(), character.getMaterials());
			
			
			
			
			
			
		}
		System.out.format("+--------------------------------------------------------------------------------------------------------------+%n");
		//aiValidator.showUsage();
		
		
	}


	private void init()
	{
		playerCharacter = new PlayerCharacter("player", 4, 4, 100, 50, 50);
		
		Variables.setPlayerCharacter(playerCharacter);
		
		for(int i = 0; i<5; i++)
		{
		AICharacter character1 = new AICharacter("george" , 100, 12, 10, 0, 0);
		aiCharacterList.add(character1);
		}
		AICharacter character2 = new AICharacter("foreman" , 100, 13, 10, 0, 0);
		aiCharacterList.add(character2);
		AICharacter character3 = new AICharacter("snip" , 100, 11, 10, 0, 0);
		aiCharacterList.add(character3);
		AICharacter character4 = new AICharacter("sprool" , 100, 8, 10, 0, 0);
		aiCharacterList.add(character4);
		AICharacter character5 = new AICharacter("tuck" , 100, 1, 15, 0, 0);
		aiCharacterList.add(character5);
//		CharacterPH character6 = new CharacterPH("duck" , 100, 3, 10, 0, 0);
//		aiCharacterList.add(character6);
//		CharacterPH character7 = new CharacterPH("schnaps" , 7, 10, 10, 0, 0);
//		aiCharacterList.add(character7);
//		CharacterPH character8 = new CharacterPH("large" , 10, 10, 10, 0, 0);
//		aiCharacterList.add(character8);
		
		
		Variables.setCharacterList(aiCharacterList);
		
	}
		
	
	public class OnTimer extends TimerTask
	{

		@Override
		public void run()
		{
			for(AICharacter character: aiCharacterList)
			{
				updateVariablesAndCheckIntegrity(character);
				
				PrisonAction bestAction = actionCalculator.calculateBestAction(character, currentTime);
				
				
				character.setFixedAction(bestAction);
				setCurrentPlace(character, bestAction);
				setXY();
				bestAction.resolve(character, currentTime, true);
				//aiValidator.update(character.getCurrentPlace(), character.getFixedAction());
				
			}
			
			showTable();
			
			playerCharacter.setCurrentPlace(playerCharacter.getSchedule().getPlace(currentTime));
			playerCharacter.getSchedule().getAction(currentTime).resolve(playerCharacter, currentTime, true);
			updateVariablesAndCheckIntegrity(playerCharacter);
			
			
			userInterface.showAction();
			//System.out.println(playerCharacter.getFreeChoice());
			System.out.println(playerCharacter.getName());
			System.out.println(playerCharacter.getStrength());
			System.out.println(playerCharacter.getIntelligence());
			System.out.println(playerCharacter.getHealth());
			System.out.println(playerCharacter.getSchedule().getAction(currentTime));
			System.out.println(playerCharacter.getSchedule().getPlace(currentTime));
			System.out.println(playerCharacter.getInfluence());
			System.out.println(playerCharacter.getMoney());
			System.out.println(playerCharacter.getMaterials());
			
			
			
			passTime();
			
		}
		
	}
	

	

	


	
	private void updateVariablesAndCheckIntegrity(AbstractCharacter character)
	{
		character.naturalHealthLoss();
	}
	
	private void setXY()
	{
		for(AICharacter ai: aiCharacterList)
		{
			ai.setPosX(ai.getCurrentPlace().getPosX());
			ai.setPosY(ai.getCurrentPlace().getPosY());
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
	
	private void setCurrentPlace(AICharacter character, PrisonAction action)
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
	
	public PlayerCharacter getCharacter()
	{
		return playerCharacter;
	}
	
	public List<AICharacter> getAICharacters()
	{
		return aiCharacterList;
	}
	
	public int getTime()
	{
		return currentTime;
	}
}