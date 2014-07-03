package save;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import logic.Variables;

import characters.AICharacter;
import characters.PlayerCharacter;

public class Deserialize
{
	public static void load()
	{
		File folder = new File("saves/");
		File[] listOfFiles = folder.listFiles();

		List<AICharacter> replacementList = new ArrayList<>();
		
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if(listOfFiles[i].getName().equals("player.sav"))
			{
				PlayerCharacter character = null;
				try
				{
					FileInputStream fileIn = new FileInputStream("saves/" + listOfFiles[i].getName());
					ObjectInputStream in = new ObjectInputStream(fileIn);
					character = (PlayerCharacter) in.readObject();
					in.close();
					fileIn.close();
				} catch (IOException j)
				{
					j.printStackTrace();
					return;
				} catch (ClassNotFoundException c)
				{
					System.out.println("Employee class not found");
					c.printStackTrace();
					return;
				}
				
				Variables.setPlayerCharacter(character);
			}
			else if (!listOfFiles[i].isHidden())
			{
				//System.out.println("File " + listOfFiles[i].getName());
				
				AICharacter character = null;
				try
				{
					FileInputStream fileIn = new FileInputStream("saves/" + listOfFiles[i].getName());
					ObjectInputStream in = new ObjectInputStream(fileIn);
					character = (AICharacter) in.readObject();
					in.close();
					fileIn.close();
				} catch (IOException j)
				{
					j.printStackTrace();
					return;
				} catch (ClassNotFoundException c)
				{
					System.out.println("Employee class not found");
					c.printStackTrace();
					return;
				}
				replacementList.add(character);
				
			}
			
			
			
			
		}
		Variables.setCharacterList(replacementList);


	}
}
