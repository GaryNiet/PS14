package schedule;

import characters.CharacterPH;

public class Learn extends PrisonAction
{
	public Learn()
	{
		name = "intelligence";
	}
	
	public void resolve(CharacterPH character, int time)
	{
		character.setIntelligence(character.getIntelligence()+1);
	}
}
