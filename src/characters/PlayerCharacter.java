package characters;

import gui.CharacterPieces;

import java.util.Iterator;

import places.Cell;
import places.Free;
import places.Place;

public class PlayerCharacter extends AbstractCharacter
{
	
	Place freeChoice;
	AICharacter victim;
	
	public PlayerCharacter(String _name, int _health, int _strength, int _intelligence, int _posX, int _posY, CharacterPieces characterPieces)
	{
		super(_name,_health,_strength,  _intelligence, _posX, _posY, characterPieces);
		job = this.schedule.getAllPlaces().get(0);
		this.freeChoice = new Cell();
		materials = 1000;
		intelligence = 6;
		strength = 6;
		
	}
	
	public void setCurrentPlace(Place currentPlace)
	{
		if(currentPlace instanceof Free)
		{
			this.currentPlace = this.freeChoice;
		}
		else
		{
			this.currentPlace = currentPlace;
		}
		
	}

	public Place getFreeChoice() {
		return freeChoice;
	}

	public void setFreeChoice(Place freeChoice) {
		this.freeChoice = freeChoice;
	}
	
	public void setvictim(AICharacter _victim)
	{
		victim = _victim;
	}
	
	public AICharacter getVictim()
	{
		return victim;
	}


}
