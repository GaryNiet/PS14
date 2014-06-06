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

public class Evasion extends PrisonAction
{
	public Evasion()
	{
		name = "evasion";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		//TODO

		if(isReal == false)
		{
			character.setEscaped(true);
		}
		else if(isReal == true && success(character, time) == true)
		{
			character.setEscaped(true);
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
		double placeSuccessRate = character.getSchedule().getPlace(time).getEvasionSR();
		if(character.getSchedule().getPlace(time).getDigAdvancement() >= 100)
		{
			placeSuccessRate += 0.2;
		}
		double successRate = placeSuccessRate * character.getInfluence()/1000 * character.getStrength()/20 * character.getIntelligence()/20;
		return successRate;
	}
	



}
