package schedule;

import characters.CharacterPH;

public class Dig extends PrisonAction
{
	public Dig()
	{
		name = "dig";
	}

	@Override
	public void resolve(CharacterPH character, int time)
	{
		character.setHealth(character.getHealth()+1);
		if(character.getHealth() > 100)
		{
			character.setHealth(100);
		}
	}
	
	
}
