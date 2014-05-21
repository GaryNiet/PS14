package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

import schedule.PrisonAction;


@SuppressWarnings("serial")
public class ScheduleBox extends JComponent
{
	UserInterface parent;
	
	Border border;

	final int buttonQte = 11;
	final int buttonSpacing = 12;
	int width;
	int height;
	
	List<PrisonAction> possibleActions;
	List<Rectangle2D> actionButtonList;
	
	
	Rectangle2D button0to6;
	Rectangle2D button6to7;
	Rectangle2D button7to8;
	Rectangle2D button9to12;
	Rectangle2D button12to13;
	Rectangle2D button13to17;
	Rectangle2D button17to22;
	Rectangle2D button22to23;
	Rectangle2D button23to24;
	
	Rectangle2D optionButton;
	
	Rectangle2D pressedButton;
	
	List<Rectangle2D> buttonList;

	public ScheduleBox(UserInterface _parent)
	{
		parent = _parent;

		border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);
		
		button0to6 = new Rectangle2D.Double();
		button6to7 = new Rectangle2D.Double();
		button7to8 = new Rectangle2D.Double();
		button9to12 = new Rectangle2D.Double();
		button12to13 = new Rectangle2D.Double();
		button13to17 = new Rectangle2D.Double();
		button17to22 = new Rectangle2D.Double();
		button22to23 = new Rectangle2D.Double();
		button23to24 = new Rectangle2D.Double();
		
		optionButton = new Rectangle2D.Double();
		pressedButton = button23to24;
		
		
		
		buttonList = new ArrayList<>();
		actionButtonList = new ArrayList<>();
		
		
		buttonList.add(button0to6);
		buttonList.add(button6to7);
		buttonList.add(button7to8);
		buttonList.add(button9to12);
		buttonList.add(button12to13);
		buttonList.add(button13to17);
		buttonList.add(button17to22);
		buttonList.add(button22to23);
		buttonList.add(button23to24);
		
		this.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me)
	          { 
	            mouseClickReaction(me);
	          } 
	        }); 
		
		
	}
	
	void mouseClickReaction(MouseEvent me)
	{
		for(Rectangle2D rect: buttonList)
		{
			if(rect.contains(me.getPoint()))
			{
				pressedButton = rect;
			}
		}
		
		for(Rectangle2D rect: actionButtonList)
		{
			if(rect.contains(me.getPoint()))
			{
				int index = actionButtonList.indexOf(rect);
				System.out.println(possibleActions.get(index));
			}
		}
		
		setRectangles();
		
		
		
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D)g;
		super.paintComponent(g1);
		setRectangles();
		getPossibleActions();
		for(Rectangle2D rect: buttonList)
		{
			g1.setPaint(Color.black);
			g1.draw(rect);
			g1.setPaint(Color.red);
			g1.draw(optionButton);
			int spacing  = 1;
			actionButtonList.clear();
			for(PrisonAction action: possibleActions)
			{

				g1.drawString(action.name, 10, (int) optionButton.getBounds2D().getY() + buttonSpacing * spacing);
				Rectangle2D actionButton = new Rectangle2D.Double(0,optionButton.getBounds2D().getY() + buttonSpacing * (spacing-1), 100, buttonSpacing);
				actionButtonList.add(actionButton);
				g1.draw(actionButton);
				spacing++;
			}
			
		}
     }
	
	private void setRectangles()
	{
		int index = 0;
		buttonList.remove(optionButton);
		for(Rectangle2D rect: buttonList)
		{
			if(rect == pressedButton)
			{
				rect.setFrame(0, index *this.height/(buttonQte+2), this.width, this.height/(buttonQte+2));
				index++;
				optionButton.setFrame(0, index *this.height/(buttonQte+2), this.width, (this.height/(buttonQte+2))*4);
				
				index += 4;
				
			}
			else
			{
				rect.setFrame(0, index *this.height/(buttonQte+2), this.width, this.height/(buttonQte+2));
				index++;
			}
		}
		this.repaint();
	}
	
	private void getPossibleActions()
	{
		possibleActions = parent.getGameLogic().getCharacter().getSchedule().getPlace(buttonList.indexOf(pressedButton)).getPossibleActions();
	}

	
	public void set()
	{
		width = this.getWidth();
		height = this.getHeight();
		this.repaint();
	}




}
