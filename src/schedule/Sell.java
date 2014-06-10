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

public class Sell extends PrisonAction
{
	public Sell()
	{
		name = "sell";
		
		information = "you might get some money out of that useless materials";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		if(character.getMaterials() >= 10 && isReal == false)
		{
			character.setMaterials(character.getMaterials() - 10);
			character.setMoney(character.getMoney() + 5);
		}
		else if(isReal == true && success(character, time) == true)
		{
			character.setMaterials(character.getMaterials() - 10);
			character.setMoney(character.getMoney() + 5);
		}
		
		
	}

	@Override
	protected boolean success(AbstractCharacter character, int time)
	{
		if(random.nextFloat() < successRate(character, time))
		{
			return true;
		}
		return false;
	}

	@Override
	public double successRate(AbstractCharacter character, int time)
	{
		double successRate = (character.getIntelligence()/20) * character.getSchedule().getPlace(time).getSellMaterialsSR();
		return successRate;
	}
	



}
