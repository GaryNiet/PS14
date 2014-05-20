package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class OptionButton extends JPanel
{
	
	Rectangle2D testRect;
	
	public OptionButton()
	{
		testRect = new Rectangle2D.Double(10,10,30,30);
	}
	
	@Override
    public void paintComponent(Graphics g){
      g.drawString("This is Panel 1",20,20);
      g.drawRect(0,200,100,200);

    }

	
	
}
