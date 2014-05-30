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
	}
	
	public void updateRoam(Place place)
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
	
	private void choseRandomSpot(Place place)
	{
		aimX = random.nextInt(place.getSizeX());
		aimY = random.nextInt(place.getSizeY());
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
