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
		character.setHealth(character.getHealth()-2);
		character.getSchedule().getPlace(time).setDigAdvancement(character.getSchedule().getPlace(time).getDigAdvancement() + 1 );
		
	}
	
	
}
