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
		Place place = null;
		
		
		if(action instanceof WellBeing)
		{
			place = WellBeing.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		else if(action instanceof Learn)
		{
			place =  Learn.getPlaces().get(random.nextInt(Learn.getPlaces().size()));
		}
		else if(action instanceof Steal)
		{
			place =  Steal.getPlaces().get(random.nextInt(Steal.getPlaces().size()));
		}
		else if(action instanceof ResolveLegal)
		{
			place =  ResolveLegal.getPlaces().get(random.nextInt(ResolveLegal.getPlaces().size()));
		}
		else if(action instanceof Train)
		{
			place = Train.getPlaces().get(random.nextInt(Train.getPlaces().size()));
		}
		else if(action instanceof Sell)
		{
			place = Sell.getPlaces().get(random.nextInt(Sell.getPlaces().size()));
		}
		else if(action instanceof StealWeaponTool)
		{
			place = StealWeaponTool.getPlaces().get(random.nextInt(StealWeaponTool.getPlaces().size()));
		}
		else if(action instanceof Blackmail)
		{
			place = Blackmail.getPlaces().get(random.nextInt(Blackmail.getPlaces().size()));
		}
		else if(action instanceof Corrupt)
		{
			place = Corrupt.getPlaces().get(random.nextInt(Corrupt.getPlaces().size()));
		}
		else if(action instanceof Dig)
		{
			place = Dig.getPlaces().get(random.nextInt(Dig.getPlaces().size()));
		}
		else
		{
			place = Evasion.getPlaces().get(random.nextInt(Evasion.getPlaces().size()));
		}
		
		return place;
		
	}

}
