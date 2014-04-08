package places;

import java.util.ArrayList;

import schedule.WellBeing;

public class Cell extends Place
{
	public Cell()
	{
		name = "Cell";
		possibleActions.add(new WellBeing());
	}
}
