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
	public void resolve(AICharacter character, int time, boolean isReal)
	{
		character.setWeapon(true);
		character.setTool(true);
		
	}
	
	public static List<Place> getPlaces()
	{
		List<Place> placeList = new ArrayList<>();
		placeList.add(new Kitchen());
		placeList.add(new Workshop());
		placeList.add(new Cafeteria());
		
		return placeList;
	}


}
