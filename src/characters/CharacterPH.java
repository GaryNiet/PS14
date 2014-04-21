package characters;

import logic.Variables;
import places.Cell;
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
	Place currentPlace;
	
	public CharacterPH(String _name, int _health, int _strength, int _intelligence, int _posX, int _posY)
	{
		name = _name;
		health = _health;
		strength = _strength;
		intelligence = _intelligence;
		posX = _posX;
		posY = _posY;
		
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
	
	public CharacterPH(CharacterPH _character)
	{
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

	public void setInfluence(int d) {
		this.influence = d;
		if(influence < 0)
		{
			influence = 0;
		}
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

	public Place getCurrentPlace() {
		return currentPlace;
	}

	public void setCurrentPlace(Place currentPlace) {
		this.currentPlace = currentPlace;
	}

}
