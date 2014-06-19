package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class MarketPlace extends JPanel
{
	boolean isShown;
	UserInterface parent;
	JSlider slider;
	String amount;
	JLabel text;
	
	
	public MarketPlace(UserInterface _parent)
	{
		this.setLayout(new MigLayout());
		isShown = false;
		parent = _parent;
		amount = "sell 0";
		
		text = new JLabel("sell 0");
		
	
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
		
		this.add(slider);
		this.add(text);
		this.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		
		slider.paint(g1);
		text.paint(g1);
		
		
	}
	
	private void update()
	{
		text.setText("sell: " + String.valueOf(slider.getValue()));
	}
}
