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
import characters.CharacterPH;

public class Sell extends PrisonAction
{
	public Sell()
	{
		name = "sell";
	}

	@Override
	public void resolve(CharacterPH character, int time, boolean isReal)
	{
		if(character.getMaterials() >= 10)
		{
			character.setMaterials(character.getMaterials() - 10);
			character.setMoney(character.getMoney() + 5);
		}
		
		
	}
	
	public static List<Place> getPlaces()
	{
		List<Place> placeList = new ArrayList<>();
		placeList.add(new Courtyard());
		
		return placeList;
	}


}
