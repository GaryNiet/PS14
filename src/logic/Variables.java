package logic;

import java.util.ArrayList;
import java.util.List;

import places.Place;
import schedule.Schedule;

import characters.AICharacter;
import characters.AbstractCharacter;
import characters.PlayerCharacter;

public class Variables
{

	final static int weaponBonus = 3;
	final static int fightRandom = 3;
	final static int fightWinningsMultiplier = 5;
	final static int lostInfluenceOnLostFight = 3;
	final static int lostHealthOnLostFight = 8;
	final static int weakestWinsFightMultiplier = 3;
	final static int strongerWinsFightMultiplier = 2;
	final static double digAdvancementImportance = 1;
	final static double guardAwarenessImportance = 12;
	final static int playerWidth = 15;
	final static int playerHeight = 20;
	
	final static int rightWidth1024 = 768;
	final static int leftWidth1024 = 256;
	final static int topHeight1024 = 576;
	final static int bottomHeight1024 = 192;
	final static int scheduleHeight1024 = 816;
	final static int shouldBe0 = -48;
	
	
	
	
	final static Schedule schedule = new Schedule();
	
	
	static List<AICharacter> characterList;
	static PlayerCharacter playerCharacter;
	static List<AbstractCharacter> allCharacters;
	
	static GameLogic gameLogic;
	
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

	public static void setCharacterList(List<AICharacter> _characterList) {
		characterList = _characterList;
		
	}
	
	public static List<AICharacter> getCharacterList()
	{
		return characterList;
	}

	public static int getLostinfluenceonlostfight() {
		return lostInfluenceOnLostFight;
	}

	public static int getLosthealthonlostfight() {
		return lostHealthOnLostFight;
	}

	public static int getWeakestwinsfightmultiplier() {
		return weakestWinsFightMultiplier;
	}

	public static int getStrongerwinsfightmultiplier() {
		return strongerWinsFightMultiplier;
	}

	public static double getDigadvancementimportance() {
		return digAdvancementImportance;
	}

	public static double getGuardawarenessimportance() {
		return guardAwarenessImportance;
	}

	public static int getPlayerwidth() {
		return playerWidth;
	}

	public static int getPlayerheight() {
		return playerHeight;
	}

	public static PlayerCharacter getPlayerCharacter() {
		return playerCharacter;
	}

	public static void setPlayerCharacter(PlayerCharacter playerCharacter) {
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
		for(AICharacter aiCharacter: characterList)
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
}
