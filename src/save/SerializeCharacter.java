package save;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import logic.Variables;

import gui.CharacterPieces;
import characters.AICharacter;
import characters.PlayerCharacter;

public class SerializeCharacter
{
	public static void save()
	{
		CharacterPieces characterPieces = Variables.getCharacterPieces();
		
		int index = 1;
		for(AICharacter character: Variables.getCharacterList())
		{
			try
			{
				String filename = "character" + Integer.toString(index);
				FileOutputStream fileOut = new FileOutputStream("saves/" + filename + ".sav");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(character);
				out.close();
				fileOut.close();
			} catch (IOException i)
			{
				i.printStackTrace();
			}
			index ++;
		}
		
		PlayerCharacter playerCharacter = Variables.getPlayerCharacter();
		
		try
		{
			FileOutputStream fileOut = new FileOutputStream("saves/player.sav");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(playerCharacter);
			out.close();
			fileOut.close();
		} catch (IOException i)
		{
			i.printStackTrace();
		}

	}
}
