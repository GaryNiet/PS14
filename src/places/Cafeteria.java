package places;


import schedule.StealWeaponTool;
import schedule.WellBeing;

public class Cafeteria extends Place
{
	
	public Cafeteria()
	{
		posX = 30;
		posY = 200;
		sizeX = 120;
		sizeY = 370;
		
		name = "cafeteria";
		
		stealWeaponToolSR = 1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		digAdvancement = 0;
		
		possibleActions.add(new WellBeing());
		possibleActions.add(new StealWeaponTool());
	}
	
	public Cafeteria(Cafeteria _cafeteria)
	{
		
		name = "cafeteria";
		
		stealWeaponToolSR = _cafeteria.stealWeaponToolSR;
		
		attackSR = _cafeteria.attackSR;
		blackmailSR = _cafeteria.blackmailSR;
		corruptSR = _cafeteria.corruptSR;
		digSR = _cafeteria.digSR;
		
		guardAwareness = _cafeteria.guardAwareness;
		digAdvancement = _cafeteria.digAdvancement;
		
		possibleActions.add(new WellBeing());
		possibleActions.add(new StealWeaponTool());
	}
}
