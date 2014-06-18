package places;


import logic.Variables;
import schedule.Steal;
import schedule.WellBeing;

public class Showers extends Place
{
	public Showers()
	{
		
		
		posX = (int) (0.637 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		posY = (int) (0.052 * Variables.getYresolution() * Variables.getResolutionmultiplier());
		sizeX = (int) (0.0878 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		sizeY = (int) ((0.2604) * Variables.getYresolution() * Variables.getResolutionmultiplier());
		
		
		
		stealSR = 0.9;
		
		attackSR = 0.9;
		blackmailSR = 0.4;
		corruptSR = 0.4;
		digSR = 0.8;
		evasionSR = 0.05;
		digAdvancement = 0;
		
		
		name = "showers";
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
		
		information = "naked people rarely hide weapons";
	}
	
	public Showers(Showers _showers)
	{
		
		stealSR = _showers.stealSR;
		
		attackSR = _showers.attackSR;
		blackmailSR = _showers.blackmailSR;
		corruptSR = _showers.corruptSR;
		digSR = _showers.digSR;
		evasionSR = _showers.evasionSR;
		
		digAdvancement = _showers.digAdvancement;
		guardAwareness = _showers.guardAwareness;
		
		name = "showers";
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
	}
	
}
