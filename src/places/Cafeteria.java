package places;


import schedule.StealWeaponTool;
import schedule.WellBeing;

public class Cafeteria extends Place
{
	public Cafeteria()
	{
		name = "Cafeteria";
		possibleActions.add(new WellBeing());
		possibleActions.add(new StealWeaponTool());
		
		
	}
}
