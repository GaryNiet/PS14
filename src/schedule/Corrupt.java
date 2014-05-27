package schedule;

import java.util.ArrayList;
import java.util.List;

import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.Kitchen;
import places.Library;
import places.PhoneBooth;
import places.Place;
import places.Showers;
import places.VisitingCell;
import places.Workshop;
import characters.AICharacter;

public class Corrupt extends PrisonAction
{
	final int guardAwarenessChange = 5;
	final int moneyChange = 50;
	
	public Corrupt()
	{
		name = "corrupt";
	}

	@Override
	public void resolve(AICharacter character, int time, boolean isReal)
	{
		int money = character.getMoney();
		
		if(money >= moneyChange)
		{
			character.setMoney(character.getMoney() - moneyChange);
			character.getSchedule().getPlace(time).setGuardAwareness(character.getSchedule().getPlace(time).getGuardAwareness() - 5);
		}
	}
	


}
