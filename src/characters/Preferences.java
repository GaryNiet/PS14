package characters;

import java.util.Random;

public class Preferences
{
	double wellBeingPreference;
	double evasionPreference;
	double educationPreference;
	
	public Preferences()
	{
		//Random random = new Random();
		wellBeingPreference = 1;
		evasionPreference	 = 1;
		educationPreference = 1;
	}
	
	public Preferences(Preferences preference)
	{
		this.wellBeingPreference = preference.wellBeingPreference;
		this.evasionPreference = preference.evasionPreference;
		this.educationPreference = preference.educationPreference;
	}

}
