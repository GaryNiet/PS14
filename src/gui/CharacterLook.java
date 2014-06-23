package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CharacterLook extends JPanel
{
	
	CharacterPieces characterPieces;
	
	
	public CharacterLook(CharacterPieces _characterPieces)
	{
		Random random = new Random();
		characterPieces = _characterPieces;
		
	}
	

	
	public synchronized void paint(Graphics g, Rectangle2D frame)
	{
		Graphics2D g1 = (Graphics2D)g;
		super.paintComponent(g1);
		
		g1.drawImage(CharacterPieces.getBody("MEDIUM"), (int)frame.getX(), (int)frame.getY(), (int)frame.getWidth(), (int)frame.getHeight(), null);
		
	}




	
	
}
