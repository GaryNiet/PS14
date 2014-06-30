package schedule;

import logic.Variables;
import characters.AbstractCharacter;

public class Blackmail extends PrisonAction
{
	
	final int guardAwarenessChange = 5;
	final int influenceChange = 50;
	
	public Blackmail()
	{
		name = "blackmail";
		
		information = "this lowers the guard awareness in the current location \n at the cost of influence";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		int influence = character.getInfluence();
		if(influence >= influenceChange && isReal == false)
		{
			character.setInfluence(influence - influenceChange);
			character.getSchedule().getPlace(time).setGuardAwareness(character.getSchedule().getPlace(time).getGuardAwareness() - guardAwarenessChange);
		
		}
		else if(influence >= influenceChange && isReal == true && success(character, time) == true)
		{
			character.setInfluence(influence - influenceChange);
			character.getSchedule().getPlace(time).setGuardAwareness(character.getSchedule().getPlace(time).getGuardAwareness() - guardAwarenessChange);
			//informPlayer(character, time);
			
		}
		
		
	}
	
	private void informPlayer(AbstractCharacter character, int time)
	{
		if(character == Variables.getPlayerCharacter())
		{
				Variables.getGameLogic().getUserInterface().getWarningWindow().setImage("blackmail successful", false);
				Variables.getGameLogic().getUserInterface().setInfo(true);
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
		double successRate = character.getSchedule().getPlace(time).getBlackmailSR() + character.getIntelligence()/20;
		return successRate;
	}
	




	
}
