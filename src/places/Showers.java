package places;


import schedule.Steal;
import schedule.WellBeing;

public class Showers extends Place
{
	public Showers()
	{
		
		posX = 550;
		posY = 40;
		sizeX = 90;
		sizeY = 200;
		
		stealSR = 1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		digAdvancement = 0;
		
		
		name = "showers";
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
	}
	
	public Showers(Showers _showers)
	{
		
		stealSR = _showers.stealSR;
		
		attackSR = _showers.attackSR;
		blackmailSR = _showers.blackmailSR;
		corruptSR = _showers.corruptSR;
		digSR = _showers.digSR;
		
		digAdvancement = _showers.digAdvancement;
		guardAwareness = _showers.guardAwareness;
		
		name = "showers";
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
	}
	
}
