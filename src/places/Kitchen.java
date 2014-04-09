package places;


import schedule.StealWeaponTool;

public class Kitchen extends Place
{
	public Kitchen()
	{
		name = "Kitchen";
		possibleActions.add(new StealWeaponTool());
	}
}
