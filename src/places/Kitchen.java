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
		
		
		name = "Kitchen";
		possibleActions.add(new StealWeaponTool());
	}
}
