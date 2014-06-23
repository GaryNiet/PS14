package schedule;

import java.util.List;
import java.util.Random;

import logic.Variables;
import aiMachine.ProbabilityCalculator;
import characters.AICharacter;
import characters.AbstractCharacter;
import characters.PlayerCharacter;

public class Attack extends PrisonAction
{
	Random random;

	
	
	public Attack()
	{
		name = "attack";
		random = new Random();
		
		information = "this lets you attack another player";
	}

	@Override
	public void resolve(AbstractCharacter character, int time, boolean isReal)
	{
		
		if(character == Variables.getPlayerCharacter())
		{
			AbstractCharacter victim = ((PlayerCharacter)character).getVictim();
			AbstractCharacter winner = calculateWinner(character, victim);
			
			if(success(character, time) == true)
			{
				if(winner == character)
				{
					character.setInfluence(character.getInfluence() + (int)calculateFightWinnings(character, victim));
					victim.setInfluence(victim.getInfluence() - Variables.getLostinfluenceonlostfight());
					victim.setHealth(victim.getHealth() - Variables.getLosthealthonlostfight());
					character.setStrength(character.getStrength()+(1/(character.getStrength()*0.3)));
					informPlayerVictory(character, victim, time);
					
				}
				else
				{
					victim.setInfluence(victim.getInfluence() + (int)calculateFightWinnings(victim, character));
					character.setInfluence(character.getInfluence() - Variables.getLostinfluenceonlostfight());
					character.setHealth(character.getHealth() - Variables.getLosthealthonlostfight());
					character.setWeapon(false);
					informPlayerDefeat(character, time);
				}
			}
			else
			{
				character.setHealth(character.getHealth() - 8);
				informPlayerUnsuccessful(character, victim,  time);
				
			}
			
		}
		else
		{
			if(isReal == false)
			{
				attackReaction(character, isReal);
			}
			else if(isReal == true && success(character, time) == true)
			{
				attackReaction(character, isReal);
				character.setStrength(character.getStrength()+(1/(character.getStrength()*0.3)));
			}
			else if(isReal == true)
			{
				AbstractCharacter victim = choseVictim(character, Variables.getAllCharacters());
				character.setHealth(character.getHealth() - 8);
				
			}
			
			
		}

		
	}
	
	private void informPlayerVictory(AbstractCharacter character, AbstractCharacter victim, int time)
	{
		if(character == Variables.getPlayerCharacter())
		{
				Variables.getGameLogic().getUserInterface().getWarningWindow().setImage("you beat up " + victim.getName() + " without anybody noticing");
				Variables.getGameLogic().getUserInterface().setInfo(true);
		}
	}
	
	private void informPlayerUnsuccessful(AbstractCharacter character, AbstractCharacter victim, int time)
	{
		if(character == Variables.getPlayerCharacter())
		{
				Variables.getGameLogic().getUserInterface().getWarningWindow().setImage("Before you get your hand on " + victim.getName() + ", guards notice your intention and push you back violently");
				Variables.getGameLogic().getUserInterface().setInfo(true);
		}
	}
	
	private void informPlayerDefeat(AbstractCharacter character, int time)
	{
		if(character == Variables.getPlayerCharacter())
		{
				Variables.getGameLogic().getUserInterface().getWarningWindow().setImage("you lose the fight and get hurt");
				Variables.getGameLogic().getUserInterface().setInfo(true);
		}
	}

	private void attackReaction(AbstractCharacter character, boolean isReal)
	{
		AbstractCharacter victim = choseVictim(character, Variables.getAllCharacters());
		
		if(!isReal)
		{
			victim = new AICharacter(victim.getName(), victim.getHealth(), (int)victim.getStrength(), (int)victim.getIntelligence(), victim.getPosX(), victim.getPosY(), null);
		}
		
		AbstractCharacter winner = calculateWinner(character, victim);
		
		if(isReal)
		{
			//System.out.println("--------------------------------------------" + character.getName() + " attacks " + victim.getName() + " and " + winner.getName() + " is the winner");
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
	

	
	
	
	private characters.AbstractCharacter calculateWinner(characters.AbstractCharacter character1, characters.AbstractCharacter character2)
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
	
	private int fightCapacity(characters.AbstractCharacter character)
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
	
	
	public static characters.AbstractCharacter choseVictim(characters.AbstractCharacter character, List<characters.AbstractCharacter> characterList)
	{
		AbstractCharacter bestVictim = null;
		int best = -10000;// = winnings * probability of winning
		int test;
		double winnings;
		int weaponEquiped = 0;
		for(characters.AbstractCharacter victim: characterList)
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
	
	
	private static double calculateFightWinnings(characters.AbstractCharacter winner, characters.AbstractCharacter loser)
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
		double successRate = character.getSchedule().getPlace(time).getAttackSR() * (character.getIntelligence() + character.getStrength()) / 40;
		return successRate;
	}


	

}
