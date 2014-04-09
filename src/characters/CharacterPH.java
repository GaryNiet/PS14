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
	int money;
	int materials;
	int influence;
	boolean weapon;
	boolean tool;
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
	
	public double happiness()
	{
		//well being takes into account:
		//health over max health
		//the more strength the better
		//
		double wellBeingHappiness = (double)health * preferences.wellBeingPreference;
		
		double evasionHappiness = (double)strength * preferences.evasionPreference;
		double educationHappiness = (double)intelligence * preferences.educationPreference;
		
		
		return wellBeingHappiness + evasionHappiness + educationHappiness;
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMaterials() {
		return materials;
	}

	public void setMaterials(int materials) {
		this.materials = materials;
	}

	public int getInfluence() {
		return influence;
	}

	public void setInfluence(int influence) {
		this.influence = influence;
	}

	public boolean isWeapon() {
		return weapon;
	}

	public void setWeapon(boolean weapon) {
		this.weapon = weapon;
	}

	public boolean isTool() {
		return tool;
	}

	public void setTool(boolean tool) {
		this.tool = tool;
	}

}
