package places;

import java.util.ArrayList;

import schedule.Train;

public class Courtyard extends Place
{
	
	public Courtyard()
	{
		name = "Courtyard";
		possibleActions.add(new Train());
	}

}
