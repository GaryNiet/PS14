package schedule;

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
		if(isReal == false)
		{
			int sold = (int) (15 * character.getIntelligence()/20) * 5;

			if(character.getMaterials() <= sold)
			{
				character.setMoney((int) (character.getMoney() * 0.5));
				character.setMaterials(0);
			}
			else
			{
				character.setMaterials(character.getMaterials() - sold);
				character.setMoney((int) (character.getMoney() + sold * 0.5));
			}
			
		}
		else if(isReal == true && success(character, time) == true)
		{
			int sold = (int) (15 * character.getIntelligence()/20);
			
			if(character.getMaterials() <= sold)
			{
				character.setMoney((int) (character.getMaterials() * 0.5));
				character.setMaterials(0);
			}
			else
			{
				character.setMaterials(character.getMaterials() - sold);
				character.setMoney((int) (character.getMoney() + sold * 0.5));
			}
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
		double successRate = (character.getIntelligence()/10) * character.getSchedule().getPlace(time).getSellMaterialsSR();
		return successRate;
	}
	



}
