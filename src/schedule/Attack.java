package schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import logic.Variables;
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
import aiMachine.ProbabilityCalculator;
import characters.CharacterPH;

public class Attack extends PrisonAction
{
	Random random;

	
	
	public Attack()
	{
		name = "attack";
		random = new Random();
	}

	@Override
	public void resolve(CharacterPH character, int time, boolean isReal)
	{
		
		CharacterPH victim = choseVictim(character, Variables.getCharacterList());
		if(!isReal)
		{
			victim = new CharacterPH(victim);
		}
		
		CharacterPH winner = calculateWinner(character, victim);
		
		if(isReal)
		{
			System.out.println("--------------------------------------------" + character.getName() + " attacks " + victim.getName() + " and " + winner.getName() + " is the winner");
		}
		
		if(winner == character)
		{
			character.setInfluence(character.getInfluence() + (int)calculateFightWinnings(character, victim));
			victim.setInfluence(victim.getInfluence() - Variables.getLostinfluenceonlostfight());
			victim.setHealth(victim.getHealth() - Variables.getLosthealthonlostfight());
		}
		else
		{
			victim.setInfluence(victim.getInfluence() + (int)calculateFightWinnings(victim, character));
			character.setInfluence(character.getInfluence() - Variables.getLostinfluenceonlostfight());
			character.setHealth(character.getHealth() - Variables.getLosthealthonlostfight());
		}
		

		
	}
	
	public static List<Place> getPlaces()
	{
		List<Place> placeList = new ArrayList<>();
		placeList.add(new Cell());
		placeList.add(new Courtyard());
		placeList.add(new Cafeteria());
		placeList.add(new Showers());
		placeList.add(new VisitingCell());
		placeList.add(new PhoneBooth());
		placeList.add(new Workshop());
		placeList.add(new Kitchen());
		placeList.add(new Library());
		
		return placeList;
	}
	
	private CharacterPH calculateWinner(CharacterPH character1, CharacterPH character2)
	{
		if(fightCapacity(character1)>fightCapacity(character2))
		{
			return character1;
		}
		else
		{
			return character2;
		}
	}
	
	private int fightCapacity(CharacterPH character)
	{
		if(character.isWeapon())
		{
			return (int) (character.getStrength() + Variables.getWeaponBonus() + random.nextInt(Variables.getFightRandom()));
		}
		else
		{
			return (int) (character.getStrength() + random.nextInt(Variables.getFightRandom()));
		}
		
	}
	
	
	public static CharacterPH choseVictim(CharacterPH character, List<CharacterPH> characterList)
	{
		CharacterPH bestVictim = null;
		int best = -10000;// = winnings * probability of winning
		int test;
		double winnings;
		int weaponEquiped = 0;
		for(CharacterPH victim: characterList)
		{
			if(!character.getName().equals(victim.getName()))
			{
				 winnings = calculateFightWinnings(character, victim);
				 if(character.isWeapon())
					 weaponEquiped = Variables.getWeaponBonus();
				 test = (int) ((int) ProbabilityCalculator.winChance(character.getStrength() + weaponEquiped, Variables.getFightRandom(), victim.getStrength(), Variables.getFightRandom() + 2) * winnings);
				 
				 if(test > best)
				 {
					 best = test;
					 bestVictim = victim;
				 }
			}
		}
		
		return bestVictim;
		
	}
	
	
	private static double calculateFightWinnings(CharacterPH winner, CharacterPH loser)
	{
		//System.out.println("attacker: " + winner.getName() + " victim: " + loser.getName());
		double rewardMultiplier;
		
		if(winner.getStrength() == loser.getStrength())
		{
			rewardMultiplier = 1;
		}
		else
		{
			if(winner.getStrength() < loser.getStrength())
			{
				rewardMultiplier = loser.getStrength() - winner.getStrength() * Variables.getWeakestwinsfightmultiplier();
			}
			else
			{
				rewardMultiplier = Variables.getStrongerwinsfightmultiplier() / (winner.getStrength() - loser.getStrength());
			}
			
			
		}
		//System.out.println("in the hopes of winning " + rewardMultiplier * Variables.getfightWinningsMultiplier());
		return rewardMultiplier * Variables.getfightWinningsMultiplier();
	}

	

}
