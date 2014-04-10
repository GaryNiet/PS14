package schedule;

import characters.CharacterPH;

public class Corrupt extends PrisonAction
{
	final int guardAwarenessChange = 5;
	final int moneyChange = 50;
	
	public Corrupt()
	{
		name = "corrupt";
	}

	@Override
	public void resolve(CharacterPH character, int time)
	{
		int money = character.getMoney();
		
		if(money >= moneyChange)
		{
			character.setMoney(character.getMoney() - moneyChange);
			character.getSchedule().getPlace(time).setGuardAwareness(character.getSchedule().getPlace(time).getGuardAwareness() - 5);
		}
	}
}
