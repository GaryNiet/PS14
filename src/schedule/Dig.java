package schedule;

import java.util.ArrayList;
import java.util.List;

import logic.Variables;

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
import characters.PlayerCharacter;

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
			informPlayer(character, time);
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
	
	private void informPlayer(AbstractCharacter character, int time)
	{
		if(character instanceof PlayerCharacter)
		{
			if(character.getSchedule().getPlace(time).getDigAdvancement() >= 0.1)
			{
				Variables.getGameLogic().getUserInterface().getWarningWindow().setImage("digAdvacement finished");
				Variables.getGameLogic().getUserInterface().setInfo(true);
			}
		}
	}
	
	
}
