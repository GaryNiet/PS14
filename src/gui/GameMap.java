package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
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
	
	double mult;
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
	private BufferedImage grass;
	private TexturePaint grassTex;
	private BufferedImage kitchen;
	private TexturePaint kitchenTex;
	private BufferedImage library;
	private TexturePaint libraryTex;
	private BufferedImage cafeteria;
	private TexturePaint cafeteriaTex;
	private BufferedImage cell;
	private TexturePaint cellTex;
	private BufferedImage phoneBooth;
	private TexturePaint phoneBoothTex;
	private BufferedImage visitingCell;
	private TexturePaint visitingCellTex;
	private BufferedImage workshop;
	private TexturePaint workshopTex;
	private BufferedImage cement;
	private TexturePaint cementTex;
	private BufferedImage knife;
	private BufferedImage dollar;
	
	
	
	
	
	public GameMap(UserInterface _parent)
	{
		mult = Variables.getResolutionmultiplier();
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
		
		
//		this.addMouseListener(new MouseAdapter() { 
//	          public void mousePressed(MouseEvent me)
//	          { 
//	            mouseClickReaction(me);
//	          } 
//	        }); 
		
	}
	
	private void initNodes()
	{
		Node newNode = new Node((int) (0.192 * Variables.getXresolution() * mult),(int)(0.07 * Variables.getYresolution() * mult), new Cell());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.26 * Variables.getXresolution() * mult),(int)(0.07 * Variables.getYresolution() * mult), new Courtyard());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.28 * Variables.getXresolution() * mult),(int)(0.18 * Variables.getYresolution() * mult), new Courtyard());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.53 * Variables.getXresolution() * mult),(int)(0.18 * Variables.getYresolution() * mult), new Courtyard());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.565 * Variables.getXresolution() * mult),(int)(0.12 * Variables.getYresolution() * mult), new Courtyard());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.65 * Variables.getXresolution() * mult),(int)(0.12 * Variables.getYresolution() * mult), new Showers());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.28 * Variables.getXresolution() * mult),(int)(0.30 * Variables.getYresolution() * mult), null);
		nodes.add(newNode);
		
		newNode = new Node((int) (0.335 * Variables.getXresolution() * mult),(int)(0.30 * Variables.getYresolution() * mult), new Library());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.24 * Variables.getXresolution() * mult),(int)(0.30 * Variables.getYresolution() * mult), new PhoneBooth());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.21 * Variables.getXresolution() * mult),(int)(0.30 * Variables.getYresolution() * mult), new PhoneBooth());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.12 * Variables.getXresolution() * mult),(int)(0.30 * Variables.getYresolution() * mult), new Cafeteria());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.20 * Variables.getXresolution() * mult),(int)(0.41 * Variables.getYresolution() * mult), new Kitchen());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.12 * Variables.getXresolution() * mult),(int)(0.41 * Variables.getYresolution() * mult), new Cafeteria());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.53 * Variables.getXresolution() * mult),(int)(0.41 * Variables.getYresolution() * mult), null);
		nodes.add(newNode);
		
		newNode = new Node((int) (0.47 * Variables.getXresolution() * mult),(int)(0.41 * Variables.getYresolution() * mult), new Library());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.585 * Variables.getXresolution() * mult),(int)(0.62 * Variables.getYresolution() * mult), new VisitingCell());
		nodes.add(newNode);
		
		newNode = new Node((int) (0.53 * Variables.getXresolution() * mult),(int)(0.62 * Variables.getYresolution() * mult), null);
		nodes.add(newNode);
		
		newNode = new Node((int) (0.43 * Variables.getXresolution() * mult),(int)(0.62 * Variables.getYresolution() * mult), new Workshop());
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
			shower = ImageIO.read(new File("shower.jpeg"));
			tiles = ImageIO.read(new File("tile.png"));
			knife = ImageIO.read(new File("knife.png"));
			grass = ImageIO.read(new File("grass.png"));
			kitchen = ImageIO.read(new File("kitchen.png"));
			cement = ImageIO.read(new File("cement.JPG"));
			dollar = ImageIO.read(new File("dollar.png"));

		} catch (IOException ex)
		{

			System.out.println("file not found");
		}
	}
	
	public void mouseClickReaction(MouseEvent me)
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
		
		Graphics2D g1 = (Graphics2D)g;
		super.paintComponent(g1);
		
		floorTex = new TexturePaint(floor, new Rectangle2D.Double(0,0,50,50));
		grassTex = new TexturePaint(grass, new Rectangle2D.Double(0,0,300,300));
		cementTex = new TexturePaint(cement, new Rectangle2D.Double(0,0,300,300));
		kitchenTex = new TexturePaint(kitchen, new Rectangle2D.Double(0,0,30,30));
		g1.setPaint(grassTex);
		g1.fill(this.getBounds());
		
		
		//draws places
		int i = 0;
		for(Rectangle2D place: placeList)
		{
			g1.setPaint(Color.black);
			if(i==0)
			{
				showerTex = new TexturePaint(shower, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(showerTex);
			}
			else if(i==1)
			{
				showerTex = new TexturePaint(shower, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(showerTex);
			}
			else if(i==2)
			{
				showerTex = new TexturePaint(shower, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(showerTex);
			}
			else if(i==3)
			{
				showerTex = new TexturePaint(shower, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(showerTex);
			}
			else if(i==4)
			{
				tilesTex = new TexturePaint(tiles, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(tilesTex);
			}
			else if(i==5)
			{
				showerTex = new TexturePaint(shower, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(showerTex);
			}
			else if(i==6)
			{
				showerTex = new TexturePaint(shower, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(showerTex);
			}
			else if(i==7)
			{
				showerTex = new TexturePaint(shower, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(kitchenTex);
			}
			else if(i==8)
			{
				showerTex = new TexturePaint(shower, new Rectangle2D.Double(0,0,50,50));
				g1.setPaint(showerTex);
			}
			
			g1.fill(place);
			
			drawName(g1, place, i);
		   
			
		   
			Stroke stroke = new BasicStroke(10);
			Shape strokedOutline = stroke.createStrokedShape(place);
			g1.setPaint(cementTex);
			
			g1.fill(strokedOutline);
			
			Stroke outline = new BasicStroke(2);
			Shape blackOutline = outline.createStrokedShape(strokedOutline);
			g1.setPaint(Color.black);
			g1.fill(blackOutline);
			
			i++;
		}
		
//		g1.setPaint(Color.red);
//		for(Node node: nodes)
//		{
//			node.paint(g);
//		}
		
		int index = 0;
		for(AICharacter ai: Variables.getCharacterList())
		{
			g1.setPaint(Color.white);
			ai.updateRoam();
			aiRectangles.get(index).setFrame(ai.getPosX() + ai.getAnimation().getRoamX(), ai.getPosY() + ai.getAnimation().getRoamY(), Variables.getPlayerwidth(), Variables.getPlayerheight());
			ai.getCharacterLook().paint(g, aiRectangles.get(index).getFrame());
			index++;
		}
		
		if(Variables.getPlayerCharacter().isWeapon())
		{
			g1.drawImage(knife, 700, 0, 50, 50, null);
		}
		
		
		g1.setPaint(Color.black);
		//long banner
		g1.fillRect(0, 0, this.getWidth(), (int)(mult * 15));
		//short banner
		g1.fillRect((int)(this.getWidth()-(mult * 170)), 0, (int)(mult * 170), (int)(mult * 45));
		
		g1.setPaint(Color.green);
		g1.setFont(new Font("TimesRoman", Font.PLAIN, (int)(15 * Variables.getResolutionmultiplier())));
		
		
		
		g1.drawString("health: " + (int)Variables.getPlayerCharacter().getHealth(), (int)(0 * mult) , (int)(13* mult));
		g1.drawString("strength: " + (int)Variables.getPlayerCharacter().getStrength(), (int)(70* mult), (int)(13* mult));
		g1.drawString("intelligence: " + (int)Variables.getPlayerCharacter().getIntelligence(), (int)(140* mult), (int)(13* mult));
		g1.drawString("money: " + (int)Variables.getPlayerCharacter().getMoney(), (int)(620* mult), (int)(15* mult));
		g1.drawString("influence: " + (int)Variables.getPlayerCharacter().getInfluence(), (int)(400* mult), (int)(13* mult));
		g1.drawString("materials: " + (int)Variables.getPlayerCharacter().getMaterials(),(int)(620* mult), (int)(35* mult));
		g1.drawString("legal advancement: " + Variables.getPlayerCharacter().getLegalAdvancement(), (int)(250* mult), (int)(13* mult));
		
		g1.drawImage(dollar, (int)(725* mult), 6, (int)(35* mult), (int)(35* mult), null);
		
		//draws player
		g1.draw(player);
		placePlayer(g);
		
		
	}
	
	private void drawName(Graphics2D g1, Rectangle2D place, int i)
	{
		Font font = new Font("Arial Black", Font.PLAIN, (int)(20 * Variables.getResolutionmultiplier()));
		FontRenderContext frc = g1.getFontRenderContext();
		TextLayout layout = new TextLayout(allPlaces().get(i).name, font, frc);
		   
		   
		Stroke outline = new BasicStroke(2);
		Shape blackOutline = outline.createStrokedShape(layout.getOutline(null));
			
		g1.setPaint(Color.white);
		g1.translate(place.getX() + 5, place.getY() + 30);
		g1.fill(blackOutline);
		g1.translate(-place.getX() -5, -place.getY() -30);

		   
	}
	
	public void placePlayer(Graphics g)
	{
		
		
		getPlayer().getAnimation().updateRoam(getCurrentPlace());
		player.setFrame( getPlayer().getPosX() + getPlayer().getAnimation().getRoamX() , getPlayer().getPosY() + getPlayer().getAnimation().getRoamY(), Variables.getPlayerwidth(), Variables.getPlayerheight());
		getPlayer().getCharacterLook().paint(g, player.getFrame());
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

	}

	public List<Node> getNodes()
	{
		return nodes;
	}

	public void addCharacter(AICharacter newCharacter)
	{
		aiRectangles.add(new Rectangle2D.Double(0,0, Variables.getPlayerwidth(), Variables.getPlayerheight()));
	}
	
	private AbstractCharacter getPlayer()
	{
		return parent.getGameLogic().getCharacter();
	}

}
