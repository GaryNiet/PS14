package characters;

import java.util.Random;

public class Preferences
{
	double healthPreference;
	double strengthPreference;
	double intelligencePreference;
	
	public Preferences()
	{
		Random random = new Random();
		healthPreference = random.nextFloat() + 0.5;
		strengthPreference = 11 + (random.nextFloat()-0.5)*3;
		intelligencePreference = 11 + (random.nextFloat()-0.5)*3;
	}
	
	public Preferences(Preferences preference)
	{
		this.healthPreference = preference.healthPreference;
		this.strengthPreference = preference.strengthPreference;
		this.intelligencePreference = preference.intelligencePreference;
	}

	public double getHealthPreference() {
		return healthPreference;
	}

	public double getStrengthPreference() {
		return strengthPreference;
	}

	public double getIntelligencePreference() {
		return intelligencePreference;
	}
}
