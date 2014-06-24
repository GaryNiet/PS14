package places;

import characters.AbstractCharacter;
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
		sizeY = (int) ((0.18) * Variables.getYresolution() * Variables
				.getResolutionmultiplier());

		stealWeaponToolSR = 0.9;

		attackSR = 0.2;
		blackmailSR = 0.4;
		corruptSR = 0.4;
		digSR = 0.6;
		evasionSR = 0.1;
		digAdvancement = 0;

		name = "workshop";
		jobName = "assembling line";
		possibleActions.add(new Steal());
		
		information = "potential weapons all over the place, but heavily guarded";
	}

	public Workshop(Workshop _workshop)
	{

		stealWeaponToolSR = _workshop.stealWeaponToolSR;

		attackSR = _workshop.attackSR;
		blackmailSR = _workshop.blackmailSR;
		corruptSR = _workshop.corruptSR;
		digSR = _workshop.digSR;
		evasionSR = _workshop.evasionSR;

		digAdvancement = _workshop.digAdvancement;
		guardAwareness = _workshop.guardAwareness;

		name = "workshop";
		possibleActions.add(new Steal());
	}
	
	public boolean isDoable(AbstractCharacter character)
	{
		if(character.getStrength() > 7 && character.getIntelligence() > 7)
		{
			return true;
		}
		return false;
	}
}
