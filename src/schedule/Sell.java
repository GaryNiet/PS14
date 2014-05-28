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

public class Sell extends PrisonAction
{
	public Sell()
	{
		name = "sell";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		if(character.getMaterials() >= 10)
		{
			character.setMaterials(character.getMaterials() - 10);
			character.setMoney(character.getMoney() + 5);
		}
		
		
	}
	



}
