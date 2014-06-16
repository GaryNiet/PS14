package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

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

	public enum states
	{
		CHARACTER, ACTION, PLACE
	};

	public InfoBox()
	{
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
		g1.drawString(action.name, 10, 10);
		g1.drawString(action.getInformation(), 10, 30);
	}

	public void paintPlace(Graphics2D g1)
	{
		g1.drawString(place.name, 10, 10);
		g1.drawString(place.getInformation(), 10, 30);
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
		g1.drawString("dig advancement: " + digAdvancement , 10, 50);
		
		
		
		g1.drawString("guardAwareness: " + guardAwareness + "%", 10, 70);
	}

	public void paintCharacter(Graphics2D g1)
	{
		g1.drawString(character.getName(), 10, 30);
		g1.drawString("strength: " + character.getStrength(), 10, 50);
		g1.drawString("health: " + character.getHealth(), 10, 70);
		g1.drawString("intelligence: " + character.getIntelligence(), 10, 90);
	}

}
