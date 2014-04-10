package schedule;

import characters.CharacterPH;

public class StealWeaponTool extends PrisonAction
{
	public StealWeaponTool()
	{
		name = "steal weapon of tool";
	}

	@Override
	public void resolve(CharacterPH character, int time)
	{
		character.setWeapon(true);
		character.setTool(true);
		
	}
}
