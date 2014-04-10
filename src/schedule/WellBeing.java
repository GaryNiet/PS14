package schedule;

import characters.CharacterPH;

public class WellBeing extends PrisonAction
{
	
	public WellBeing()
	{
		name = "health";
	}
	public void resolve(CharacterPH character, int time)
	{
		
		character.setHealth(character.getHealth()+10);
		character.checkHealthIntegrity();
	}
}