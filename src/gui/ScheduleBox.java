package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ScheduleBox extends JComponent
{
	UserInterface parent;

	Border border;

	final int buttonQte = 16;
	final int buttonSpacing = 20;
	int width;
	int height;
	int offset;

	

	

	ScheduleButton button0to6;
	ScheduleButton button6to7;
	ScheduleButton button7to8;
	ScheduleButton button8to12;
	ScheduleButton button12to13;
	ScheduleButton button13to17;
	ScheduleButton button17to22;
	ScheduleButton button22to23;
	ScheduleButton button23to24;


	ScheduleButton pressedButton;

	List<ScheduleButton> buttonList;


	public ScheduleBox(UserInterface _parent)
	{
		offset = -1;
		parent = _parent;



		border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);

		button0to6 = new ScheduleButton("Cell", 1);
		button6to7 = new ScheduleButton("Showers", 2);
		button7to8 = new ScheduleButton("Cafeteria", 3);
		button8to12 = new ScheduleButton("Job", 4);
		button12to13 = new ScheduleButton("Cafeteria", 5);
		button13to17 = new ScheduleButton("Job", 6);
		button17to22 = new ScheduleButton("Free", 7);
		button22to23 = new ScheduleButton("Showers", 8);
		button23to24 = new ScheduleButton("Cell", 9);


		pressedButton = button23to24;

		buttonList = new ArrayList<>();

		buttonList.add(button0to6);
		buttonList.add(button6to7);
		buttonList.add(button7to8);
		buttonList.add(button8to12);
		buttonList.add(button12to13);
		buttonList.add(button13to17);
		buttonList.add(button17to22);
		buttonList.add(button22to23);
		buttonList.add(button23to24);

		this.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				mouseClickReaction(me);
			}
		});

	}

	void mouseClickReaction(MouseEvent me)
	{
		for (ScheduleButton rect : buttonList)
		{
			if (rect.getBounds().contains(me.getPoint()))
			{
				pressedButton = rect;
				for (ScheduleButton rect2 : buttonList)
				{
					rect2.setDrawOptions(false);
				}
				rect.setDrawOptions(true);
				
			}
			pressedButton.mouseClickReaction(me);
		}
		
		

		setRectangles();

	}

	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		setRectangles();
		

		
		for (ScheduleButton rect : buttonList)
		{
			rect.paint(g);

		}
		
	}

	private void setRectangles()
	{
		int index = 1;
		for (ScheduleButton rect : buttonList)
		{ 
			if (rect == pressedButton)
			{
				
				
				
				rect.setBounds(0, index * this.height / (buttonQte),
						this.width, this.height / (buttonQte));
				index++;
				


				
				index += 6;
					
				

			} else
			{
				
				
				rect.setBounds(0, (index) * this.height / (buttonQte),
						this.width, this.height / (buttonQte));
				index++;
			}
		}
		
	}




	public void set()
	{
		width = this.getWidth();
		height = this.getHeight();
		
	}
	
	public void pulse(int currentTime)
	{
		offset++;
		offset = offset%9;
		for(ScheduleButton button : buttonList)
		{
			button.setHighlight(false);
		}
		buttonList.get(currentTime).setHighlight(true);
		
	}

}
