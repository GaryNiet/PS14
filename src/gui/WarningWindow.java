package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WarningWindow extends JPanel
{
	UserInterface parent;
	Rectangle2D okButton;
	
	public WarningWindow(UserInterface _parent)
	{
		parent = _parent;
		okButton = new Rectangle2D.Double();
		
		
		
		
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		
		setButtonSpace();
		
		g1.setPaint(Color.blue);
		g1.fill(new Rectangle.Double(0,0, 500,500));
		g1.setPaint(Color.black);
		g1.fill(okButton);
		
	}
	
	private void setButtonSpace()
	{
		okButton.setFrame(this.getWidth()*6/8, this.getHeight()*6/8, this.getWidth()/8, this.getHeight()/8);
	}

	public void mouseClickReaction(MouseEvent me)
	{
		
		
		me.translatePoint(-this.getBounds().x, -this.getBounds().y - 25);
		
		if(okButton.getBounds().contains(me.getPoint()))
		{
			parent.setInfo(false);
		}
		
	}
}
