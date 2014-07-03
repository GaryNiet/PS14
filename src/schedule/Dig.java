package schedule;

import logic.Variables;
import characters.AbstractCharacter;
import characters.PlayerCharacter;

@SuppressWarnings("serial")
public class Dig extends PrisonAction
{
	public Dig()
	{
		name = "dig";
		
		information = "this digs an escape route in the current location";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		if(isReal == false)
		{
			character.setHealth((int) (character.getHealth()-(5 / (character.getStrength()/20))));
			character.getSchedule().getPlace(time).setDigAdvancement((int) (character.getSchedule().getPlace(time).getDigAdvancement() +(character.getStrength())));
			if(character.isWeapon() == true)
			{
				character.getSchedule().getPlace(time).setDigAdvancement((int) (character.getSchedule().getPlace(time).getDigAdvancement() + 5 ));
			}
			
		}
		else if(isReal == true && success(character, time) == true)
		{
			character.setHealth((int) (character.getHealth()-(5 / (character.getStrength()/20))));
			character.getSchedule().getPlace(time).setDigAdvancement((int) (character.getSchedule().getPlace(time).getDigAdvancement() +(character.getStrength())));
			informPlayer(character, time);
			
			if(character.isWeapon() == true)
			{
				character.getSchedule().getPlace(time).setDigAdvancement((int) (character.getSchedule().getPlace(time).getDigAdvancement() + 5 ));
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
		double successRate = (character.getIntelligence()/20) * character.getSchedule().getPlace(time).getDigSR();
		return successRate;
	}
	
	private void informPlayer(AbstractCharacter character, int time)
	{
		if(character instanceof PlayerCharacter)
		{
			if(character.getSchedule().getPlace(time).getDigAdvancement() >= Variables.getDigsuccesslimit())
			{
				Variables.getGameLogic().getUserInterface().getWarningWindow().setImage("there's a hole in the wall now", false);
				Variables.getGameLogic().getUserInterface().setInfo(true);
			}
		}
	}
	
	
}
