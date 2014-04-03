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
		CharacterPH dummyCharacter = new CharacterPH(character);
		PrisonAction bestAction = null;
		int best = 0;
		for(PrisonAction prisonAction: prisonActionList)
		{
			
		}
		
		calculateHappiness(character);
				
				
		return bestAction;		
	}
	
	private int calculateHappiness(CharacterPH character)
	{
		int healthPref = (character.getHealth()/1000) * character.getPreferences().getHealthPreference();
		int strengthPref = character.getStrength() * character.getPreferences().getStrengthPreference();
		int intelligencePref = character.getIntelligence() * character.getPreferences().getIntelligencePreference();
		
		
		return healthPref + strengthPref + intelligencePref;
	}
}
