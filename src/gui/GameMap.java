package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import characters.AICharacter;
import characters.AbstractCharacter;

import logic.Variables;

import places.Place;
import places.Showers;

@SuppressWarnings("serial")
public class GameMap extends JPanel{
	
	Border border;
	UserInterface parent;
	InfoBox infoBox;
	
	List<Rectangle2D> placeList;
	Rectangle2D player;
	List<Rectangle2D> aiRectangles;
	Random random;
	
	private BufferedImage floor;
	private TexturePaint floorTex;
	private BufferedImage shower;
	private TexturePaint showerTex;
	private BufferedImage tiles;
	private TexturePaint tilesTex;
	
	
	
	
	
	public GameMap(UserInterface _parent)
	{
		parent = _parent;
		infoBox = parent.getInfoBox();
		
		random = new Random();
		
		placeList = new ArrayList<>();
		aiRectangles = new ArrayList<>();
		
		
		loadImages();
		
		
		player = new Rectangle2D.Double(10, 10, Variables.getPlayerwidth(), Variables.getPlayerheight());
		
		
		for(Place place: allPlaces())
		{
			Rectangle2D newPlace = new Rectangle2D.Double(place.getPosX(), place.getPosY(), place.getSizeX(), place.getSizeY());
			placeList.add(newPlace);
		}
		
		for(int i = 0; i< Variables.getCharacterList().size(); i++)
		{
			aiRectangles.add(new Rectangle2D.Double(0,0, Variables.getPlayerwidth(), Variables.getPlayerheight()));
		}
		
		this.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me)
	          { 
	            mouseClickReaction(me);
	          } 
	        }); 
		
	}
	
	private void loadImages()
	{
		try
		{
			floor = ImageIO.read(new File("paving.png"));
			shower = ImageIO.read(new File("shower.png"));
			tiles = ImageIO.read(new File("tile.png"));

		} catch (IOException ex)
		{

			System.out.println("file not found");
		}
	}
	
	private void mouseClickReaction(MouseEvent me)
	{
		
		for(Rectangle2D place: placeList)
		{
			if(place.contains(me.getPoint()))
			{
				int placeIndex = placeList.indexOf(place);
				infoBox.fillInfo(allPlaces().get(placeIndex));
			}
			
		}
		
		
		for(Rectangle2D characterRect: aiRectangles)
		{
			if(characterRect.contains(me.getPoint()))
			{
				int characterIndex = aiRectangles.indexOf(characterRect);
				infoBox.fillInfo((AbstractCharacter)Variables.getCharacterList().get(characterIndex));
				System.out.println(characterIndex);
			}
		}
		
	}
	
	public void paint(Graphics g)
	{
		placePlayer();
		
		Graphics2D g1 = (Graphics2D)g;
		super.paintComponent(g1);
		
		floorTex = new TexturePaint(floor, new Rectangle2D.Double(0,0,50,50));
		g1.setPaint(floorTex);
		g1.fill(this.getBounds());
		
		g1.setPaint(Color.green);
		
		//draws places
		int i = 0;
		for(Rectangle2D place: placeList)
		{
			g1.setPaint(Color.green);
			if(i==3)
			{
				showerTex = new TexturePaint(shower, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(showerTex);
			}
			else if(i==4)
			{
				tilesTex = new TexturePaint(tiles, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(tilesTex);
			}
			
			g1.fill(place);
			i++;
		}
		
		int index = 0;
		for(AICharacter ai: Variables.getCharacterList())
		{
			g1.setPaint(Color.black);
			ai.updateRoam();
			aiRectangles.get(index).setFrame(ai.getPosX() + ai.getAnimation().getRoamX(), ai.getPosY() + ai.getAnimation().getRoamY(), Variables.getPlayerwidth(), Variables.getPlayerheight());
			g1.draw(aiRectangles.get(index));
			index++;
		}
		
		
		g1.setPaint(Color.white);
		g1.drawString("health: " + Variables.getPlayerCharacter().getHealth(), 0, 15);
		g1.drawString("strength: " + Variables.getPlayerCharacter().getStrength(), 100, 15);
		g1.drawString("intelligence: " + Variables.getPlayerCharacter().getIntelligence(), 200, 15);
		g1.drawString("money: " + Variables.getPlayerCharacter().getMoney(), 500, 15);
		g1.drawString("influence: " + Variables.getPlayerCharacter().getInfluence(), 600, 15);
		
		//draws player
		g1.draw(player);
		this.repaint();
		
	}
	
	public void placePlayer()
	{
		
		player.setFrame( getCurrentPlace().getPosX(), getCurrentPlace().getPosY(), Variables.getPlayerwidth(), Variables.getPlayerheight());
	}
	
	public List<Place> allPlaces()
	{
		
		return parent.gameLogic.getCharacter().getSchedule().getAllPlaces();
	}
	
	private Place getCurrentPlace()
	{
		return parent.gameLogic.getCharacter().getCurrentPlace();
	}
	
	public void showAction()
	{
		
		for(AICharacter ai: Variables.getCharacterList())
		{
			ai.setRoamX((int)(random.nextFloat()*ai.getCurrentPlace().getSizeX()));
			ai.setRoamY((int)(random.nextFloat()*ai.getCurrentPlace().getSizeY()));
		}
		
		System.out.println(parent.getGameLogic().getTime());
		System.out.println(parent.gameLogic.getCharacter().getSchedule().getAction(parent.getGameLogic().getTime()));
		System.out.println(parent.getGameLogic().getCharacter().getCurrentPlace());
		System.out.println("x: " + parent.getGameLogic().getCharacter().getCurrentPlace().getPosX());
	}

}
