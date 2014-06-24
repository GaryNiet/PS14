package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CharacterLook extends JPanel
{
	int face;
	int head;
	int body;
	
	CharacterPieces characterPieces;
	
	
	public CharacterLook(CharacterPieces _characterPieces)
	{
		Random random = new Random();
		
		characterPieces = _characterPieces;
		face = random.nextInt(CharacterPieces.getFaceList().size());
		head = random.nextInt(CharacterPieces.getHeadList().size());
		body = random.nextInt(CharacterPieces.getBodyList().size());
	}
	

	
	public synchronized void paint(Graphics g, Rectangle2D frame)
	{
		Graphics2D g1 = (Graphics2D)g;
		super.paintComponent(g1);
		
		g1.drawImage(CharacterPieces.getBody(body), (int)frame.getX() - (int)(frame.getWidth()/1.4), (int)frame.getY() , (int)(frame.getWidth() * 2.5), (int)frame.getHeight(), null);
		g1.drawImage(CharacterPieces.getHead(head), (int)frame.getX(), (int)frame.getY(), (int)frame.getWidth(), (int)frame.getWidth(), null);
		g1.drawImage(CharacterPieces.getFace(face), (int)frame.getX(), (int)frame.getY(), (int)frame.getWidth(), (int)frame.getWidth(), null);
		
	}




	
	
}
