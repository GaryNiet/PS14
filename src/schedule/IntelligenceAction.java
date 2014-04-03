package schedule;

import characters.CharacterPH;

public class IntelligenceAction extends PrisonAction
{
	public IntelligenceAction()
	{
		
	}
	
	public void resolve(CharacterPH character)
	{
		character.setIntelligence(character.getIntelligence()+1);
	}
}
