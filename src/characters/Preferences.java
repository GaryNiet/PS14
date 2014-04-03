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
		strengthPreference = random.nextInt(50) + 1;
		intelligencePreference = random.nextInt(50) + 1;
	}
	
	public Preferences(Preferences preference)
	{
		this.healthPreference = preference.healthPreference;
		this.strengthPreference = preference.strengthPreference;
		this.intelligencePreference = preference.intelligencePreference;
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
