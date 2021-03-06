package gui;

import java.awt.Color;
import java.awt.Font;
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

import logic.Variables;

@SuppressWarnings("serial")
public class ScheduleButton extends JPanel
{

	private BufferedImage paper;
	private TexturePaint paperTex;
	
	private Rectangle2D rect;
	private String label;
	private boolean highLighted;
	int index;

	public ScheduleButton(String name, int _index)
	{
		index = _index;
		this.setVisible(true);
		rect = new Rectangle2D.Double();
		label = name;
		highLighted = false;
		loadImages();
	}

	private void loadImages()
	{
		try
		{
			paper = ImageIO.read(new File("ressources/textures/paper.jpg"));

		} catch (IOException ex)
		{

			System.out.println("file not found");
		}
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		paperTex = new TexturePaint(paper, new Rectangle(0, 0, (int)this.getBounds().getWidth(), (int)this.getBounds().getHeight()));
		g1.setPaint(paperTex);
		
		if(highLighted == true)
		{
			g1.setPaint(Color.green);
		}
		
		
		setRect();
		
		g1.draw(rect);
		g1.fillRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
		g1.setPaint(Color.white);
		g1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		if(index == 3 || index == 5)
		{
			g1.drawString(label + " - " +  Variables.getPlayerCharacter().getJob().name + " - " + Variables.getPlayerCharacter().getSchedule().getAction(index).name, (int) rect.getBounds2D().getX(),
					(int) rect.getBounds2D().getY() + 15);
		}
		else if (index == 6)
		{
			g1.drawString(label + " - " +  Variables.getPlayerCharacter().getSchedule().getAction(index).name + " - " + Variables.getPlayerCharacter().getSchedule().getPlace(index).name, (int) rect.getBounds2D().getX(),
					(int) rect.getBounds2D().getY() + 15);
		}
		else
		{
			g1.drawString(label + " - " +  Variables.getPlayerCharacter().getSchedule().getAction(index).name, (int) rect.getBounds2D().getX(),
					(int) rect.getBounds2D().getY() + 15);
		}
		
		
	}
	
	private void setRect()
	{
		rect.setFrame(this.getBounds().getX(), this.getBounds().getY(), this.getBounds().getWidth(), this.getBounds().getHeight());

	}
	
	public void setHighlight(boolean change)
	{
		highLighted = change;
	}

}