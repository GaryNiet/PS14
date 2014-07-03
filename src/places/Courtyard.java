package places;


import logic.Variables;
import schedule.Train;
import schedule.WellBeing;
import characters.AbstractCharacter;

@SuppressWarnings("serial")
public class Courtyard extends Place
{
	
	
	public Courtyard()
	{
		
		
		posX = (int) (0.2441 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		posY = (int) (0.033 * Variables.getYresolution() * Variables.getResolutionmultiplier());
		sizeX = (int) (0.3441 * Variables.getXresolution() * Variables.getResolutionmultiplier());
		sizeY = (int) ((0.1753) * Variables.getYresolution() * Variables.getResolutionmultiplier());
		
		name = "courtyard";
		jobName = "stock management";
		
		attackSR = 0.6;
		blackmailSR = 0.4;
		corruptSR = 0.4;
		digSR = 0.8;
		sellMaterialsSR = 1.5;
		evasionSR = 0.2;
		
		digAdvancement = 0;
		
		possibleActions.add(new Train());
		possibleActions.add(new WellBeing());
		
		information = "the courtyard is the only outdoors place in the prison";
	}
	
	public Courtyard(Courtyard _courtyard)
	{
		
		name = "courtyard";
		
		attackSR = _courtyard.attackSR;
		blackmailSR = _courtyard.blackmailSR;
		corruptSR = _courtyard.corruptSR;
		digSR = _courtyard.digSR;
		sellMaterialsSR = _courtyard.sellMaterialsSR;
		evasionSR = _courtyard.evasionSR;
		
		guardAwareness = _courtyard.guardAwareness;
		digAdvancement = _courtyard.digAdvancement;
		
		possibleActions.add(new Train());
		possibleActions.add(new WellBeing());
	}
	
	public boolean isDoable(AbstractCharacter character)
	{
		if(character.getStrength() > 10)
		{
			return true;
		}
		return false;
	}

}
