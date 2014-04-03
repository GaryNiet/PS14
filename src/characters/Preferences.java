package characters;

import java.util.Random;

public class Preferences
{
	int healthPreference;
	int strengthPreference;
	int intelligencePreference;
	
	public Preferences()
	{
		Random random = new Random();
		healthPreference = random.nextInt(50) + 1;
	}

	public int getHealthPreference() {
		return healthPreference;
	}

	public int getStrengthPreference() {
		return strengthPreference;
	}

	public int getIntelligencePreference() {
		return intelligencePreference;
	}
}
