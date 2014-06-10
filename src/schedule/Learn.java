package schedule;

import characters.AbstractCharacter;

public class Learn extends PrisonAction
{
	public Learn()
	{
		name = "learn";
		
		information = "read some books. become a smarter human being";
	}
	
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		character.setIntelligence(character.getIntelligence() + 1/(character.getIntelligence()*0.3));
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
