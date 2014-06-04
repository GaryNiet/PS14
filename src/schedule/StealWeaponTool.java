package schedule;

import java.util.ArrayList;
import java.util.List;

import places.Cafeteria;
import places.Kitchen;
import places.Place;
import places.Workshop;
import characters.AICharacter;
import characters.AbstractCharacter;

public class StealWeaponTool extends PrisonAction
{
	public StealWeaponTool()
	{
		name = "stealWT";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		if(isReal == false)
		{
			character.setWeapon(true);
			character.setTool(true);
		}
		else if(isReal == true && success(character, time) == true)
		{
			character.setWeapon(true);
			character.setTool(true);
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
		double successRate = (character.getIntelligence()/20) * character.getSchedule().getPlace(time).getStealWeaponToolSR();
		return successRate;
	}
	



}
