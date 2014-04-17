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
		
		digAdvancement = 0;
		
		
		name = "workshop";
		possibleActions.add(new Steal());
	}
	
	public Workshop(Workshop _workshop)
	{
		
		stealWeaponToolSR =_workshop.stealWeaponToolSR;
		
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
