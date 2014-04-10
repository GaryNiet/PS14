package places;


import schedule.Steal;
import schedule.WellBeing;

public class Cell extends Place
{
	public Cell()
	{
		name = "Cell";
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		stealSR = 1;
		
		
		
		
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
	}
}
