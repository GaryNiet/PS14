package characters;

import places.Place;
import schedule.PrisonAction;
import schedule.Schedule;

public class CharacterPH
{
	String name;


	int health;
	double strength;
	double intelligence;
	int posX, posY;
	int money;
	int materials;
	int influence;
	boolean weapon;
	boolean tool;
	double legalAdvancement;
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
		
		legalAdvancement =0;
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
		
		schedule = new Schedule(character.schedule);
	}
	
	public double happiness()
	{
		//well being takes into account:
		//health over max health
		//the more strength the better
		//
		double wellBeingHappiness = (double)health / 10;
		if(health > 50)
		{
			wellBeingHappiness += 15;
		}
		wellBeingHappiness += strength * 5;
		wellBeingHappiness *= preferences.wellBeingPreference;
		System.out.println("wellbeinghappiness " + wellBeingHappiness);
		
		//evasion happiness takes into account:
		//amount of money, amount of influence
		//dig progression
		//resolve legal progression
		// amount of materials
		double evasionHappiness = (double)strength;
		evasionHappiness += money;
		evasionHappiness += influence;
		evasionHappiness += (double)materials * 0.3;
		for(Place place: schedule.getAllPlaces())
		{
			evasionHappiness += (double)place.getDigAdvancement();
		}
		evasionHappiness *= preferences.evasionPreference;
		
		System.out.println("evasionHappiness " + evasionHappiness);
		
		//education happiness takes into account:
		//intelligence
		double educationHappiness = (double)intelligence;
		educationHappiness *= preferences.educationPreference;
		
		System.out.println("educationHappiness " + educationHappiness);
		
		return wellBeingHappiness + evasionHappiness + educationHappiness;
	}
	
	public void naturalHealthLoss()
	{
		health -= 1;
		checkHealthIntegrity();
	}
	
	public void checkHealthIntegrity()
	{
		if(health > 100)
		{
			health = 100;
		}
		if(health <= 0)
		{
			//TODO die
		}
	
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public double getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(double intelligence) {
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

	public double getLegalAdvancement() {
		return legalAdvancement;
	}

	public void setLegalAdvancement(double legalAdvancement) {
		this.legalAdvancement = legalAdvancement;
	}

}
