package schedule;

import logic.Variables;
import characters.AbstractCharacter;
import characters.PlayerCharacter;

public class StealWeaponTool extends PrisonAction
{
	public StealWeaponTool()
	{
		name = "stealWT";
		
		information = "try and get some tool of weapon to give you an edge in combat";
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
	
	private void informPlayer(AbstractCharacter character, int time)
	{
		if(character instanceof PlayerCharacter)
		{
				Variables.getGameLogic().getUserInterface().getWarningWindow().setImage("you now own a weapon", false);
				Variables.getGameLogic().getUserInterface().setInfo(true);
		}
	}

	@Override
	public double successRate(AbstractCharacter character, int time)
	{
		double successRate = (character.getIntelligence()/20) * character.getSchedule().getPlace(time).getStealWeaponToolSR();
		return successRate;
	}
	



}
