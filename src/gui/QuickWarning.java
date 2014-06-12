package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class QuickWarning extends JPanel
{
	int opacity;
	
	public QuickWarning()
	{
		opacity = 0;
	}
	
	public void appear()
	{
		
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		
		
		if(opacity > 0)
		{
			opacity -= 5;
		}
		int bufferOpacity = opacity;
		if(opacity >= 255)
		{
			bufferOpacity = 255;
		}
		
		g1.setPaint(new Color(255, 0, 0, bufferOpacity));
		g1.drawString("cannot modify current action", (int)this.getBounds().getX(), (int)this.getBounds().getY() + 50);
	}

}
