package schedule;

import characters.CharacterPH;

public class Blackmail extends PrisonAction
{
	public Blackmail()
	{
		name = "blackmail";
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
