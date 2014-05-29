package characters;

import java.util.Random;

import places.Place;

public class Animation
{
	double roamX;
	double roamY;
	double aimX;
	double aimY;
	double norm;
	double diffX;
	double diffY;
	
	Random random;
	AbstractCharacter character;
	
	public Animation(AbstractCharacter parent)
	{
		character = parent;
		roamX = 10;
		roamY = 10;
		aimX = 10;
		aimY = 10;
		norm =0;
		random = new Random();
	}
	
	public void updateRoam(Place place)
	{
		double distX = roamX - aimX;
		double distY = roamY - aimY;
		
		//norm = Math.sqrt(diffX*diffX + diffY * diffY);
		//double divisionX = diffX / Math.sqrt(Math.abs(diffX*diffX + diffY * diffY));
		
		
		if(distX < 20 && distX > -20 && distY < 20 && distY > -20)
		{
			choseRandomSpot(place);
		}
		
		roamX -= diffX / 1000;
		roamY -= diffY  / 1000;

	}
	
	private void choseRandomSpot(Place place)
	{
		
		
		aimX = random.nextInt(place.getSizeX());
		aimY = random.nextInt(place.getSizeY());
		
		diffX = roamX - aimX;
		diffY = roamY - aimY;
	}

	public double getRoamX()
	{
		return roamX;
	}



	public double getRoamY()
	{
		return roamY;
	}




}
