package schedule;

import characters.CharacterPH;

public class Evasion extends PrisonAction
{
	public Evasion()
	{
		name = "evasion";
	}

	@Override
	public void resolve(CharacterPH character)
	{
		character.setHealth(character.getHealth()+1);
		if(character.getHealth() > 100)
		{
			character.setHealth(100);
		}
	}
}
