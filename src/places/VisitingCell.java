package places;


import logic.Variables;
import schedule.ResolveLegal;
import schedule.WellBeing;

public class VisitingCell extends Place
{
	public VisitingCell()
	{
		
		posX = (int) (0.5685 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		posY = (int) (0.3608 * Variables.getYresolution() * Variables.getResolutionmultiplier());
		sizeX = (int) (0.155 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		sizeY = (int) ((0.3004) * Variables.getYresolution() * Variables.getResolutionmultiplier());
		
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
