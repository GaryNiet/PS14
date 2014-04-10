package places;


import schedule.Steal;
import schedule.WellBeing;


public class Workshop extends Place
{
	public Workshop()
	{
		
		stealWeaponToolSR =1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		
		name = "Workshop";
		possibleActions.add(new Steal());
	}
}
