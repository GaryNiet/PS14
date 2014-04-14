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
		
		digAdvancement = 0;
		
		name = "Cafeteria";
		possibleActions.add(new WellBeing());
		possibleActions.add(new StealWeaponTool());
	}
	
	public Cafeteria(Cafeteria _cafeteria)
	{
		stealWeaponToolSR = _cafeteria.stealWeaponToolSR;
		
		attackSR = _cafeteria.attackSR;
		blackmailSR = _cafeteria.blackmailSR;
		corruptSR = _cafeteria.corruptSR;
		digSR = _cafeteria.digSR;
		
		digAdvancement = _cafeteria.digAdvancement;
		
		name = "Cafeteria";
		possibleActions.add(new WellBeing());
		possibleActions.add(new StealWeaponTool());
	}
}
