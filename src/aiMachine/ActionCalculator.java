package aiMachine;

import java.util.ArrayList;
import java.util.List;

import schedule.HealthAction;
import schedule.IntelligenceAction;
import schedule.PrisonAction;
import schedule.StrengthAction;
import characters.CharacterPH;

public class ActionCalculator
{
	List<PrisonAction> prisonActionList;
	StrengthAction strengthAction;
	IntelligenceAction intelligenceAction;
	HealthAction healthAction;
	
	public ActionCalculator()
	{
		prisonActionList = new ArrayList<>();
		
		healthAction = new HealthAction();
		strengthAction = new StrengthAction();
		intelligenceAction = new IntelligenceAction();
		
		prisonActionList.add(healthAction);
		prisonActionList.add(strengthAction);
		prisonActionList.add(intelligenceAction);
	}
	
	public PrisonAction calculateBestAction(CharacterPH character)
	{
		CharacterPH dummyCharacter;
		PrisonAction bestAction = null;
		double best = 0;
		for(PrisonAction prisonAction: prisonActionList)
		{
			
			//System.out.println(prisonAction.name);
			
			dummyCharacter = new CharacterPH(character);
			prisonAction.resolve(dummyCharacter);
			
			
			if(calculateHappiness(character, dummyCharacter) > best)
			{
				
				best = calculateHappiness(character, dummyCharacter);
				
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
