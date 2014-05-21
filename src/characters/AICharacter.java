package characters;

import logic.Variables;
import places.Cell;
import places.Place;
import schedule.PrisonAction;
import schedule.Schedule;

public class AICharacter extends Character
{

	Preferences preferences;
	
	public AICharacter(String _name, int _health, int _strength, int _intelligence, int _posX, int _posY)
	{
		super(_name,_health,_strength,  _intelligence, _posX, _posY);
		
		
		legalAdvancement =1;
		materials = 0;
		influence = 0;
		money = 100;
		weapon = false;
		tool = false;
		
		currentPlace = new Cell();
		
		schedule = new Schedule();
		preferences = new Preferences();
	}
	
	
	public AICharacter(AICharacter _character)
	{
		
		super(_character.name, _character.health, (int)_character.strength, (int)_character.intelligence, _character.posX, _character.posY);
		
		
		name = _character.name;
		health = _character.health;
		strength = _character.strength;
		intelligence = _character.intelligence;
		posX = _character.posX;
		posY = _character.posY;
		
		
		
		this.legalAdvancement = _character.legalAdvancement;
		this.materials = _character.materials;
		this.influence = _character.influence;
		this.money = _character.money;
		this.weapon = _character.weapon;
		this.tool = _character.tool;
		
		
		//copy preferences
		preferences = new Preferences(_character.preferences);
		
		schedule = new Schedule(_character.schedule);
	}
	
	public double happiness()
	{
		
		
		
		double wellBeingHappiness = (double)health / 20;
		if(health > 70)
		{
			wellBeingHappiness += 10;
		}
		else if(health > 50)
		{
			wellBeingHappiness += 15;
		}
		else if(health > 20)
		{
			wellBeingHappiness += 20;
		}
		wellBeingHappiness += strength * 10;
		
		wellBeingHappiness *= preferences.wellBeingPreference;
		//System.out.println("wellbeinghappiness " + wellBeingHappiness);
		
		
		
		
		
		
		
		double evasionHappiness = (double)strength * 8;
		evasionHappiness += money;
		evasionHappiness += influence;
		evasionHappiness += (double)materials * 0.09;
		if(weapon)
		{
			evasionHappiness += 10;
		}

		for(Place place: schedule.getAllPlaces())
		{
			evasionHappiness += (double)place.getDigAdvancement()*Variables.getDigadvancementimportance();
			evasionHappiness += (100 - (double)place.getGuardAwareness())*Variables.getGuardawarenessimportance();
		}
		evasionHappiness *= preferences.evasionPreference;
		
		
		
		
		//System.out.println("evasionHappiness total " + evasionHappiness);
		
		
		
		
		
		
		
		
		
		
		double educationHappiness = (double)intelligence * 60;
		educationHappiness = educationHappiness + legalAdvancement * 50;
		educationHappiness *= preferences.educationPreference;
		
		//System.out.println("educationHappiness " + educationHappiness);
		
		return wellBeingHappiness + evasionHappiness + educationHappiness;
	}

	
	public Preferences getPreferences() {
		return preferences;
	}

}
