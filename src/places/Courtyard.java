package places;


import schedule.Sell;
import schedule.Train;
import schedule.WellBeing;

public class Courtyard extends Place
{
	
	
	public Courtyard()
	{
		
		posX = 250;
		posY = 10;
		sizeX = 250;
		sizeY = 150;
		
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
