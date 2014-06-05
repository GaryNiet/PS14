package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.Border;

import logic.Variables;
import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.Kitchen;
import places.Library;
import places.PhoneBooth;
import places.Place;
import places.Showers;
import places.VisitingCell;
import places.Workshop;
import characters.AICharacter;
import characters.AbstractCharacter;

@SuppressWarnings("serial")
public class GameMap extends JPanel{
	
	Border border;
	UserInterface parent;
	InfoBox infoBox;
	
	List<Rectangle2D> placeList;
	Rectangle2D player;
	List<Rectangle2D> aiRectangles;
	Random random;
	
	List<Node> nodes;
	
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
		nodes = new ArrayList<>();
		initNodes();
		
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
	
	private void initNodes()
	{
		Node newNode = new Node((int) (0.212 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.07 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Cell());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.24 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.07 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Courtyard());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.28 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.20 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Courtyard());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.53 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.20 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Courtyard());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.585 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.07 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Courtyard());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.63 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.07 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Showers());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.28 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.30 * Variables.getYresolution() * Variables.getResolutionmultiplier()), null);
		nodes.add(newNode);
		
		newNode = new Node((int) (0.315 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.30 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Library());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.26 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.30 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new PhoneBooth());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.19 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.30 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new PhoneBooth());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.14 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.30 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Cafeteria());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.18 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.41 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Kitchen());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.14 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.41 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Cafeteria());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.53 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.41 * Variables.getYresolution() * Variables.getResolutionmultiplier()), null);
		nodes.add(newNode);
		
		newNode = new Node((int) (0.49 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.41 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Library());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.565 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.41 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new VisitingCell());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.53 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.62 * Variables.getYresolution() * Variables.getResolutionmultiplier()), null);
		nodes.add(newNode);
		
		newNode = new Node((int) (0.45 * Variables.getXresolution() * Variables.getResolutionmultiplier()),(int)(0.62 * Variables.getYresolution() * Variables.getResolutionmultiplier()), new Workshop());
		nodes.add(newNode);
		
		nodes.get(0).addNode(nodes.get(1));
		nodes.get(1).addNode(nodes.get(0));
		nodes.get(1).addNode(nodes.get(2));
		nodes.get(1).addNode(nodes.get(3));
		nodes.get(1).addNode(nodes.get(4));
		nodes.get(2).addNode(nodes.get(1));
		nodes.get(2).addNode(nodes.get(3));
		nodes.get(2).addNode(nodes.get(4));
		nodes.get(2).addNode(nodes.get(6));
		nodes.get(3).addNode(nodes.get(1));
		nodes.get(3).addNode(nodes.get(2));
		nodes.get(3).addNode(nodes.get(4));
		nodes.get(3).addNode(nodes.get(13));
		nodes.get(4).addNode(nodes.get(1));
		nodes.get(4).addNode(nodes.get(2));
		nodes.get(4).addNode(nodes.get(3));
		nodes.get(4).addNode(nodes.get(5));
		nodes.get(5).addNode(nodes.get(4));
		nodes.get(6).addNode(nodes.get(2));
		nodes.get(6).addNode(nodes.get(7));
		nodes.get(6).addNode(nodes.get(8));
		nodes.get(7).addNode(nodes.get(14));
		nodes.get(7).addNode(nodes.get(6));
		nodes.get(8).addNode(nodes.get(6));
		nodes.get(8).addNode(nodes.get(9));
		nodes.get(9).addNode(nodes.get(10));
		nodes.get(9).addNode(nodes.get(8));
		nodes.get(10).addNode(nodes.get(9));
		nodes.get(10).addNode(nodes.get(12));
		nodes.get(11).addNode(nodes.get(12));
		nodes.get(12).addNode(nodes.get(10));
		nodes.get(12).addNode(nodes.get(11));
		nodes.get(13).addNode(nodes.get(3));
		nodes.get(13).addNode(nodes.get(14));
		nodes.get(13).addNode(nodes.get(15));
		nodes.get(13).addNode(nodes.get(16));
		nodes.get(14).addNode(nodes.get(13));
		nodes.get(14).addNode(nodes.get(7));
		nodes.get(15).addNode(nodes.get(13));
		nodes.get(16).addNode(nodes.get(13));
		nodes.get(16).addNode(nodes.get(17));
		nodes.get(17).addNode(nodes.get(16));
		
		
		
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
				//System.out.println(characterIndex);
			}
		}
		
	}
	
	public synchronized void paint(Graphics g)
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
		
		g1.setPaint(Color.red);
		for(Node node: nodes)
		{
			node.paint(g);
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

	public List<Node> getNodes()
	{
		return nodes;
	}

	public void addCharacter(AICharacter newCharacter)
	{
		aiRectangles.add(new Rectangle2D.Double(0,0, Variables.getPlayerwidth(), Variables.getPlayerheight()));
	}

}
