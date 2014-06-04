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
		
		
		
		for(PrisonAction prisonAction: character.getSchedule().getPlace(currentTime).possibleActions)
		{
			{
				//System.out.println("------------------------------"+ prisonAction.name + "--------------------------------------");
				//System.out.println(character.getSchedule().getPlace(currentTime).possibleActions);
//				System.out.println("stop");
				
				//System.out.println(prisonAction.name);
				
				dummyCharacter = new AICharacter(character);
				copyCharacter = new AICharacter(character);
				
				prisonAction.resolve(dummyCharacter, currentTime, false);
				
				
				double currentHappiness = calculateHappiness(character, dummyCharacter, prisonAction, currentTime);
				//System.out.println("result " + currentHappiness);
				if(currentHappiness > best)
				{
					
					best = currentHappiness;
					
					bestAction = prisonAction;
				}
				
			}

			
		}
		//System.out.println(best);
		return bestAction;		
	}
	
	
	
	private double calculateHappiness(AICharacter characterBefore, AICharacter characterAfter, PrisonAction action, int time)
	{
		return (characterAfter.happiness() - characterBefore.happiness()) * action.successRate(characterBefore, time);
	}
	
}
