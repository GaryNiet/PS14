package places;


import schedule.Steal;
import schedule.WellBeing;

public class Showers extends Place
{
	public Showers()
	{
		
		stealSR = 1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		digAdvancement = 0;
		
		
		name = "Showers";
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
	}
	
}
