package places;


import schedule.Learn;

public class Library extends Place
{
	public Library()
	{
		name = "Library";
		possibleActions.add(new Learn());
	}
	
}
