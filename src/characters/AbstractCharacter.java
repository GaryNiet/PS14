package characters;

import gui.CharacterLook;
import gui.CharacterPieces;

import java.util.Iterator;
import java.util.Random;

import logic.GameLogic;
import logic.Variables;

import places.Cell;
import places.Job;
import places.Place;
import schedule.PrisonAction;
import schedule.Schedule;

public abstract class AbstractCharacter
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
	Place lastPlace;
	Place job;
	Place nextJob;
	int resetRoam;
	Random random;
	Animation animation;
	double movementPeriod;
	CharacterLook characterLook;
	
	boolean isEscaped;
	
	
	public AbstractCharacter(String _name, int _health, int _strength, int _intelligence, int _posX, int _posY, CharacterPieces characterPieces)
	{
		random = new Random();
		
		movementPeriod = ((random.nextDouble() + 2) / 1.7) * Variables.getGameSpeed()/(50 * Variables.getResolutionmultiplier());
		name = _name;
		health = 100;
		strength = random.nextInt(6) + 3;
		intelligence = random.nextInt(6) + 3;
		posX = _posX;
		posY = _posY;
		
		
		legalAdvancement =1;
		materials = 0;
		influence = 0;
		money = 100;
		weapon = false;
		tool = false;
		isEscaped = false;
		
		animation = new Animation(this);
		
		currentPlace = new Cell();
		lastPlace = new Cell();
		
		job = Job.getRandomJob();
		nextJob = null;
		
		characterLook = new CharacterLook(characterPieces);
		schedule = new Schedule();
	}
	
	public void updateRoam()
	{
		
		animation.updateRoam(currentPlace);
		
	}
	
	
	
	public void naturalHealthLoss()
	{
		health -= 1;
		checkHealthIntegrity();
	}
	
	public synchronized void checkHealthIntegrity()
	{
		if(health > 100)
		{
			health = 100;
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

	public void setCurrentPlace(Place _currentPlace)
	{
		this.lastPlace = currentPlace;
		this.currentPlace = _currentPlace;
		
	}



	public Place getJob() {
		return job;
	}

	public void setJob(Place job) {
		this.job = job;
	}

	public Animation getAnimation()
	{
		return animation;
	}

	public boolean isEscaped()
	{
		return isEscaped;
	}

	public void setEscaped(boolean isEscaped)
	{
		this.isEscaped = isEscaped;
	}
	
	public void setSpeed()
	{
		movementPeriod = ((random.nextDouble() + 2) / 1.7) * Variables.getGameSpeed()/18;
	}

	public Place getNextJob()
	{
		return nextJob;
	}

	public void setNextJob(Place nextJob)
	{
		this.nextJob = nextJob;
	}

	public Place getLastPlace()
	{
		return lastPlace;
	}

	public void setLastPlace(Place lastPlace)
	{
		this.lastPlace = lastPlace;
	}

	public CharacterLook getCharacterLook()
	{
		return characterLook;
	}
}
