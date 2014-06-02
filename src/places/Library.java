package places;


import logic.Variables;
import schedule.Learn;

public class Library extends Place
{
	public Library()
	{
		
		
		
		posX = (int) (0.3222 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		posY = (int) (0.273 * Variables.getYresolution() * Variables.getResolutionmultiplier());
		sizeX = (int) (0.1708 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		sizeY = (int) ((0.208) * Variables.getYresolution() * Variables.getResolutionmultiplier());
		
		
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
