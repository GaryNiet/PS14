package schedule;

import characters.CharacterPH;

public class Steal extends PrisonAction
{
	public Steal()
	{
		name = "steal";
	}

	@Override
	public void resolve(CharacterPH character, int time)
	{
		character.setMaterials(character.getMaterials() + 10);
	}
}
