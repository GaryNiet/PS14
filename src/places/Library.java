package places;


import logic.Variables;
import schedule.Learn;

@SuppressWarnings("serial")
public class Library extends Place
{
	public Library()
	{
		
		
		
		posX = (int) (0.3222 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		posY = (int) (0.273 * Variables.getYresolution() * Variables.getResolutionmultiplier());
		sizeX = (int) (0.1708 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		sizeY = (int) ((0.208) * Variables.getYresolution() * Variables.getResolutionmultiplier());
		
		
		attackSR = 0.3;
		blackmailSR = 0.6;
		corruptSR = 0.6;
		digSR = 0.1;
		evasionSR = 0.05;
		digAdvancement = 0;
		
		
		name = "library";
		possibleActions.add(new Learn());
		
		information = "low guard presence and relatively quiet";
	}
	
	public Library(Library _library)
	{
		
		attackSR = _library.attackSR;
		blackmailSR = _library.blackmailSR;
		corruptSR = _library.corruptSR;
		digSR = _library.digSR;
		evasionSR = _library.evasionSR;
		
		digAdvancement = _library.digAdvancement;
		guardAwareness = _library.guardAwareness;
		
		name = "library";
		possibleActions.add(new Learn());
	}
	
}
