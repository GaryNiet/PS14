package places;


import schedule.Sell;
import schedule.Steal;
import schedule.StealWeaponTool;
import schedule.Train;
import schedule.WellBeing;

public class Job extends Place
{
	public Job()
	{
		name = "job";
		
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
		possibleActions.add(new StealWeaponTool());
		possibleActions.add(new Train());
		possibleActions.add(new Sell());
	}
	
	public Job(Job _job)
	{
		name = "job";
		
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
		possibleActions.add(new StealWeaponTool());
		possibleActions.add(new Train());
		possibleActions.add(new Sell());
	}
}
