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

public class ResolveLegal extends PrisonAction
{
	public ResolveLegal()
	{
		name = "resolveLegal";
	}

	@Override
	public void resolve(CharacterPH character, int time)
	{
		character.setLegalAdvancement(character.getLegalAdvancement() + 1/character.getLegalAdvancement());
		
	}
	
	public static List<Place> getPlaces()
	{
		List<Place> placeList = new ArrayList<>();
		placeList.add(new VisitingCell());
		placeList.add(new PhoneBooth());
		
		return placeList;
	}
	
}
