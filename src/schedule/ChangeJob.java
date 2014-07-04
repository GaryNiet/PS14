package schedule;

import logic.Variables;
import places.Job;
import places.Place;
import characters.AbstractCharacter;

@SuppressWarnings("serial")
public class ChangeJob extends PrisonAction
{
	
	
	public ChangeJob()
	{
		name = "changeJob";
		
		information = "changing jobs might help you climb the hierarchie";
		
	}

	@Override
	public void resolve(AbstractCharacter character, int time, boolean isReal)
	{
		if(character == Variables.getPlayerCharacter())
		{
			if(success(character, time))
			{
				character.setJob(character.getNextJob());
				informPlayer(character, time);
			}
			
		}
		else
		{
			if(isReal == false)
			{
				character.setJob(findBestJob(character));
			
			}
			else if(isReal == true && success(character, time) == true)
			{
				character.setJob(findBestJob(character));
				
			}
		}
		
	}
	
	
	private Place findBestJob(AbstractCharacter character)
	{
		Place place = null;
		for( int i = 0; i< Job.getJobs().length; i++)
		{
			if(Job.getJobs()[i].isDoable(character))
			{
				place = Job.getJobs()[i];
			}
		}
		return place;
		
	}
	
	private void informPlayer(AbstractCharacter character, int time)
	{
		if(character == Variables.getPlayerCharacter())
		{
				Variables.getGameLogic().getUserInterface().getWarningWindow().setImage("job changed to " + Variables.getPlayerCharacter().getJob().getJobName(), false);
				Variables.getGameLogic().getUserInterface().setInfo(true);
		}
	}

	@Override
	protected boolean success(AbstractCharacter character, int time)
	{
		return true;
	}

	@Override
	public double successRate(AbstractCharacter character, int time)
	{
		return 0;
	}
}
