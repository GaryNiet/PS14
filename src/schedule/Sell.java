package schedule;

import characters.CharacterPH;

public class Sell extends PrisonAction
{
	public Sell()
	{
		name = "sell";
	}

	@Override
	public void resolve(CharacterPH character, int time)
	{
		if(character.getMaterials() >= 10)
		{
			character.setMaterials(character.getMaterials() - 10);
			character.setMoney(character.getMoney() + 5);
		}
		
		
	}
}
