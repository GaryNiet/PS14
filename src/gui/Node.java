package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Node extends JPanel
{
	List<Node> nodeList;
	int posX;
	int posY;
	
	public Node(int x, int y)
	{
		posX = x;
		posY = y;
		nodeList = new ArrayList<>();
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
}
