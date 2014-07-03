package schedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import logic.Variables;
import places.Place;
import characters.AbstractCharacter;

@SuppressWarnings("serial")
public abstract class PrisonAction implements Serializable
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
			for(PrisonAction action: place.getActions())
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


