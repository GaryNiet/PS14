package logic;

import java.util.List;

import characters.CharacterPH;

public class Variables
{

	final static int weaponBonus = 3;
	final static int fightRandom =3;
	final static int fightWinningsMultiplier = 10;
	
	
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
}
