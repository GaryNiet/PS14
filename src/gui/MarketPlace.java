package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

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
		
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		
		slider.paint(g1);
		g1.drawString(amount, 80, 20);
		
		
		
		
	}
	
	public void update()
	{
		if(slider.getValue() >= 0)
		{
			amount = "sell " + slider.getValue() + " materials for " + slider.getValue() * 0.025 * Variables.getPlayerCharacter().getIntelligence() + "$";
			
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
	
	
	

}
