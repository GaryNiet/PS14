package characters;

import gui.Node;

import java.util.ArrayList;
import java.util.List;
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
	
	Node firstNode;
	Node lastNode;
	
	List<Node> path;
	
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
		
		path = new ArrayList<>();
		firstNode = new Node();
		lastNode = new Node();
	}
	
	public void updateRoam(Place place)
	{
		if(moving == true)
		{
			
			createPath();
			
			aimX = lastNode.getPosX();
			aimY = lastNode.getPosY();
			
			double distX = roamX - (double)aimX;
			double distY = roamY - (double)aimY; 
			
			norm = Math.sqrt(Math.abs(distX*distX + distY * distY));
			double divisionX = distX / norm;
			double divisionY = distY / norm;
			
			
			double destDistX = roamX - lastNode.getPosX();
			double destDistY = roamY - lastNode.getPosY(); 
			double distToDest = Math.sqrt(Math.abs(destDistX*destDistX + destDistY * destDistY));
			if(distToDest <= 10 && distToDest >= -10)
			{
				moving = false;
			}
			
			roamX -= divisionX/20;
			roamY -= divisionY/20;
			
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
	
	private void createPath()
	{
		
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
			int distance = 10000;
			if((node.getPosX() + node.getPosY()) < distance)
			{
				returnNode = node;
			}
		}
		return returnNode;
	}
	
	public Node findLastNode()
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

	public void setMoving()
	{
		if(moving == true)
		{
			moving = false;
		}
		else
		{
			moving = true;
			
			firstNode = findFirstNode();
			lastNode = findLastNode();
			
			
			roamX += character.getPosX() - character.getCurrentPlace().getPosX();
			roamY += character.getPosY() - character.getCurrentPlace().getPosY();
		}
		
	}




}
