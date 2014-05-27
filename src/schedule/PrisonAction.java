package schedule;

import java.util.ArrayList;
import java.util.List;

import logic.Variables;

import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.PhoneBooth;
import places.Place;
import places.Showers;
import places.VisitingCell;
import characters.AICharacter;

public abstract class PrisonAction
{
	public String name;
	public abstract void resolve(AICharacter character, int time, boolean isReal);
	
	public List<Place> getAllPlaces()
	{
		List<Place> returnList = new ArrayList<>();
		
		for(Place place: Variables.getSchedule().getAllPlaces())
		{
			for(PrisonAction action: place.getPossibleActions())
			{
				if(action.getClass() == this.getClass())
				{
					returnList.add(place);
				}
			}
		}
		
		
		
		return returnList;
	}
	
}


