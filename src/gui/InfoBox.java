package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import logic.Variables;

import places.Place;
import schedule.PrisonAction;
import characters.AbstractCharacter;

@SuppressWarnings("serial")
public class InfoBox extends JPanel
{

	AbstractCharacter character;
	PrisonAction action;
	Place place;
	states state;
	
	BufferedImage brick;
	TexturePaint brickTex;
	
	BufferedImage metal;
	TexturePaint metalTex;

	public enum states
	{
		CHARACTER, ACTION, PLACE
	};

	public InfoBox()
	{
		try
		{
			brick = ImageIO.read(new File("ressources/textures/brick.jpg"));
			metal = ImageIO.read(new File("ressources/textures/metal2.jpg"));
		} catch (IOException e1)
		{
			System.out.println("brick not found");
		}
	}

	public void fillInfo(Place _place)
	{
		state = states.PLACE;
		place = _place;
		
	}

	public void fillInfo(AbstractCharacter _character)
	{
		state = states.CHARACTER;
		character = _character;
		
	}

	public void fillInfo(PrisonAction _action)
	{
		state = states.ACTION;
		action = _action;
		
	}

	public void paint(Graphics g)
	{

		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		
		brickTex = new TexturePaint(brick, new Rectangle2D.Double(0,0,500,500));
		g1.setPaint(brickTex);
		
		drawBackground(g1);

		if (state == states.ACTION)
		{
			paintAction(g1);
		} else if (state == states.PLACE)
		{
			paintPlace(g1);
		} else if (state == states.CHARACTER)
		{
			paintCharacter(g1);
		}

	}

	public void paintAction(Graphics2D g1)
	{
		
		g1.drawString(action.name, 10, (int)(30 * Variables.getResolutionmultiplier()));
		drawText(action.getInformation(),g1, 10, (int)(50 * Variables.getResolutionmultiplier()));
	}

	public void paintPlace(Graphics2D g1)
	{
		
		
		g1.drawString(place.name, 10, (int)(30 * Variables.getResolutionmultiplier()));
		drawText(place.getInformation(),g1, 10, (int)(40* Variables.getResolutionmultiplier()));
		int digAdvancement = 0;
		int guardAwareness = 0;
		for(Place digPlace: Variables.getPlayerCharacter().getSchedule().getAllPlaces())
		{
			if(digPlace.name.equals(place.name))
			{
				digAdvancement = digPlace.getDigAdvancement();
				guardAwareness = digPlace.getGuardAwareness();
			}
		}
		g1.drawString("dig advancement: " + digAdvancement , 10, (int)(130 * Variables.getResolutionmultiplier()));
		
		
		
		g1.drawString("guardAwareness: " + guardAwareness + "%", 10, (int)(160 * Variables.getResolutionmultiplier()));
	}

	public void paintCharacter(Graphics2D g1)
	{
		
		
		
		g1.drawImage(CharacterPieces.getBody(character.getCharacterLook().body), 20,20 , (int)(135 * Variables.getResolutionmultiplier()), (int)(135* Variables.getResolutionmultiplier()), null);
		g1.drawImage(CharacterPieces.getHead(character.getCharacterLook().head), 20,20, (int)(135* Variables.getResolutionmultiplier()), (int)(135* Variables.getResolutionmultiplier()), null);
		g1.drawImage(CharacterPieces.getFace(character.getCharacterLook().face), 20,20, (int)(135* Variables.getResolutionmultiplier()),(int)(135* Variables.getResolutionmultiplier()), null);
		g1.drawString(character.getName(), 250, 40);
		g1.drawString("strength: " + (int)character.getStrength(), 250, 80);
		g1.drawString("health: " + character.getHealth(), 250, 120);
		g1.drawString("intelligence: " + (int)character.getIntelligence(), 250, 160);
	}
	
	private void drawBackground(Graphics2D g1)
	{
		Rectangle2D rect = new Rectangle.Double(0, 0, (int)this.getBounds().getWidth(), (int)this.getBounds().getHeight());
		g1.fill(rect);
		Stroke stroke = new BasicStroke(20);
		Shape strokedOutline = stroke.createStrokedShape(rect);
		metalTex = new TexturePaint(metal, new Rectangle2D.Double(0,0,50,50));
		g1.setPaint(metalTex);	
		g1.fill(strokedOutline);
		
		g1.setPaint(Color.black);
		g1.setFont(new Font("Arial Black", Font.PLAIN, (int)(20 * Variables.getResolutionmultiplier())));
	}
	
	public void drawText(String text, Graphics2D g1, int x , int y)
	{
		for (String line : text.split("\n"))
            g1.drawString(line, x, y += g1.getFontMetrics().getHeight());
	}

}
