package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import places.Place;

@SuppressWarnings("serial")
public class InfoBox extends JPanel {
	Border border;
	JPanel panel;
	String name;
	
	
	public InfoBox()
	{
		border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);
		name = new String();
		
	}
	
	public void fillInfo(Place place)
	{
		
		name = place.name;
		this.repaint();
	}
	
	public void paint(Graphics g)
	{
		
		Graphics2D g1 = (Graphics2D)g;
		super.paintComponent(g1);
		g1.drawString(name, 10, 10);
		
	}
	
	

}
