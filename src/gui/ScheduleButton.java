package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ScheduleButton extends JPanel
{
	double x, y, width, height;
	Rectangle2D testRect;

	private BufferedImage paper;
	private TexturePaint paperTex;
	
	private Rectangle2D rect;
	private String label;

	public ScheduleButton()
	{
		loadImages();
	}

	private void loadImages()
	{
		try
		{

			paper = ImageIO.read(new File("paper.jpg"));

		} catch (IOException ex)
		{

			System.out.println("file not found");
		}
	}
	
	public void paint(Graphics g)
	{
		
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		paperTex = new TexturePaint(paper, new Rectangle(0, 0, (int)this.width, (int)this.height));
		
		g1.setPaint(paperTex);
		g1.draw(rect);
		g1.fillRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
		g1.setPaint(Color.black);
		g1.drawString(label, (int) rect.getBounds2D().getX(),
				(int) rect.getBounds2D().getY() + 12);
	}

}
