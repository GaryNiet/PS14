package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import characters.AICharacter;

import logic.Variables;

import places.Place;

@SuppressWarnings("serial")
public class GameMap extends JPanel{
	
	Border border;
	UserInterface parent;
	InfoBox infoBox;
	
	List<Rectangle2D> placeList;
	Rectangle2D player;
	List<Rectangle2D> aiRectangles;
	Random random;
	
	
	
	
	
	public GameMap(UserInterface _parent)
	{
		parent = _parent;
		infoBox = parent.getInfoBox();
		
		random = new Random();
		
		placeList = new ArrayList<>();
		aiRectangles = new ArrayList<>();
		
		
		border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);
		
		player = new Rectangle2D.Double(10, 10, Variables.getPlayerwidth(), Variables.getPlayerheight());
		
		
		for(Place place: allPlaces())
		{
			Rectangle2D newPlace = new Rectangle2D.Double(place.getPosX(), place.getPosY(), place.getSizeX(), place.getSizeY());
			placeList.add(newPlace);
		}
		
		for(int i = 0; i< Variables.getCharacterList().size(); i++)
		{
			aiRectangles.add(new Rectangle2D.Double(0,0,10,10));
		}
		
		this.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me)
	          { 
	            mouseClickReaction(me);
	          } 
	        }); 
		
	}
	
	private void mouseClickReaction(MouseEvent me)
	{
		if(player.contains(me.getPoint()))
		{
			//infoBox.fillInfo(Character character);
		}
		else
		{
			for(Rectangle2D place: placeList)
			{
				if(place.contains(me.getPoint()))
				{
					int placeIndex = placeList.indexOf(place);
					infoBox.fillInfo(allPlaces().get(placeIndex));
				}
				
			}
		}
	}
	
	public void paint(Graphics g)
	{
		placePlayer();
		
		Graphics2D g1 = (Graphics2D)g;
		super.paintComponent(g1);
		//draws places
		for(Rectangle2D place: placeList)
		{
			g1.draw(place);
		}
		
		int index = 0;
		for(AICharacter ai: Variables.getCharacterList())
		{
			ai.updateRoam();
			aiRectangles.get(index).setFrame(ai.getPosX() + ai.getAnimation().getRoamX(), ai.getPosY() + ai.getAnimation().getRoamY(), Variables.getPlayerwidth(), Variables.getPlayerheight());
			g1.draw(aiRectangles.get(index));
			index++;
		}
		
		
		
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
