package schedule;

import java.util.ArrayList;
import java.util.List;

import places.Library;
import places.Place;
import characters.AICharacter;

public class Learn extends PrisonAction
{
	public Learn()
	{
		name = "learn";
	}
	
	public void resolve(AICharacter character, int time, boolean isReal)
	{
		character.setIntelligence(character.getIntelligence() + 1/(character.getIntelligence()*0.3));
	}
	



}
