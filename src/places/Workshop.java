package places;

import java.util.ArrayList;

import schedule.WellBeing;


public class Workshop extends Place
{
	public Workshop()
	{
		name = "Workshop";
		possibleActions.add(new WellBeing());
	}
}
