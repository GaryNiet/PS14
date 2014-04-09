package places;


import schedule.ResolveLegal;
import schedule.WellBeing;

public class PhoneBooth extends Place
{
	public PhoneBooth()
	{
		name = "Phone booth";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
}
