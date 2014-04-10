package places;


import schedule.ResolveLegal;
import schedule.WellBeing;

public class VisitingCell extends Place
{
	public VisitingCell()
	{
		
		resolveLegalSR = 1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		digAdvancement = 0;
		
		
		name = "visiting cell";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
}
