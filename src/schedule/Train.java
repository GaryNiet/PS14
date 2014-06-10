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

public class Train extends PrisonAction
{
	public Train()
	{
		name = "train";
		
		information = "stornger people win more fights";
	}
	
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		character.setStrength(character.getStrength()+(1/(character.getStrength()*0.3)));
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
