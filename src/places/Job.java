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
	
	public int getPosX() {
		return Variables.getPlayerCharacter().getJob().getPosX();
	}


	public int getPosY() {
		return Variables.getPlayerCharacter().getJob().getPosY();
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
			place =  Learn.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		else if(action instanceof Steal)
		{
			place =  Steal.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		else if(action instanceof ResolveLegal)
		{
			place =  ResolveLegal.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		else if(action instanceof Train)
		{
			place = Train.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		else if(action instanceof Sell)
		{
			place = Sell.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		else if(action instanceof StealWeaponTool)
		{
			place = StealWeaponTool.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		else if(action instanceof Blackmail)
		{
			place = Blackmail.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		else if(action instanceof Corrupt)
		{
			place = Corrupt.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		else if(action instanceof Dig)
		{
			place = Dig.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		else
		{
			place = Evasion.getPlaces().get(random.nextInt(WellBeing.getPlaces().size()));
		}
		
		return place;
		
	}
}
