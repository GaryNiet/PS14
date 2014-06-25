package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import logic.Variables;

@SuppressWarnings("serial")
public class WarningWindow extends JPanel
{
	UserInterface parent;
	Rectangle2D okButton;
	String text;
	

	private BufferedImage toiletPaper;
	private TexturePaint toiletPaperTex;
	boolean end;
	
	public WarningWindow(UserInterface _parent)
	{
		parent = _parent;
		okButton = new Rectangle2D.Double();
		text = "";
		end = false;
		

		try
		{
			toiletPaper = ImageIO.read(new File("toiletPaper.jpg"));
		} catch (IOException e)
		{
			System.out.println("file not found");
		}
		
		
		
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		
		setButtonSpace();
		
		toiletPaperTex = new TexturePaint(toiletPaper, new Rectangle2D.Double(0,0,400,400));
		
		g1.setPaint(toiletPaperTex);
		g1.fill(new Rectangle.Double(0,0, 1000,1000));
		g1.setPaint(Color.black);
		g1.fill(okButton);
		g1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g1.setPaint(Color.white);
		g1.drawString("ok", (int)okButton.getBounds().getX() + 20, (int)okButton.getBounds().getY() + 20);
		g1.setPaint(Color.black);
		g1.drawString(text, 10, 10);
		
		
		
	}
	
	private void setButtonSpace()
	{
		okButton.setFrame(this.getWidth()*6/8, this.getHeight()*6/8, this.getWidth()/8, this.getHeight()/8);
	}
	
	public void setImage(String string, boolean endGame)
	{
		text = string;
		parent.setInfo(true);
		

		end = endGame;
		
	}

	public void mouseClickReaction(MouseEvent me)
	{
		me.translatePoint(-this.getBounds().x, -this.getBounds().y);
		if(okButton.getBounds().contains(me.getPoint()))
		{
			parent.setInfo(false);
			if(end == true)
			{
				System.exit(0);
			}
		}
		
	}
}
