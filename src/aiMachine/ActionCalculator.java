package aiMachine;

import schedule.PrisonAction;
import characters.AICharacter;

public class ActionCalculator
{
	
	public ActionCalculator()
	{
		
	}
	
	public PrisonAction calculateBestAction(AICharacter character,  int currentTime)
	{
		AICharacter dummyCharacter;
		AICharacter copyCharacter;
		
		PrisonAction bestAction = null;
		double best = -100000;
		
		
		
		for(PrisonAction prisonAction: character.getSchedule().getPlace(currentTime).getPossibleActions(character))
		{
			{
				
				
				dummyCharacter = new AICharacter(character);
				copyCharacter = new AICharacter(character);
				
				prisonAction.resolve(dummyCharacter, currentTime, false);
				
				
				double currentHappiness = calculateHappiness(copyCharacter, dummyCharacter, prisonAction, currentTime);
				if(currentHappiness > best)
				{
					
					best = currentHappiness;
					
					bestAction = prisonAction;
				}
				
			}

			
		}
		return bestAction;		
	}
	
	
	
	private double calculateHappiness(AICharacter characterBefore, AICharacter characterAfter, PrisonAction action, int time)
	{
		return (characterAfter.happiness() - characterBefore.happiness()) * action.successRate(characterBefore, time);
	}
	
}
