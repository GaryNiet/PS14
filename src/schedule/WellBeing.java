package schedule;

import characters.AbstractCharacter;

public class WellBeing extends PrisonAction
{
	
	public WellBeing()
	{
		name = "wellbeing";
		
		information = "resting can become useful sometimes";
	}
	
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		
		character.setHealth(character.getHealth()+15);
		character.checkHealthIntegrity();
	}

	@Override
	protected boolean success(AbstractCharacter character, int time)
	{
		return true;
	}

	@Override
	public double successRate(AbstractCharacter character, int time)
	{
		return 1;
	}
	



}