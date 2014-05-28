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

public class ResolveLegal extends PrisonAction
{
	public ResolveLegal()
	{
		name = "resolveLegal";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		character.setLegalAdvancement(character.getLegalAdvancement() + 1/character.getLegalAdvancement());
		
	}
	



	
}
