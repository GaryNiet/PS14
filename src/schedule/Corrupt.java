package schedule;

import logic.Variables;
import characters.AbstractCharacter;

public class Corrupt extends PrisonAction
{
	final int guardAwarenessChange = 5;
	final int moneyChange = 50;
	
	public Corrupt()
	{
		name = "corrupt";
		
		information = "this lowers the guard awareness in the current location at the cost of money";
	}

	@Override
	public void resolve(characters.AbstractCharacter character, int time, boolean isReal)
	{
		int money = character.getMoney();
		
		if(money >= moneyChange && isReal == false)
		{
			character.setMoney(character.getMoney() - moneyChange);
			character.getSchedule().getPlace(time).setGuardAwareness(character.getSchedule().getPlace(time).getGuardAwareness() - 3);
		}
		else if(money >= moneyChange && isReal == true && success(character, time) == true)
		{
			character.setMoney(character.getMoney() - moneyChange);
			character.getSchedule().getPlace(time).setGuardAwareness(character.getSchedule().getPlace(time).getGuardAwareness() - 3);
			informPlayer(character, time);
		}
	}
	
	private void informPlayer(AbstractCharacter character, int time)
	{
		if(character == Variables.getPlayerCharacter())
		{
				Variables.getGameLogic().getUserInterface().getWarningWindow().setImage("corruption successful");
				Variables.getGameLogic().getUserInterface().setInfo(true);
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
		double successRate = character.getSchedule().getPlace(time).getCorruptSR() * (character.getIntelligence()/20);
		return successRate;
	}
	


}
