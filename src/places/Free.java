package places;

import java.util.Random;

import logic.Variables;

import schedule.Blackmail;
import schedule.Corrupt;
import schedule.Dig;
import schedule.Evasion;
import schedule.Learn;
import schedule.PrisonAction;
import schedule.ResolveLegal;
import schedule.Sell;
import schedule.Steal;
import schedule.StealWeaponTool;
import schedule.Train;
import schedule.WellBeing;


public class Free extends Place
{
	public Free()
	{
		name = "free";
		
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
		possibleActions.add(new Learn());
		possibleActions.add(new ResolveLegal());
		possibleActions.add(new StealWeaponTool());
		possibleActions.add(new Train());
		possibleActions.add(new Sell());
	}
	
	public Free(Free free)
	{
		name = "free";
		
		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
		possibleActions.add(new Learn());
		possibleActions.add(new ResolveLegal());
		possibleActions.add(new StealWeaponTool());
		possibleActions.add(new Train());
		possibleActions.add(new Sell());
	}
	
	
	public static Place chosePlace(PrisonAction action)
	{
		Random random = new Random();
		Place place = action.getAllPlaces().get(random.nextInt(action.getAllPlaces().size()));
		
		return place;
		
	}

}
