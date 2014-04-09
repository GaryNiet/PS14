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
		double best = 0;
		for(PrisonAction prisonAction: character.getSchedule().getPlace(currentTime).possibleActions)
		{
			System.out.println("start");
			System.out.println(character.getSchedule().getPlace(currentTime).possibleActions);
			System.out.println("stop");
			
			//System.out.println(prisonAction.name);
			
			dummyCharacter = new CharacterPH(character);
			prisonAction.resolve(dummyCharacter);
			
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
		
		
		
		//TODO trouver meilleure fonction
		double charBHH = (double)characterBefore.getHealth() * characterBefore.getPreferences().getHealthPreference();
		double charBSH = (double)characterBefore.getStrength() * characterBefore.getPreferences().getStrengthPreference();
		double charBIH = (double)characterBefore.getIntelligence() * characterBefore.getPreferences().getIntelligencePreference();
		double charAHH = (double)characterAfter.getHealth() * characterAfter.getPreferences().getHealthPreference();
		double charASH = (double)characterAfter.getStrength() * characterAfter.getPreferences().getStrengthPreference();
		double charAIH = (double)characterAfter.getIntelligence() * characterAfter.getPreferences().getIntelligencePreference();
		
		double charBH = charBHH + charBSH + charBIH;
		double charAH = charAHH + charASH + charAIH;
		
//		System.out.println("sante B = " + charBHH);
//		System.out.println("sante A = " + charAHH);
//		System.out.println("force B = " + charBSH);
//		System.out.println("force A = " + charASH);
//		System.out.println("intel B = " + charBIH);
//		System.out.println("intel A = " + charAIH);
		
		
		return charAH - charBH;
	}
}
