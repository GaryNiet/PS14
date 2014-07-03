package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class CharacterPieces implements Serializable
{
	//head&face 154x225
	static List<BufferedImage> bodyList;
	static List<BufferedImage> headList;
	static List<BufferedImage> faceList;
	
	static BufferedImage mediumBody;
	static BufferedImage fat1;
	static BufferedImage medium2;
	static BufferedImage slim;
	static BufferedImage fatty;
	static BufferedImage strong1;
	static BufferedImage head1;
	static BufferedImage head2;
	static BufferedImage head3;
	static BufferedImage head4;
	static BufferedImage head5;
	static BufferedImage head6;
	static BufferedImage head7;
	static BufferedImage beard1;
	static BufferedImage beard2;
	static BufferedImage beard3;
	static BufferedImage beard4;
	static BufferedImage beard5;
	static BufferedImage beard6;
	static BufferedImage scar1;
	static BufferedImage nose;
	static BufferedImage scar2;
	static BufferedImage hair1;
	static BufferedImage hair2;
	static BufferedImage hair3;
	static BufferedImage hair4;
	static BufferedImage moustache;
	
	public CharacterPieces()
	{
		loadImages();
		bodyList = new ArrayList<>();
		bodyList.add(mediumBody);
		bodyList.add(fat1);
		bodyList.add(medium2);
		bodyList.add(strong1);
		bodyList.add(slim);
		bodyList.add(fatty);
		headList = new ArrayList<>();
		headList.add(head1);
		headList.add(head2);
		headList.add(head3);
		headList.add(head4);
		headList.add(head5);
		headList.add(head6);
		headList.add(head7);
		faceList = new ArrayList<>();
		faceList.add(beard1);
		faceList.add(beard2);
		faceList.add(beard3);
		faceList.add(beard4);
		faceList.add(beard5);
		faceList.add(beard6);
		faceList.add(scar1);
		faceList.add(moustache);
		faceList.add(scar2);
		faceList.add(hair1);
		faceList.add(hair2);
		faceList.add(hair3);
		faceList.add(hair4);
		faceList.add(nose);
		
	}

	
	private void loadImages()
	{
		try
		{
			mediumBody = ImageIO.read(new File("ressources/bodyParts/mediumBody.png"));
			fat1 = ImageIO.read(new File("ressources/bodyParts/fat1.png"));
			medium2 = ImageIO.read(new File("ressources/bodyParts/medium2.png"));
			strong1 = ImageIO.read(new File("ressources/bodyParts/strong1.png"));
			slim = ImageIO.read(new File("ressources/bodyParts/slim.png"));
			fatty = ImageIO.read(new File("ressources/bodyParts/fatty.png"));
			head1 = ImageIO.read(new File("ressources/bodyParts/head1.png"));
			head2 = ImageIO.read(new File("ressources/bodyParts/head2.png"));
			head3 = ImageIO.read(new File("ressources/bodyParts/head3.png"));
			head4 = ImageIO.read(new File("ressources/bodyParts/head4.png"));
			head5 = ImageIO.read(new File("ressources/bodyParts/head5.png"));
			head6 = ImageIO.read(new File("ressources/bodyParts/head6.png"));
			head7 = ImageIO.read(new File("ressources/bodyParts/head7.png"));
			beard1 = ImageIO.read(new File("ressources/bodyParts/beard1.png"));
			beard2 = ImageIO.read(new File("ressources/bodyParts/beard2.png"));
			beard3 = ImageIO.read(new File("ressources/bodyParts/beard3.png"));
			beard4 = ImageIO.read(new File("ressources/bodyParts/beard4.png"));
			beard5 = ImageIO.read(new File("ressources/bodyParts/beard5.png"));
			beard6 = ImageIO.read(new File("ressources/bodyParts/beard6.png"));
			scar1 = ImageIO.read(new File("ressources/bodyParts/scar1.png"));
			scar2 = ImageIO.read(new File("ressources/bodyParts/scar2.png"));
			moustache = ImageIO.read(new File("ressources/bodyParts/moustache.png"));
			hair1 = ImageIO.read(new File("ressources/bodyParts/hair1.png"));
			hair2 = ImageIO.read(new File("ressources/bodyParts/hair2.png"));
			hair3 = ImageIO.read(new File("ressources/bodyParts/hair3.png"));
			hair4 = ImageIO.read(new File("ressources/bodyParts/hair4.png"));
			nose = ImageIO.read(new File("ressources/bodyParts/nose.png"));

		} catch (IOException ex)
		{

			System.out.println("file not found");
		}
	}
	
	static BufferedImage getBody(int i)
	{
		return bodyList.get(i);
	}
	
	static BufferedImage getHead(int i)
	{
		return headList.get(i);
	}
	
	static BufferedImage getFace(int i)
	{
		return faceList.get(i);
	}


	public static List<BufferedImage> getBodyList()
	{
		return bodyList;
	}


	public static List<BufferedImage> getHeadList()
	{
		return headList;
	}


	public static List<BufferedImage> getFaceList()
	{
		return faceList;
	}
	
	
	
	
}
