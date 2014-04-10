package schedule;

import characters.CharacterPH;

public class Blackmail extends PrisonAction
{
	public Blackmail()
	{
		name = "blackmail";
	}

	@Override
	public void resolve(CharacterPH character, int time)
	{
		character.setInfluence(character.getInfluence() - 50);
		System.out.println(character.getSchedule().getPlace(0));
		//character.getSchedule().getPlace(time).setGuardAwareness(character.getSchedule().getPlace(time).getGuardAwareness() - 5);
	
		
	}
	
}
