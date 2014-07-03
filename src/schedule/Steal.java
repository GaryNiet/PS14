package schedule;

import characters.AbstractCharacter;

@SuppressWarnings("serial")
public class Steal extends PrisonAction
{
	public Steal()
	{
		name = "steal";
		
		information = "steal some materials while no one is watching";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		if(isReal == false)
		{
			character.setMaterials((int) (character.getMaterials() + (character.getIntelligence()/20.0 * character.getStrength()/20.0) * 60));
		}
		else if(isReal == true && success(character, time) == true)
		{
			character.setMaterials((int) (character.getMaterials() + (character.getIntelligence()/20 * character.getStrength()/20) * 60));
			//informPlayer(character, time);
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
		double successRate = (character.getIntelligence()/10) * character.getSchedule().getPlace(time).getStealSR();
		return successRate;
	}
	
	



}
