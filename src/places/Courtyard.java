package places;


import schedule.Sell;
import schedule.Train;
import schedule.WellBeing;

public class Courtyard extends Place
{
	
	public Courtyard()
	{
		name = "Courtyard";
		possibleActions.add(new Train());
		possibleActions.add(new WellBeing());
		possibleActions.add(new Sell());
	}

}
