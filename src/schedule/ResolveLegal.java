package schedule;

import logic.Variables;
import characters.AbstractCharacter;

@SuppressWarnings("serial")
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
			if(character.getLegalAdvancement() >= 50)
			{
				informPlayer(character, time);
			}
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
		double successRate = (character.getIntelligence()/10) * character.getSchedule().getPlace(time).getResolveLegalSR();
		return successRate;
	}
	
	private void informPlayer(AbstractCharacter character, int time)
	{
		if(character == Variables.getPlayerCharacter())
		{
				Variables.getGameLogic().getUserInterface().getWarningWindow().setImage("after " + Variables.getGameLogic().getDayCounter() + " in prison, you are free to go", true);
				Variables.getGameLogic().getUserInterface().setInfo(true);
		}
	}
	



	
}
