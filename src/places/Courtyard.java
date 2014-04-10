package places;


import schedule.Sell;
import schedule.Train;
import schedule.WellBeing;

public class Courtyard extends Place
{
	
	
	public Courtyard()
	{
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		sellMaterialsSR = 1;
		
		name = "Courtyard";
		possibleActions.add(new Train());
		possibleActions.add(new WellBeing());
		possibleActions.add(new Sell());
	}

}
