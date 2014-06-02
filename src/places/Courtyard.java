package places;


import logic.Variables;
import schedule.Sell;
import schedule.Train;
import schedule.WellBeing;

public class Courtyard extends Place
{
	
	
	public Courtyard()
	{
		
		
		posX = (int) (0.2441 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		posY = (int) (0.013 * Variables.getYresolution() * Variables.getResolutionmultiplier());
		sizeX = (int) (0.3441 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		sizeY = (int) ((0.1953) * Variables.getYresolution() * Variables.getResolutionmultiplier());
		
		name = "courtyard";
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		sellMaterialsSR = 1;
		
		digAdvancement = 0;
		
		possibleActions.add(new Train());
		possibleActions.add(new WellBeing());
		possibleActions.add(new Sell());
	}
	
	public Courtyard(Courtyard _courtyard)
	{
		
		name = "courtyard";
		
		attackSR = _courtyard.attackSR;
		blackmailSR = _courtyard.blackmailSR;
		corruptSR = _courtyard.corruptSR;
		digSR = _courtyard.digSR;
		sellMaterialsSR = _courtyard.sellMaterialsSR;
		
		guardAwareness = _courtyard.guardAwareness;
		digAdvancement = _courtyard.digAdvancement;
		
		possibleActions.add(new Train());
		possibleActions.add(new WellBeing());
		possibleActions.add(new Sell());
	}

}
