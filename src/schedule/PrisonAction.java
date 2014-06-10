package schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import logic.Variables;

import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.PhoneBooth;
import places.Place;
import places.Showers;
import places.VisitingCell;
import characters.AICharacter;
import characters.AbstractCharacter;

public abstract class PrisonAction
{
	public String name;
	public abstract void resolve(AbstractCharacter character, int time, boolean isReal);
	Random random = new Random();
	double randomDraw;
	String information;
	
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
	
	
	public String getInformation()
	{
		return information;
	}
	
	protected abstract boolean success(AbstractCharacter character, int time);
	public abstract double successRate(AbstractCharacter character, int time);
	
}


