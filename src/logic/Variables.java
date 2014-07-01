package logic;

import gui.CharacterPieces;

import java.util.ArrayList;
import java.util.List;

import schedule.Schedule;
import characters.AICharacter;
import characters.AbstractCharacter;
import characters.PlayerCharacter;

public class Variables
{

	final static int weaponBonus = 3;
	final static int fightRandom = 3;
	final static int fightWinningsMultiplier = 10;
	final static int lostInfluenceOnLostFight = 3;
	final static int lostHealthOnLostFight = 8;
	final static int weakestWinsFightMultiplier = 3;
	final static int strongerWinsFightMultiplier = 2;
	final static double digAdvancementImportance = 0.25;
	final static double guardAwarenessImportance = 35;
	final static int playerWidth = 20;
	final static int playerHeight = 30;

	final static int xResolution = 1024;
	final static int yResolution = 768;

	final static int rightWidth1024 = 768;
	final static int leftWidth1024 = 256;
	final static int topHeight1024 = 576;
	final static int bottomHeight1024 = 192;
	final static int scheduleHeight1024 = 816;
	final static int shouldBe0 = -48;
	final static int digSuccessLimit = 100;
	
	
	static int gameSpeed = 20;

	static double resolutionMultiplier = 1;

	final static Schedule schedule = new Schedule();

	static List<AICharacter> characterList;
	static PlayerCharacter playerCharacter;
	static List<AbstractCharacter> allCharacters;

	static GameLogic gameLogic;
	static CharacterPieces characterPieces;
	
	static int framesPerSecond = 60;
	
	
	public static int getGameSpeed()
	{
		return gameSpeed;
	}

	public static int getWeaponBonus()
	{
		return weaponBonus;
	}

	public static int getFightRandom()
	{
		return fightRandom;
	}

	public static int getfightWinningsMultiplier()
	{
		return fightWinningsMultiplier;
	}

	public static void setCharacterList(List<AICharacter> _characterList)
	{
		characterList = _characterList;

	}

	public static List<AICharacter> getCharacterList()
	{
		return characterList;
	}

	public static int getLostinfluenceonlostfight()
	{
		return lostInfluenceOnLostFight;
	}

	public static int getLosthealthonlostfight()
	{
		return lostHealthOnLostFight;
	}

	public static int getWeakestwinsfightmultiplier()
	{
		return weakestWinsFightMultiplier;
	}

	public static int getStrongerwinsfightmultiplier()
	{
		return strongerWinsFightMultiplier;
	}

	public static double getDigadvancementimportance()
	{
		return digAdvancementImportance;
	}

	public static double getGuardawarenessimportance()
	{
		return guardAwarenessImportance;
	}

	public static int getPlayerwidth()
	{
		return (int) (playerWidth * resolutionMultiplier);
	}

	public static int getPlayerheight()
	{
		return (int) (playerHeight * resolutionMultiplier);
	}

	public static PlayerCharacter getPlayerCharacter()
	{
		return playerCharacter;
	}

	public static void setPlayerCharacter(PlayerCharacter playerCharacter)
	{
		Variables.playerCharacter = playerCharacter;
	}

	public static Schedule getSchedule()
	{
		return schedule;
	}

	public static int getRightwidth1024()
	{
		return rightWidth1024;
	}

	public static int getLeftwidth1024()
	{
		return leftWidth1024;
	}

	public static int getTopheight1024()
	{
		return topHeight1024;
	}

	public static int getBottomheight1024()
	{
		return bottomHeight1024;
	}

	public static List<AbstractCharacter> getAllCharacters()
	{
		allCharacters = new ArrayList<>();
		for (AICharacter aiCharacter : characterList)
		{
			allCharacters.add(aiCharacter);

		}
		allCharacters.add(playerCharacter);
		return allCharacters;

	}

	public static GameLogic getGameLogic()
	{
		return gameLogic;
	}

	public static void setGameLogic(GameLogic gameLogic)
	{
		Variables.gameLogic = gameLogic;
	}

	public static int getScheduleheight1024()
	{
		return scheduleHeight1024;
	}

	public static int getShouldbe0()
	{
		return shouldBe0;
	}

	public static int getXresolution()
	{
		return xResolution;
	}

	public static int getYresolution()
	{
		return yResolution;
	}

	public static double getResolutionmultiplier()
	{
		return resolutionMultiplier;
	}

	public static int getDigsuccesslimit()
	{
		return digSuccessLimit;
	}

	public static void setGameSpeed(int gameSpeed)
	{
		Variables.gameSpeed = gameSpeed;
	}

	public static CharacterPieces getCharacterPieces()
	{
		return characterPieces;
	}

	public static void setCharacterPieces(CharacterPieces characterPieces)
	{
		Variables.characterPieces = characterPieces;
	}

	public static double getResolutionMultiplier()
	{
		return resolutionMultiplier;
	}

	public static void setResolutionMultiplier(double resolutionMultiplier)
	{
		Variables.resolutionMultiplier = resolutionMultiplier;
	}

	public static int getFramesPerSecond()
	{
		return framesPerSecond;
	}

	public static void setFramesPerSecond(int framesPerSecond)
	{
		Variables.framesPerSecond = framesPerSecond;
	}
}
