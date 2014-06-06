package places;


import logic.Variables;
import schedule.StealWeaponTool;

public class Kitchen extends Place
{
	public Kitchen()
	{
		
		
		posX = (int) (0.1855 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		posY = (int) (0.3646 * Variables.getYresolution() * Variables.getResolutionmultiplier());
		sizeX = (int) ((0.1074) * Variables.getXresolution() * Variables.getResolutionmultiplier());
		sizeY = (int) ((0.117) * Variables.getYresolution() * Variables.getResolutionmultiplier());
		
		
		stealWeaponToolSR = 0.8;
		
		attackSR = 0.7;
		blackmailSR = 0.7;
		corruptSR = 0.7;
		digSR = 0.6;
		
		digAdvancement = 0;
		
		
		name = "kitchen";
		possibleActions.add(new StealWeaponTool());
	}
	
	public Kitchen(Kitchen _kitchen)
	{
		
		stealWeaponToolSR = _kitchen.stealWeaponToolSR;
		
		attackSR = _kitchen.attackSR;
		blackmailSR = _kitchen.blackmailSR;
		corruptSR = _kitchen.corruptSR;
		digSR = _kitchen.digSR;
		
		digAdvancement = _kitchen.digAdvancement;
		guardAwareness = _kitchen.guardAwareness;
		
		name = "kitchen";
		possibleActions.add(new StealWeaponTool());
	}
}
