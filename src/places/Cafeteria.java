package places;


import schedule.StealWeaponTool;
import schedule.WellBeing;

public class Cafeteria extends Place
{
	
	public Cafeteria()
	{
		
		stealWeaponToolSR = 1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		name = "Cafeteria";
		possibleActions.add(new WellBeing());
		possibleActions.add(new StealWeaponTool());
		
		
	}
}
