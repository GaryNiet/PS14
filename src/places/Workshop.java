package places;


import schedule.Steal;
import schedule.WellBeing;


public class Workshop extends Place
{
	public Workshop()
	{
		name = "Workshop";
		possibleActions.add(new Steal());
	}
}
