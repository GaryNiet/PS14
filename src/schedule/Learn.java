package schedule;

import java.util.ArrayList;
import java.util.List;

import places.Library;
import places.Place;
import characters.AICharacter;

public class Learn extends PrisonAction
{
	public Learn()
	{
		name = "learn";
	}
	
	public void resolve(AICharacter character, int time, boolean isReal)
	{
		character.setIntelligence(character.getIntelligence() + 1/(character.getIntelligence()*0.3));
	}
	
	public static List<Place> getPlaces()
	{
		List<Place> placeList = new ArrayList<>();
		placeList.add(new Library());
		
		return placeList;
	}


}
