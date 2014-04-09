package places;

import java.util.ArrayList;
import java.util.List;

import schedule.Attack;
import schedule.Blackmail;
import schedule.Corrupt;
import schedule.Dig;
import schedule.Evasion;
import schedule.PrisonAction;

public abstract class Place
{
	public String name;
	public List<PrisonAction> possibleActions;
	
	public Place()
	{
		possibleActions = new ArrayList<>();
		
		//possibleActions.add(new Attack());
		possibleActions.add(new Blackmail());
		possibleActions.add(new Corrupt());
		possibleActions.add(new Dig());
		possibleActions.add(new Evasion());
	}
	
}
