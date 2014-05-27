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

public class Train extends PrisonAction
{
	public Train()
	{
		name = "train";
	}
	
	public void resolve(AICharacter character, int time, boolean isReal)
	{
		character.setStrength(character.getStrength()+1/(character.getStrength()*0.3));
	}
	


}
