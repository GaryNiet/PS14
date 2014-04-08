package places;

import java.util.ArrayList;

import schedule.WellBeing;

public class Showers extends Place
{
	public Showers()
	{
		name = "Showers";
		possibleActions.add(new WellBeing());
	}
	
}
