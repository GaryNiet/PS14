package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import places.Place;

@SuppressWarnings("serial")
public class Node extends JPanel
{
	List<Node> nodeList;
	int posX;
	int posY;
	Place place;
	
	
	public Node()
	{
		
	}
	
	public Node(int x, int y,Place _place)
	{
		posX = x;
		posY = y;
		nodeList = new ArrayList<>();

		place = _place;
	}
	
	public void addNode(Node node)
	{
		nodeList.add(node);
	}
	
	public void paint(Graphics g)
	{
		
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		
		
		g1.fill(new Rectangle2D.Double(posX,posY, 10,10));
	}
	
	public List<Node> getNodes()
	{
		return nodeList;
	}
	
	public Place getPlace()
	{
		return place;
	}

	public int getPosX()
	{
		return posX;
	}

	public int getPosY()
	{
		return posY;
	}
}
