package places;


import schedule.Steal;
import schedule.WellBeing;

public class Showers extends Place
{
	public Showers()
	{
		name = "Showers";
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
	}
	
}
