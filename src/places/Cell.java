package places;

import logic.Variables;
import schedule.Steal;
import schedule.WellBeing;
import characters.AbstractCharacter;

@SuppressWarnings("serial")
public class Cell extends Place
{
	public Cell()
	{

		posX = (int) (0.02 * Variables.getXresolution() * Variables
				.getResolutionmultiplier());
		posY = (int) (0.026 * Variables.getYresolution() * Variables
				.getResolutionmultiplier());
		sizeX = (int) (0.1953 * Variables.getXresolution() * Variables
				.getResolutionmultiplier());
		sizeY = (int) ((0.156) * Variables.getYresolution() * Variables
				.getResolutionmultiplier());

		name = "cell";
		jobName = "cleaning duty";

		attackSR = 0.6;
		blackmailSR = 0.3;
		corruptSR = 0.3;
		digSR = 1;
		stealSR = 0.8;
		evasionSR = 0.05;
		sellMaterialsSR = 1;

		digAdvancement = 0;

		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());

		information = "Most prisonners use their cells for sleeping, \n sneaking around is way easier this way";
	}

	public Cell(Cell _cell)
	{
		name = "cell";

		attackSR = _cell.attackSR;
		blackmailSR = _cell.blackmailSR;
		corruptSR = _cell.corruptSR;
		digSR = _cell.digSR;
		stealSR = _cell.stealSR;
		evasionSR = _cell.evasionSR;
		sellMaterialsSR = _cell.sellMaterialsSR;

		guardAwareness = _cell.guardAwareness;

		digAdvancement = _cell.digAdvancement;

		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
	}

	public boolean isDoable(AbstractCharacter character)
	{
		return true;
	}

}
