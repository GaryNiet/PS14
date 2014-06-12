package logic;

import gui.UserInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import places.Free;
import places.Job;
import schedule.PrisonAction;
import aiMachine.AIValidator;
import aiMachine.ActionCalculator;
import characters.AICharacter;
import characters.AbstractCharacter;
import characters.CharacterGenerator;
import characters.PlayerCharacter;

public class GameLogic
{

	List<AICharacter> aiCharacterList = new ArrayList<>();
	PlayerCharacter playerCharacter;
	ActionCalculator actionCalculator;
	int currentTime;
	AIValidator aiValidator;
	Random random;
	UserInterface userInterface;
	OnTimer timerTask;

	boolean makeWait;

	// beware have to change this value
	public final int timeZones = 9;

	public GameLogic()
	{
		init();

		double resolutionMultiplier = Variables.getResolutionmultiplier();

		userInterface = new UserInterface(this, resolutionMultiplier);
		userInterface.setTitle("test");
		userInterface.setSize(
				(int) (Variables.getXresolution() * resolutionMultiplier),
				(int) (Variables.getYresolution() * resolutionMultiplier));
		userInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userInterface.setVisible(true);

		random = new Random();
		actionCalculator = new ActionCalculator();
		timerTask = new OnTimer();
		aiValidator = new AIValidator();
		currentTime = 0;
		makeWait = false;

		timerTask.start();

	}

	private void showTable()
	{

		String leftAlignFormat = "| %-20s | %-6d | %-10d | %-4d | %-10s | %-9s | %-10s | %-7d | %-5d | %-9d |%n";

		System.out
				.format("+-----------------------------------------------------------------------------------------------------------------------+%n");
		System.out
				.printf("|         name         |strength|intelligence|health|   action   | schedule  |currentPlace|influence| money | materials |%n");
		System.out
				.format("+-----------------------------------------------------------------------------------------------------------------------+%n");
		for (AbstractCharacter character : aiCharacterList)
		{

			System.out.format(leftAlignFormat, character.getName(),
					(int) character.getStrength(), (int) character
							.getIntelligence(), character.getHealth(),
					character.getFixedAction().name, character.getSchedule()
							.getPlace(currentTime).name, character
							.getCurrentPlace().name, character.getInfluence(),
					character.getMoney(), character.getMaterials());

		}
		System.out
				.format("+-----------------------------------------------------------------------------------------------------------------------+%n");
		// aiValidator.showUsage();

	}

	private void init()
	{
		playerCharacter = new PlayerCharacter("player", 100, 100, 100, 50, 50);

		Variables.setPlayerCharacter(playerCharacter);
		Variables.setGameLogic(this);

		for (int i = 0; i < 15; i++)
		{
			AICharacter character1 = new AICharacter(
					CharacterGenerator.generateName(), 2, 12, 10, 0, 0);
			aiCharacterList.add(character1);
		}

		// aiCharacterList.add(character8);

		Variables.setCharacterList(aiCharacterList);

	}

	public class OnTimer extends Thread
	{

		@Override
		public synchronized void run()
		{

			while (true)
			{
				checkForNewPrisoner();
				Iterator iter = aiCharacterList.iterator();

				while (iter.hasNext())
				{
					AICharacter character = (AICharacter) iter.next();
					checkforDeath(character, iter);
					updateVariablesAndCheckIntegrity(character);

					PrisonAction bestAction = actionCalculator
							.calculateBestAction(character, currentTime);

					character.setFixedAction(bestAction);
					setCurrentPlace(character, bestAction);

					bestAction.resolve(character, currentTime, true);
					aiValidator.update(character.getCurrentPlace(),
							character.getFixedAction());

				}

				showTable();

				playerCharacter.setCurrentPlace(playerCharacter.getSchedule()
						.getPlace(currentTime));
				playerCharacter.getSchedule().getAction(currentTime)
						.resolve(playerCharacter, currentTime, true);
				updateVariablesAndCheckIntegrity(playerCharacter);

				userInterface.pulse(currentTime);

				setXY();
				// System.out.println(playerCharacter.getFreeChoice());

				passTime();
				for (int i = 0; i < 10; i++)
				{
					try
					{
						Thread.sleep(Variables.getGameSpeed() * 100);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					if(makeWait == true)
					{
						makeWait = false;
						try
						{
							this.wait();
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			}
			
			

		}
		public synchronized void free()
		{
			this.notifyAll();
		}

	}

	private void checkforDeath(AICharacter character, Iterator iter)
	{
		if (character.getHealth() < 1)
		{
			iter.remove();
		}
	}

	private synchronized void checkForNewPrisoner()
	{
		if (random.nextInt(30) == 0)
		{
			AICharacter newCharacter = new AICharacter(
					CharacterGenerator.generateName(), 100, 100, 100, 0, 0);
			aiCharacterList.add(newCharacter);
			userInterface.getGameMap().addCharacter(newCharacter);
		}
	}

	private void updateVariablesAndCheckIntegrity(AbstractCharacter character)
	{
		character.naturalHealthLoss();
	}

	private void setXY()
	{
		for (AICharacter ai : aiCharacterList)
		{
			if (ai.getPosX() != ai.getCurrentPlace().getPosX())
			{
				ai.getAnimation().setMoving();
			}

			ai.setPosX(ai.getCurrentPlace().getPosX());
			ai.setPosY(ai.getCurrentPlace().getPosY());

		}

		if (playerCharacter.getPosX() != playerCharacter.getCurrentPlace()
				.getPosX())
		{
			playerCharacter.getAnimation().setMoving();
		}

		playerCharacter.setPosX(playerCharacter.getCurrentPlace().getPosX());
		playerCharacter.setPosY(playerCharacter.getCurrentPlace().getPosY());

	}

	private void passTime()
	{
		currentTime += 1;
		if (currentTime > timeZones - 1)
		{
			currentTime = 0;
		}
	}

	private void setCurrentPlace(AICharacter character, PrisonAction action)
	{
		if (character.getSchedule().getPlace(currentTime).name == "free")
		{

			character.setCurrentPlace(Free.chosePlace(action, character,
					currentTime));
		} else if (character.getSchedule().getPlace(currentTime).name == "job")
		{
			character.setCurrentPlace(Job.chosePlace(action, character,
					currentTime));
		} else
		{
			character.setCurrentPlace(character.getSchedule().getPlace(
					currentTime));
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

	public UserInterface getUserInterface()
	{
		return userInterface;
	}

	public void speedUp()
	{
		Variables.setGameSpeed(Variables.getGameSpeed() - 1);
		for (AbstractCharacter character : aiCharacterList)
		{
			character.setSpeed();
		}

		playerCharacter.setSpeed();
	}

	public void speedDown()
	{
		Variables.setGameSpeed(Variables.getGameSpeed() + 1);
		for (AbstractCharacter character : aiCharacterList)
		{
			character.setSpeed();
		}

		playerCharacter.setSpeed();
	}

	public synchronized OnTimer getTimerTask()
	{
		return timerTask;
	}

	public boolean isMakeWait()
	{
		return makeWait;
	}

	public void setMakeWait(boolean makeWait)
	{
		this.makeWait = makeWait;
	}
}