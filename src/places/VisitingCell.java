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
	
	public VisitingCell(VisitingCell _visitingCell)
	{
		
		resolveLegalSR = _visitingCell.resolveLegalSR;
		
		attackSR = _visitingCell.attackSR;
		blackmailSR = _visitingCell.blackmailSR;
		corruptSR = _visitingCell.corruptSR;
		digSR = _visitingCell.digSR;
		
		digAdvancement = _visitingCell.digAdvancement;
		guardAwareness = _visitingCell.guardAwareness;
		
		name = "visiting cell";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
}
