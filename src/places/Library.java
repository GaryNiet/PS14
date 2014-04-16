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
		
		
		name = "library";
		possibleActions.add(new Learn());
	}
	
	public Library(Library _library)
	{
		
		attackSR = _library.attackSR;
		blackmailSR = _library.blackmailSR;
		corruptSR = _library.corruptSR;
		digSR = _library.digSR;
		
		digAdvancement = _library.digAdvancement;
		
		
		name = "library";
		possibleActions.add(new Learn());
	}
	
}
