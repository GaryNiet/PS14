package schedule;

import characters.CharacterPH;

public abstract class PrisonAction
{
	public String name;
	public abstract void resolve(CharacterPH character);
}
