package places;

import java.util.Random;

import logic.Variables;
import schedule.PrisonAction;
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

	public int getPosX()
	{
		return Variables.getPlayerCharacter().getJob().getPosX();
	}

	public int getPosY()
	{
		return Variables.getPlayerCharacter().getJob().getPosY();
	}

	public static Place chosePlace(PrisonAction action)
	{
		Random random = new Random();
		Place place = action.getAllPlaces().get(
				random.nextInt(action.getAllPlaces().size()));

		return place;

	}
}
