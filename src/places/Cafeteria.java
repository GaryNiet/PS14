package places;

import java.util.ArrayList;

import schedule.WellBeing;

public class Cafeteria extends Place
{
	public Cafeteria()
	{
		name = "Cafeteria";
		possibleActions.add(new WellBeing());
		
	}
}
