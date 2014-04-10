package schedule;

import characters.CharacterPH;

public class Blackmail extends PrisonAction
{
	
	final int guardAwarenessChange = 5;
	final int influenceChange = 50;
	
	public Blackmail()
	{
		name = "blackmail";
	}

	@Override
	public void resolve(CharacterPH character, int time)
	{
		int influence = character.getInfluence();
		if(influence >= influenceChange)
		{
			character.setInfluence(influence - influenceChange);
			character.getSchedule().getPlace(time).setGuardAwareness(character.getSchedule().getPlace(time).getGuardAwareness() - guardAwarenessChange);
		
		}
		
		
	}
	
}
