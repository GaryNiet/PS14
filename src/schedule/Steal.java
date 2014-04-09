package schedule;

import characters.CharacterPH;

public class Steal extends PrisonAction
{
	public Steal()
	{
		name = "steal";
	}

	@Override
	public void resolve(CharacterPH character)
	{
		character.setHealth(character.getHealth()+12);
		if(character.getHealth() > 100)
		{
			character.setHealth(100);
		}
		
	}
}
