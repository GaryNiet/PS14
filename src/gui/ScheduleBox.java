package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

import logic.Variables;

@SuppressWarnings("serial")
public class ScheduleBox extends JComponent
{
	UserInterface parent;

	Border border;

	final int buttonQte = 16;
	final int buttonSpacing = 20;
	int width;
	int height;

	

	QuickWarning quickWarning;
	int qwIndex;

	ScheduleButton button0to6;
	ScheduleButton button6to7;
	ScheduleButton button7to8;
	ScheduleButton button8to12;
	ScheduleButton button12to13;
	ScheduleButton button13to17;
	ScheduleButton button17to22;
	ScheduleButton button22to23;
	ScheduleButton button23to24;

	OptionButton optionButton;

	ScheduleButton pressedButton;

	List<ScheduleButton> buttonList;


	public ScheduleBox(UserInterface _parent)
	{
		parent = _parent;

		quickWarning = new QuickWarning();

		border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);

		button0to6 = new ScheduleButton("Cell");
		button6to7 = new ScheduleButton("Showers");
		button7to8 = new ScheduleButton("Cafeteria");
		button8to12 = new ScheduleButton("Job");
		button12to13 = new ScheduleButton("Cafeteria");
		button13to17 = new ScheduleButton("Job");
		button17to22 = new ScheduleButton("Free");
		button22to23 = new ScheduleButton("Showers");
		button23to24 = new ScheduleButton("Cell");


		optionButton = new OptionButton(this);
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



	}

	void mouseClickReaction(MouseEvent me)
	{
		//System.out.println(me.getPoint().getX());
		me.translatePoint(-this.getBounds().x, -this.getBounds().y -25);
		for (ScheduleButton rect : buttonList)
		{
			if (rect.getBounds().contains(me.getPoint()))
			{
				if(buttonList.indexOf(rect) == Variables.getGameLogic().getTime() || buttonList.indexOf(rect) == Variables.getGameLogic().getTime()-1)
				{
					parent.setInfo(true);
					qwIndex = buttonList.indexOf(rect);
					quickWarning.opacity = 500;
					
				}
				else
				{
					pressedButton = rect;
					optionButton.setIndex(buttonList.indexOf(rect));
				}
					
				
			}
		}
		
		optionButton.mouseClickReaction(me);

		setRectangles();

	}

	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		setRectangles();
		
		optionButton.paint(g);
		
		int index = 1;
		for (ScheduleButton rect : buttonList)
		{	
			rect.paint(g);
			if(qwIndex == index -1)
			{
				quickWarning.setBounds(0, index * this.height / (buttonQte), this.width, this.height / (buttonQte));
				quickWarning.paint(g);
			}
			index++;
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
				optionButton.setBounds(0, index * this.height / (buttonQte),
						this.width, (this.height / (buttonQte)) * 4);

				index += 6;

			} else
			{
				rect.setBounds(0, index * this.height / (buttonQte),
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
		for(ScheduleButton button : buttonList)
		{
			button.setHighlight(false);
		}
		buttonList.get(currentTime).setHighlight(true);
	}

	public void mouseOverReaction(MouseEvent e)
	{
		optionButton.mouseOverReaction(e);
		
	}

}