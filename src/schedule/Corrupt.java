package schedule;

import characters.CharacterPH;

public class Corrupt extends PrisonAction
{
	public Corrupt()
	{
		name = "corrupt";
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
