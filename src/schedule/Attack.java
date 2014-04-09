package schedule;

import characters.CharacterPH;

public class Attack extends PrisonAction
{
	public Attack()
	{
		name = "attack";
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
