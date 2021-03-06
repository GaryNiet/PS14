package places;


import logic.Variables;
import schedule.ResolveLegal;
import schedule.WellBeing;

@SuppressWarnings("serial")
public class VisitingCell extends Place
{
	public VisitingCell()
	{
		
		posX = (int) (0.5685 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		posY = (int) (0.4308 * Variables.getYresolution() * Variables.getResolutionmultiplier());
		sizeX = (int) (0.155 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		sizeY = (int) ((0.25) * Variables.getYresolution() * Variables.getResolutionmultiplier());
		
		resolveLegalSR = 0.8;
		
		attackSR = 0.2;
		blackmailSR = 0.1;
		corruptSR = 0.1;
		digSR = 0.1;
		
		digAdvancement = 0;
		evasionSR = 0.2;
		
		
		name = "visiting cell";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
		
		information = "outside contact";
	}
	
	public VisitingCell(VisitingCell _visitingCell)
	{
		
		resolveLegalSR = _visitingCell.resolveLegalSR;
		
		attackSR = _visitingCell.attackSR;
		blackmailSR = _visitingCell.blackmailSR;
		corruptSR = _visitingCell.corruptSR;
		digSR = _visitingCell.digSR;
		evasionSR = _visitingCell.evasionSR;
		
		digAdvancement = _visitingCell.digAdvancement;
		guardAwareness = _visitingCell.guardAwareness;
		
		name = "visiting cell";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
}
