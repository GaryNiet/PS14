package places;

import java.util.ArrayList;

import schedule.WellBeing;

public class PhoneBooth extends Place
{
	public PhoneBooth()
	{
		name = "Phone booth";
		possibleActions.add(new WellBeing());
	}
}
