package places;


import schedule.StealWeaponTool;

public class Kitchen extends Place
{
	public Kitchen()
	{
		
		posX = 190;
		posY = 280;
		sizeX = 110;
		sizeY = 90;
		
		
		stealWeaponToolSR = 1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
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
