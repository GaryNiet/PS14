package schedule;

import java.util.ArrayList;
import java.util.List;

import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.Kitchen;
import places.Library;
import places.PhoneBooth;
import places.Place;
import places.Showers;
import places.VisitingCell;
import places.Workshop;
import characters.AICharacter;

public class Blackmail extends PrisonAction
{
	
	final int guardAwarenessChange = 5;
	final int influenceChange = 50;
	
	public Blackmail()
	{
		name = "blackmail";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		int influence = character.getInfluence();
		if(influence >= influenceChange)
		{
			character.setInfluence(influence - influenceChange);
			character.getSchedule().getPlace(time).setGuardAwareness(character.getSchedule().getPlace(time).getGuardAwareness() - guardAwarenessChange);
		
		}
		
		
	}



	
}
