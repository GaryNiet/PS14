package schedule;

import characters.CharacterPH;

public class StrengthAction extends PrisonAction
{
	public StrengthAction()
	{
		name = "strength";
	}
	
	public void resolve(CharacterPH character)
	{
		character.setStrength(character.getStrength()+1);
	}
}
