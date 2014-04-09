package places;


import schedule.Steal;
import schedule.WellBeing;

public class Cell extends Place
{
	public Cell()
	{
		name = "Cell";
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
	}
}
