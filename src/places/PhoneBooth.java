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
		
		
		resolveLegalSR = 0.8;
		
		attackSR = 0.3;
		blackmailSR = 0.2;
		corruptSR = 0.2;
		digSR = 0.1;
		evasionSR = 0.05;
		digAdvancement = 0;
		
		
		name = "phone booth";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
		
		information = "noisy and heavily guarded, this is the only access to phones though";
	}
	
	public PhoneBooth(PhoneBooth _phoneBooth)
	{
		
		resolveLegalSR = _phoneBooth.resolveLegalSR;
		
		attackSR = _phoneBooth.attackSR;
		blackmailSR = _phoneBooth.blackmailSR;
		corruptSR = _phoneBooth.corruptSR;
		digSR = _phoneBooth.digSR;
		evasionSR = _phoneBooth.evasionSR;
		
		digAdvancement = _phoneBooth.digAdvancement;
		guardAwareness = _phoneBooth.guardAwareness;
		
		name = "phone booth";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
}
