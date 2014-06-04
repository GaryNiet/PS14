package schedule;

import java.util.ArrayList;
import java.util.List;

import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.PhoneBooth;
import places.Place;
import places.Showers;
import places.VisitingCell;
import characters.AICharacter;
import characters.AbstractCharacter;

public class WellBeing extends PrisonAction
{
	
	public WellBeing()
	{
		name = "wellbeing";
	}
	
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		
		character.setHealth(character.getHealth()+30);
		character.checkHealthIntegrity();
	}

	@Override
	protected boolean success(AbstractCharacter character, int time)
	{
		return true;
	}

	@Override
	public double successRate(AbstractCharacter character, int time)
	{
		return 1;
	}
	



}