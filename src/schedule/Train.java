package schedule;

import characters.CharacterPH;

public class Train extends PrisonAction
{
	public Train()
	{
		name = "strength";
	}
	
	public void resolve(CharacterPH character, int time)
	{
		character.setStrength(character.getStrength()+1/character.getStrength());
	}
}
