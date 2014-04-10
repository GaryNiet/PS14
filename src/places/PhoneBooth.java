package places;


import schedule.ResolveLegal;
import schedule.WellBeing;

public class PhoneBooth extends Place
{
	public PhoneBooth()
	{
		
		resolveLegalSR = 1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		
		name = "Phone booth";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
}
