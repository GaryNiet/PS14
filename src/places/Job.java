package places;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import logic.Variables;
import schedule.ChangeJob;
import schedule.PrisonAction;
import schedule.Sell;
import schedule.Steal;
import schedule.StealWeaponTool;
import schedule.Train;
import schedule.WellBeing;
import characters.AbstractCharacter;



	
public class Job extends Place
{
	
	static Place[] jobs;
	
	public Job()
	{
		name = "job";

		possibleActions.add(new WellBeing());
		possibleActions.add(new Steal());
		possibleActions.add(new StealWeaponTool());
		possibleActions.add(new Train());
		possibleActions.add(new Sell());
		
		information = "";
		
		jobs = new Place[4];
		jobs[3] = new Kitchen();
		jobs[1] = new Workshop();
		jobs[2] = new Courtyard();
		jobs[0] = new Cell();
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
		
		return jobs[random.nextInt(jobs.length -1)];
		
	}
	
	
	public static Place[] getJobs()
	{
		return jobs;
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
	
	public List<PrisonAction> getPossibleActions(AbstractCharacter character)
	{
		return character.getJob().getPossibleActions(character);
	}
	
	public List<PrisonAction> jobActions(AbstractCharacter character)
	{
		List<PrisonAction> list = new ArrayList<>(character.getJob().getPossibleActions(character));
		list.add(new ChangeJob());
		return list;
	}
}
