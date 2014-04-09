package schedule;

import characters.CharacterPH;

public class StealWeaponTool extends PrisonAction
{
	public StealWeaponTool()
	{
		name = "steal weapon of tool";
	}

	@Override
	public void resolve(CharacterPH character)
	{
		character.setHealth(character.getHealth()+1);
		if(character.getHealth() > 100)
		{
			character.setHealth(100);
		}
		
	}
}
