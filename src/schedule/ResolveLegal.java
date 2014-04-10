package schedule;

import characters.CharacterPH;

public class ResolveLegal extends PrisonAction
{
	public ResolveLegal()
	{
		name = "resolve legal";
	}

	@Override
	public void resolve(CharacterPH character, int time)
	{
		character.setLegalAdvancement(character.getLegalAdvancement() + 1/character.getLegalAdvancement());
		
	}
	
}
