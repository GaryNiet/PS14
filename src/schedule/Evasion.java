package schedule;

import java.util.ArrayList;
import java.util.List;

import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.Kitchen;
import places.Library;
import places.PhoneBooth;
import places.Place;
import places.Showers;
import places.VisitingCell;
import places.Workshop;
import characters.AICharacter;

public class Evasion extends PrisonAction
{
	public Evasion()
	{
		name = "evasion";
	}

	@Override
	public void resolve(AICharacter character, int time, boolean isReal)
	{
		//TODO
		character.setHealth(character.getHealth()+1);
		if(character.getHealth() > 100)
		{
			character.setHealth(100);
		}
	}
	
	public static List<Place> getPlaces()
	{
		List<Place> placeList = new ArrayList<>();
		placeList.add(new Cell());
		placeList.add(new Courtyard());
		placeList.add(new Cafeteria());
		placeList.add(new Showers());
		placeList.add(new VisitingCell());
		placeList.add(new PhoneBooth());
		placeList.add(new Workshop());
		placeList.add(new Kitchen());
		placeList.add(new Library());
		
		return placeList;
	}


}
