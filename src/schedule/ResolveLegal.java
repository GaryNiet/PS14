package schedule;

import characters.CharacterPH;

public class ResolveLegal extends PrisonAction
{
	public ResolveLegal()
	{
		name = "resolve legal";
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
