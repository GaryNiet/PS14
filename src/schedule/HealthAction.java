package schedule;

import characters.CharacterPH;

public class HealthAction extends PrisonAction
{
	
	public HealthAction()
	{
		name = "health";
	}
	public void resolve(CharacterPH character)
	{
		character.setHealth(character.getHealth()+1);
	}
}
