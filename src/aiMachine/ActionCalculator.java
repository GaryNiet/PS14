package aiMachine;

import schedule.PrisonAction;
import characters.CharacterPH;

public class ActionCalculator
{
	
	public ActionCalculator()
	{
		
	}
	
	public PrisonAction calculateBestAction(CharacterPH character,  int currentTime)
	{
		CharacterPH dummyCharacter;
		PrisonAction bestAction = null;
		double best = -100000;
		for(PrisonAction prisonAction: character.getSchedule().getPlace(currentTime).possibleActions)
		{
			System.out.println("------------------------------"+ prisonAction.name + "--------------------------------------");
//			System.out.println(character.getSchedule().getPlace(currentTime).possibleActions);
//			System.out.println("stop");
			
			//System.out.println(prisonAction.name);
			
			dummyCharacter = new CharacterPH(character);
			prisonAction.resolve(dummyCharacter, currentTime);
			
			double currentHappiness = calculateHappiness(character, dummyCharacter);
			if(currentHappiness > best)
			{
				
				best = currentHappiness;
				
				bestAction = prisonAction;
			}
			
		}
		//System.out.println(best);
		return bestAction;		
	}
	
	
	
	private double calculateHappiness(CharacterPH characterBefore, CharacterPH characterAfter)
	{
		return characterAfter.happiness() - characterBefore.happiness();
	}
	
}
