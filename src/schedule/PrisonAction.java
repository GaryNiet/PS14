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

public abstract class PrisonAction
{
	public String name;
	public abstract void resolve(AICharacter character, int time, boolean isReal);
}
