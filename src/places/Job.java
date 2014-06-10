package places;

import java.util.Random;

import characters.AbstractCharacter;

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
		
		information = "";
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
	
	public static Place getRandomJob()
	{
		Random random = new Random();
		
		Place[] jobs = new Place[4];
		jobs[0] = new Kitchen();
		jobs[1] = new Workshop();
		jobs[2] = new Courtyard();
		jobs[3] = new Cell();
		
		return jobs[random.nextInt(3)];
		
	}
	
	
	

	public int getSizeX()
	{
		return Variables.getPlayerCharacter().getJob().getSizeX();
	}

	public int getSizeY()
	{
		return Variables.getPlayerCharacter().getJob().getSizeY();
	}

	public static Place chosePlace(PrisonAction action, AbstractCharacter character, int time)
	{
		

		return character.getJob();

	}
}
