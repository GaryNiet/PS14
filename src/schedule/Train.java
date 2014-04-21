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

public class Train extends PrisonAction
{
	public Train()
	{
		name = "train";
	}
	
	public void resolve(CharacterPH character, int time, boolean isReal)
	{
		character.setStrength(character.getStrength()+1/(character.getStrength()*0.3));
	}
	
	public static List<Place> getPlaces()
	{
		List<Place> placeList = new ArrayList<>();
		placeList.add(new Courtyard());
		
		return placeList;
	}


}
