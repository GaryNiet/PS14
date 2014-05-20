package logic;

import java.util.List;

import characters.CharacterPH;

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
	
	
	static List<CharacterPH> characterList;
	
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

	public static void setCharacterList(List<CharacterPH> _characterList) {
		characterList = _characterList;
		
	}
	
	public static List<CharacterPH> getCharacterList()
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
}