package places;


import schedule.StealWeaponTool;

public class Kitchen extends Place
{
	public Kitchen()
	{
		
		stealWeaponToolSR = 1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		digAdvancement = 0;
		
		
		name = "Kitchen";
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
		
		
		name = "Kitchen";
		possibleActions.add(new StealWeaponTool());
	}
}
