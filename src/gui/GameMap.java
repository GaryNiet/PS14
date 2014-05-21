package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import logic.Variables;

import places.Place;

@SuppressWarnings("serial")
public class GameMap extends JPanel{
	
	Border border;
	UserInterface parent;
	InfoBox infoBox;
	
	List<Rectangle2D> placeList;
	Rectangle2D player;
	
	
	
	
	
	public GameMap(UserInterface _parent)
	{
		parent = _parent;
		infoBox = parent.getInfoBox();
		
		placeList = new ArrayList<>();
		
		border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);
		
		player = new Rectangle2D.Double(10, 10, Variables.getPlayerwidth(), Variables.getPlayerheight());

		for(Place place: allPlaces())
		{
			Rectangle2D newPlace = new Rectangle2D.Double(place.getPosX(), place.getPosY(), place.getSizeX(), place.getSizeY());
			placeList.add(newPlace);
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
		
		//draws player
		g1.draw(player);
		this.repaint();
		
	}
	
	public void placePlayer()
	{
		System.out.println(getCurrentPlace());
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

}
