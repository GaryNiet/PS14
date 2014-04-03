package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import aiMachine.ActionCalculator;

import characters.CharacterPH;


public class GameLogic {
	
	List<CharacterPH> characterList = new ArrayList<>();
	
	

	public GameLogic()
	{
		init();
		OnTimer timerTask = new OnTimer();
		Timer timer = new Timer("Clock");
		timer.scheduleAtFixedRate(timerTask, 0, 2*1000);
	}
	

	
	private void showTable()
	{
		
		String leftAlignFormat = "| %-24s | %-12d | %-14d | %-9d |%n";
		
		System.out.format("+----------------------------------------------------------------------+%n");
		System.out.printf("|            name          |   strength   |  intelligence  |   health  |%n");
		System.out.format("+----------------------------------------------------------------------+%n");
		for(CharacterPH character: characterList)
		{
			System.out.format(leftAlignFormat, character.getName(), character.getStrength(), character.getIntelligence(), character.getHealth());
			
		}
		System.out.format("+----------------------------------------------------------------------+%n");
	}


	private void init()
	{
		CharacterPH character1 = new CharacterPH("first", 1000, 10, 9, 0, 0);
		CharacterPH character2 = new CharacterPH("second", 1000, 8, 9, 0, 0);
		CharacterPH character3 = new CharacterPH("third", 1000, 7, 5, 0, 0);
		
		characterList.add(character1);
		characterList.add(character2);
		characterList.add(character3);
		
	}
	
	public class OnTimer extends TimerTask {

		@Override
		public void run()
		{
			for(CharacterPH character: characterList)
			{
				character.naturalHealthLoss();
				ActionCalculator.calculateBestAction(character);
			}
			showTable();
			
			
		}
		
	}
}