package characters;

import gui.Node;

import java.util.Random;

import logic.Variables;

import places.Place;

public class Animation
{
	double roamX;
	double roamY;
	double aimX;
	double aimY;
	double norm;
	boolean moving;
	
	Random random;
	AbstractCharacter character;
	
	public Animation(AbstractCharacter parent)
	{
		character = parent;
		roamX = 10;
		roamY = 10;
		aimX = 11;
		aimY = 11;
		norm =1;
		random = new Random();
		moving = false;
	}
	
	public void updateRoam(Place place)
	{
		if(moving == true)
		{
			
		}
		else
		{
			double distX = roamX - (double)aimX;
			double distY = roamY - (double)aimY;
			
			norm = Math.sqrt(Math.abs(distX*distX + distY * distY));
			double divisionX = distX / norm;
			double divisionY = distY / norm;
			
			if(norm <= 10 && norm >= -10)
			{
				choseRandomSpot(place);
			}
			
			roamX -= divisionX/50;
			roamY -= divisionY/50;
		}

	}
	
	private void choseRandomSpot(Place place)
	{
		aimX = random.nextInt(place.getSizeX());
		aimY = random.nextInt(place.getSizeY());
	}
	
	public Node findFirstNode()
	{
		Node returnNode = new Node();
		
		for(Node node: Variables.getGameLogic().getUserInterface().getGameMap().getNodes())
		{
			if(node.getPlace() == character.currentPlace)
			{
				returnNode = node;
			}
		}
		return returnNode;
	}

	public double getRoamX()
	{
		return roamX;
	}



	public double getRoamY()
	{
		return roamY;
	}

	public boolean isMoving()
	{
		return moving;
	}

	public void setMoving(boolean moving)
	{
		this.moving = moving;
	}




}
