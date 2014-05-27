package logic;

import java.util.List;

import places.Place;
import schedule.Schedule;

import characters.AICharacter;
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
	final static int playerWidth = 10;
	final static int playerHeight = 10;
	
	final static Schedule schedule = new Schedule();
	
	
	static List<AICharacter> characterList;
	static PlayerCharacter playerCharacter;
	
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
}
