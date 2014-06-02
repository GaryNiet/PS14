package places;


import logic.Variables;
import schedule.ResolveLegal;
import schedule.WellBeing;

public class PhoneBooth extends Place
{
	public PhoneBooth()
	{
		
		posX = (int) (0.195 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		posY = (int) (0.234 * Variables.getYresolution() * Variables.getResolutionmultiplier());
		sizeX = (int) (0.068 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		sizeY = (int) ((0.0911) * Variables.getYresolution() * Variables.getResolutionmultiplier());
		
		
		resolveLegalSR = 1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		digAdvancement = 0;
		
		
		name = "phone booth";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
	
	public PhoneBooth(PhoneBooth _phoneBooth)
	{
		
		resolveLegalSR = _phoneBooth.resolveLegalSR;
		
		attackSR = _phoneBooth.attackSR;
		blackmailSR = _phoneBooth.blackmailSR;
		corruptSR = _phoneBooth.corruptSR;
		digSR = _phoneBooth.digSR;
		
		digAdvancement = _phoneBooth.digAdvancement;
		guardAwareness = _phoneBooth.guardAwareness;
		
		name = "phone booth";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
}
