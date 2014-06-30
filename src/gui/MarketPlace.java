package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logic.Variables;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class MarketPlace extends JPanel
{
	boolean isShown;
	UserInterface parent;
	JSlider slider;
	String amount;
	JLabel text;
	int sellingAmount;
	Rectangle2D background;
	
	BufferedImage backgroundImage;
	TexturePaint backgroundTex;
	
	
	public MarketPlace(UserInterface _parent)
	{
		this.setLayout(new MigLayout());
		isShown = false;
		parent = _parent;
		
		amount = "sell 0";
		
	
		slider = new JSlider(JSlider.HORIZONTAL, -100, 100, 0);
		slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        
        slider.addChangeListener(new ChangeListener()
		{
			
			@Override
			public void stateChanged(ChangeEvent e)
			{
				update();
				
			}
		});
        
        slider.setFocusable(false);
        
        this.add(slider, "w 100%, h 100%");
        
        try
		{
			backgroundImage = ImageIO.read(new File("marketPlace.png"));
		} catch (IOException e1)
		{
			System.out.println("marketplace not found");
		}

       
		
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		
		backgroundTex = new TexturePaint(backgroundImage, new Rectangle2D.Double(0,0,200,200));
		
		background = new Rectangle2D.Double(0,0,this.getBounds().getWidth(), this.getBounds().getHeight());
		
		Stroke stroke = new BasicStroke(10);
		Shape strokedOutline = stroke.createStrokedShape(background);
		
		g1.setPaint(backgroundTex);
		
		g1.fill(background);
		g1.setPaint(Color.white);
		g1.fill(strokedOutline);
		slider.paint(g1);
		
		g1.setPaint(Color.white);
		Font font = new Font("Arial Black", Font.PLAIN, 25);
		g1.setFont(font);
		g1.drawString(amount, 60, 30);
		
		
		
		
	}
	
	public void update()
	{
		if(slider.getValue() >= 0)
		{
			amount = "sell " + slider.getValue() + " materials for " + String.format("%.2g%n", slider.getValue() * 0.025 * Variables.getPlayerCharacter().getIntelligence()) + "$";
			
		}
		else
		{
			amount = "buy " + Math.abs(slider.getValue()) + " materials for " + String.format("%.2g%n", Math.abs(slider.getValue() * 0.025 * Variables.getPlayerCharacter().getIntelligence())) + "$";
		}
		
		sellingAmount = slider.getValue();
	}
	
	public void updateSlider()
	{
		slider.setValue(sellingAmount);
	}

	public int getSellingAmount()
	{
		return sellingAmount;
	}

	public void setSellingAmount(int sellingAmount)
	{
		this.sellingAmount = sellingAmount;
	}

	public JSlider getSlider()
	{
		return slider;
	}
	
	public void come()
	{
		
	}
	
	public void go()
	{
		
	}
	
	
	

}
