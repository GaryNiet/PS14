package schedule;

import characters.CharacterPH;

public class Sell extends PrisonAction
{
	public Sell()
	{
		name = "sell";
	}

	@Override
	public void resolve(CharacterPH character)
	{
		character.setHealth(character.getHealth()+1);
		if(character.getHealth() > 100)
		{
			character.setHealth(100);
		}
		
	}
}
