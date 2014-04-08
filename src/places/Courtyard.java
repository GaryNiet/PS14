package places;

import java.util.ArrayList;

import schedule.StrengthAction;

public class Courtyard extends Place
{
	
	public Courtyard()
	{
		possibleActions = new ArrayList<>();
		name = "Courtyard";
		possibleActions.add(new StrengthAction());
	}

}
