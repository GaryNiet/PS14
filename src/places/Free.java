package places;

import schedule.Learn;
import schedule.PrisonAction;
import schedule.ResolveLegal;
import schedule.Steal;
import schedule.StealWeaponTool;
import schedule.Train;
import schedule.WellBeing;
import characters.AICharacter;

@SuppressWarnings("serial")
public class Free extends Place
{
	public Free()
	{
		name = "free";
		resolveLegalSR = 0.8;

		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
		possibleActions.add(new Learn());
		possibleActions.add(new ResolveLegal());
		possibleActions.add(new StealWeaponTool());
		possibleActions.add(new Train());
		
		information = "";
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
		
		information = "";
	}

	public static Place chosePlace(PrisonAction action, AICharacter character, int time)
	{
		int max = 0;
		Place bestPlace = new Cell();
		
		for(Place place: action.getAllPlaces())
		{
			if(action.successRate(character, time)>max)
			{
				bestPlace = place;
			}
		}
		
		

		return bestPlace;

	}

}
