package places;


import logic.Variables;
import schedule.StealWeaponTool;
import schedule.WellBeing;

public class Cafeteria extends Place
{
	
	public Cafeteria()
	{
		posX = (int) (0.03 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		posY = (int) (0.26 * Variables.getYresolution() * Variables.getResolutionmultiplier());
		sizeX = (int) (0.117 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		sizeY = (int) ((0.482) * Variables.getYresolution() * Variables.getResolutionmultiplier());
		
		name = "cafeteria";
		
		stealWeaponToolSR = 0.3;
		
		attackSR = 0.2;
		blackmailSR = 0.2;
		corruptSR = 0.2;
		digSR = 0.1;
		
		digAdvancement = 0;
		
		possibleActions.add(new WellBeing());
		possibleActions.add(new StealWeaponTool());
		
		information = "This is where prisonners eat. Guard presence is  quite sparse";
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
