package schedule;

import characters.CharacterPH;

public class IntelligenceAction extends PrisonAction
{
	public IntelligenceAction()
	{
		name = "intelligence";
	}
	
	public void resolve(CharacterPH character)
	{
		character.setIntelligence(character.getIntelligence()+1);
	}
}
