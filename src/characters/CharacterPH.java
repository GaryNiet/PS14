package characters;

import schedule.PrisonAction;
import schedule.Schedule;

public class CharacterPH
{
	String name;


	int health;
	int strength;
	int intelligence;
	int posX, posY;
	Preferences preferences;
	Schedule schedule;
	PrisonAction fixedAction;
	
	public CharacterPH(String _name, int _health, int _strength, int _intelligence, int _posX, int _posY)
	{
		name = _name;
		health = _health;
		strength = _strength;
		intelligence = _intelligence;
		posX = _posX;
		posY = _posY;
		
		schedule = new Schedule();
		preferences = new Preferences();
	}
	
	public CharacterPH(CharacterPH character)
	{
		name = character.name;
		health = character.health;
		strength = character.strength;
		intelligence = character.intelligence;
		posX = character.posX;
		posY = character.posY;
		
		//copy preferences
		preferences = new Preferences(character.preferences);
		
		//might be useless
		schedule = new Schedule(character.schedule);
	}
	
	public void naturalHealthLoss()
	{
		health -= 1;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getName() {
		return name;
	}
	
	public PrisonAction getFixedAction() {
		return fixedAction;
	}

	public void setFixedAction(PrisonAction fixedAction) {
		this.fixedAction = fixedAction;
	}
	
	public Preferences getPreferences() {
		return preferences;
	}

	public Schedule getSchedule() {
		return schedule;
	}

}
