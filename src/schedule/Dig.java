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
import characters.AbstractCharacter;

public class Dig extends PrisonAction
{
	public Dig()
	{
		name = "dig";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		if(isReal == false)
		{
			character.setHealth(character.getHealth()-2);
			character.getSchedule().getPlace(time).setDigAdvancement(character.getSchedule().getPlace(time).getDigAdvancement() +1);
		}
		else if(isReal == true && success(character, time) == true)
		{
			character.setHealth(character.getHealth()-2);
			character.getSchedule().getPlace(time).setDigAdvancement(character.getSchedule().getPlace(time).getDigAdvancement() +1);
		}
	}

	@Override
	protected boolean success(AbstractCharacter character, int time)
	{
		if(random.nextFloat() < successRate(character, time))
		{
			return true;
		}
		return false;
	}

	@Override
	public double successRate(AbstractCharacter character, int time)
	{
		double successRate = (character.getStrength()/20) * character.getSchedule().getPlace(time).getDigSR();
		return successRate;
	}
	
	
}
