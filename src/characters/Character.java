package characters;

import logic.Variables;
import places.Cell;
import places.Place;
import schedule.PrisonAction;
import schedule.Schedule;

public abstract class Character
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
	Schedule schedule;
	PrisonAction fixedAction;
	Place currentPlace;
	
	public Character(String _name, int _health, int _strength, int _intelligence, int _posX, int _posY)
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
