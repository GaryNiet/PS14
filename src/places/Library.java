package places;

import java.util.ArrayList;

import schedule.IntelligenceAction;

public class Library extends Place
{
	public Library()
	{
		possibleActions = new ArrayList<>();
		name = "Library";
		possibleActions.add(new IntelligenceAction());
	}
	
}
