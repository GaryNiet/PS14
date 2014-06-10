package schedule;

import logic.Variables;
import characters.AbstractCharacter;

public class Evasion extends PrisonAction
{
	public Evasion()
	{
		name = "evasion";
		
		information = "with the right combination of luck, skill and preparation you might ba able to leave this place";
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
		if(character.getSchedule().getPlace(time).getDigAdvancement() >= Variables.getDigsuccesslimit())
		{
			placeSuccessRate += 0.2;
		}
		double successRate = placeSuccessRate * character.getInfluence()/1000 * character.getStrength()/20 * character.getIntelligence()/20;
		return successRate;
	}
	



}
