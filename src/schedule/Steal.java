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

public class Steal extends PrisonAction
{
	public Steal()
	{
		name = "steal";
	}

	@Override
	public void resolve(AICharacter character, int time, boolean isReal)
	{
		character.setMaterials(character.getMaterials() + 10);
	}
	



}
