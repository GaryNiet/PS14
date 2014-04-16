package schedule;

import java.util.ArrayList;
import java.util.List;

import places.Library;
import places.Place;
import characters.CharacterPH;

public class Learn extends PrisonAction
{
	public Learn()
	{
		name = "intelligence";
	}
	
	public void resolve(CharacterPH character, int time)
	{
		character.setIntelligence(character.getIntelligence() + 1/character.getIntelligence());
	}
	
	public static List<Place> getPlaces()
	{
		List<Place> placeList = new ArrayList<>();
		placeList.add(new Library());
		
		return placeList;
	}
}
