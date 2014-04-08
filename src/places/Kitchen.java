package places;

import java.util.ArrayList;

import schedule.WellBeing;

public class Kitchen extends Place
{
	public Kitchen()
	{
		name = "Kitchen";
		possibleActions.add(new WellBeing());
	}
}
