package schedule;

import java.util.ArrayList;
import java.util.List;

import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.PhoneBooth;
import places.Place;
import places.Showers;
import places.VisitingCell;
import characters.CharacterPH;

public class WellBeing extends PrisonAction
{
	
	public WellBeing()
	{
		name = "wellbeing";
	}
	public void resolve(CharacterPH character, int time)
	{
		
		character.setHealth(character.getHealth()+10);
		character.checkHealthIntegrity();
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
		
		return placeList;
	}

}