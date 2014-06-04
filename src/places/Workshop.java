package places;

import logic.Variables;
import schedule.Steal;

public class Workshop extends Place
{
	public Workshop()
	{

		posX = 215;
		posY = 420;
		sizeX = 250;
		sizeY = 140;

		posX = (int) (0.2099 * Variables.getXresolution() * Variables
				.getResolutionmultiplier());
		posY = (int) (0.5468 * Variables.getYresolution() * Variables
				.getResolutionmultiplier());
		sizeX = (int) (0.2441 * Variables.getXresolution() * Variables
				.getResolutionmultiplier());
		sizeY = (int) ((0.206) * Variables.getYresolution() * Variables
				.getResolutionmultiplier());

		stealWeaponToolSR = 1;

		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;

		digAdvancement = 0;

		name = "workshop";
		possibleActions.add(new Steal());
	}

	public Workshop(Workshop _workshop)
	{

		stealWeaponToolSR = _workshop.stealWeaponToolSR;

		attackSR = _workshop.attackSR;
		blackmailSR = _workshop.blackmailSR;
		corruptSR = _workshop.corruptSR;
		digSR = _workshop.digSR;

		digAdvancement = _workshop.digAdvancement;
		guardAwareness = _workshop.guardAwareness;

		name = "workshop";
		possibleActions.add(new Steal());
	}
}
