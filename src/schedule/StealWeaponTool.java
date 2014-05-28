package schedule;

import java.util.ArrayList;
import java.util.List;

import places.Cafeteria;
import places.Kitchen;
import places.Place;
import places.Workshop;
import characters.AICharacter;

public class StealWeaponTool extends PrisonAction
{
	public StealWeaponTool()
	{
		name = "stealWT";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		character.setWeapon(true);
		character.setTool(true);
		
	}
	



}
