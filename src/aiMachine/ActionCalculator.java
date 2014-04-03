package aiMachine;

import schedule.PrisonAction;
import characters.CharacterPH;

public class ActionCalculator
{
	public static PrisonAction calculateBestAction(CharacterPH character)
	{
		PrisonAction bestAction = null;
		int best = 0;
		
		calculateHappiness(character);
				
				
		return bestAction;		
	}
	
	private static int calculateHappiness(CharacterPH character)
	{
		int healthPref = (character.getHealth()/1000) * character.getPreferences().getHealthPreference();
		int strengthPref = character.getStrength() * character.getPreferences().getStrengthPreference();
		int intelligencePref = character.getIntelligence() * character.getPreferences().getIntelligencePreference();
		
		
		return healthPref + strengthPref + intelligencePref;
	}
}
