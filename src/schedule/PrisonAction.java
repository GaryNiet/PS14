package schedule;

import places.Place;
import characters.CharacterPH;

public abstract class PrisonAction
{
	public String name;
	public abstract void resolve(CharacterPH character, int time);
}
