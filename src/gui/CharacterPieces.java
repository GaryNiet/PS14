package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CharacterPieces
{

	static BufferedImage mediumBody;
	
	public enum Heads
	{
		
	}
	
	public enum Bodies
	{
		MEDIUM;
	}
	
	public enum Faces
	{
		
	}
	
	public CharacterPieces()
	{
		loadImages();
	}

	
	private void loadImages()
	{
		try
		{
			mediumBody = ImageIO.read(new File("mediumBody.png"));

		} catch (IOException ex)
		{

			System.out.println("file not found");
		}
	}
	
	static BufferedImage getBody(String text)
	{
		return mediumBody;
	}
	
	
}
