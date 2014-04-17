package characters;

import java.util.Random;

public class Preferences
{
	double wellBeingPreference;
	double evasionPreference;
	double educationPreference;
	
	public Preferences()
	{
		Random random = new Random();
		wellBeingPreference = 10 + random.nextFloat() * 100;
		evasionPreference	 = 10 + random.nextFloat()*100;
		educationPreference = 10 + random.nextFloat()*100;
	}
	
	public Preferences(Preferences preference)
	{
		this.wellBeingPreference = preference.wellBeingPreference;
		this.evasionPreference = preference.evasionPreference;
		this.educationPreference = preference.educationPreference;
	}

}
