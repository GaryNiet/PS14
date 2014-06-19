package schedule;

import characters.AbstractCharacter;

public class Study extends PrisonAction
{
	
	public Study()
	{
		name = "study";
		
		information = "study the materials you have, you would suprised how much you can learn just from trying and understanding how every day objects work.";
	}

	@Override
	public void resolve(AbstractCharacter character, int time, boolean isReal)
	{
		if(character.getMaterials() >= 10)
		{
			character.setIntelligence(character.getIntelligence() + 0.5/(character.getIntelligence()*0.3));
			character.setMaterials(character.getMaterials() - 10);
		}
		
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
