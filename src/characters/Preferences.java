package characters;

import java.io.Serializable;
import java.util.Random;

@SuppressWarnings("serial")
public class Preferences implements Serializable
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
