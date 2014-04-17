package places;


import schedule.Steal;
import schedule.WellBeing;

public class Cell extends Place
{
	public Cell()
	{
		name = "cell";
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		stealSR = 1;
		
		
		digAdvancement = 0;
		
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
	}
	
	public Cell(Cell _cell)
	{
		name = "cell";
		
		attackSR = _cell.attackSR;
		blackmailSR = _cell.blackmailSR;
		corruptSR = _cell.corruptSR;
		digSR = _cell.digSR;
		stealSR = _cell.stealSR;
		
		guardAwareness = _cell.guardAwareness;
		
		
		digAdvancement = _cell.digAdvancement;
		
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
	}
	
	

	
	
}
