package schedule;

import characters.CharacterPH;

public class WellBeing extends PrisonAction
{
	
	public WellBeing()
	{
		name = "health";
	}
	public void resolve(CharacterPH character)
	{
		character.setHealth(character.getHealth()+12);
		if(character.getHealth() > 100)
		{
			character.setHealth(100);
		}
	}
}
