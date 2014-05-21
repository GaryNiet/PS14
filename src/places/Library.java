package places;


import schedule.Learn;

public class Library extends Place
{
	public Library()
	{
		
		posX = 330;
		posY = 210;
		sizeX = 175;
		sizeY = 160;
		
		
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
		guardAwareness = _library.guardAwareness;
		
		name = "library";
		possibleActions.add(new Learn());
	}
	
}
