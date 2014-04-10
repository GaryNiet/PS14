package places;


import schedule.Learn;

public class Library extends Place
{
	public Library()
	{
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		digAdvancement = 0;
		
		
		name = "Library";
		possibleActions.add(new Learn());
	}
	
}
