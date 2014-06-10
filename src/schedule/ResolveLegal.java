package schedule;

import characters.AbstractCharacter;

public class ResolveLegal extends PrisonAction
{
	public ResolveLegal()
	{
		name = "resolveLegal";
		
		information = "try and get out, the right way";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		if(isReal == false)
		{
			character.setLegalAdvancement(character.getLegalAdvancement() + (1/character.getLegalAdvancement()) * character.getIntelligence());
		}
		else if(isReal == true && success(character, time) == true)
		{
			character.setLegalAdvancement(character.getLegalAdvancement() + (1/character.getLegalAdvancement()) * character.getIntelligence());
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
		double successRate = (character.getIntelligence()/20) * character.getSchedule().getPlace(time).getResolveLegalSR();
		return successRate;
	}
	



	
}
