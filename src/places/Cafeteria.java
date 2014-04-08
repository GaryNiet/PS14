package places;

import java.awt.List;
import java.util.ArrayList;

import schedule.HealthAction;

public class Cafeteria extends Place
{
	public Cafeteria()
	{
		possibleActions = new ArrayList<>();
		name = "Cafeteria";
		possibleActions.add(new HealthAction());
		
	}
}
