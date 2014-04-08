package schedule;

import characters.CharacterPH;

public class Learn extends PrisonAction
{
	public Learn()
	{
		name = "intelligence";
	}
	
	public void resolve(CharacterPH character)
	{
		character.setIntelligence(character.getIntelligence()+1);
	}
}
