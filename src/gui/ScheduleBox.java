package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

import places.Place;

import schedule.Attack;
import schedule.Blackmail;
import schedule.Corrupt;
import schedule.Dig;
import schedule.Evasion;
import schedule.Learn;
import schedule.PrisonAction;
import schedule.ResolveLegal;
import schedule.Sell;
import schedule.Steal;
import schedule.StealWeaponTool;
import schedule.Train;
import schedule.WellBeing;


@SuppressWarnings("serial")
public class ScheduleBox extends JComponent
{
	UserInterface parent;
	
	Border border;

	final int buttonQte = 11;
	final int buttonSpacing = 20;
	int width;
	int height;
	int freeTime;
	int showDropMenu;
	
	
	
	String[] scheduleButtons;
	
		
	
	
	List<PrisonAction> possibleActions;
	List<Rectangle2D> actionButtonList;
	List<Rectangle2D> freePlaceList;
	List<Place> possiblePlaces;
	
	
	Rectangle2D button0to6;
	Rectangle2D button6to7;
	Rectangle2D button7to8;
	Rectangle2D button8to12;
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
		
		freeTime = 0;
		showDropMenu = 0;

		border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);
		
		button0to6 = new Rectangle2D.Double();
		button6to7 = new Rectangle2D.Double();
		button7to8 = new Rectangle2D.Double();
		button8to12 = new Rectangle2D.Double();
		button12to13 = new Rectangle2D.Double();
		button13to17 = new Rectangle2D.Double();
		button17to22 = new Rectangle2D.Double();
		button22to23 = new Rectangle2D.Double();
		button23to24 = new Rectangle2D.Double();
		
		scheduleButtons = new String[9];
		scheduleButtons[0] = "0000to0600";
		scheduleButtons[1] = "0600to0700";
		scheduleButtons[2] = "0700to0800";
		scheduleButtons[3] = "0800to1200"; 
		scheduleButtons[4] = "1200to1300"; 
		scheduleButtons[5] = "1300to1700"; 
		scheduleButtons[6] = "1700to2200"; 
		scheduleButtons[7] = "2200to2300"; 
		scheduleButtons[8] = "2300to2400";
		
		optionButton = new Rectangle2D.Double();
		pressedButton = button23to24;
		
		
		
		buttonList = new ArrayList<>();
		actionButtonList = new ArrayList<>();
		freePlaceList = new ArrayList<>();
		possiblePlaces = new ArrayList<>();
		
		buttonList.add(button0to6);
		buttonList.add(button6to7);
		buttonList.add(button7to8);
		buttonList.add(button8to12);
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
				freeTime = 0;
				int index = buttonList.indexOf(rect);
				if(index == 6)
				{
					freeTime = index;
				}
				
			}
		}
		
		for(Rectangle2D rect: actionButtonList)
		{
			if(rect.contains(me.getPoint()))
			{
				int index = actionButtonList.indexOf(rect);
				setCharacterAction(buttonList.indexOf(pressedButton), index);
				showDropMenu = index;
			}
		}
		
		for(Rectangle2D rect: freePlaceList)
		{
			System.out.println(freePlaceList.size());
			if(rect.contains(me.getPoint()))
			{
				int index = freePlaceList.indexOf(rect);
				parent.getGameLogic().getCharacter().setFreeChoice(possiblePlaces.get(index));
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
		int i = 0;
		for(Rectangle2D rect: buttonList)
		{
			g1.setPaint(Color.black);
			g1.draw(rect);
			g1.drawString(scheduleButtons[i], (int)rect.getBounds2D().getX(), (int)rect.getBounds2D().getY()+12);
			g1.setPaint(Color.red);
			g1.draw(optionButton);
			
			actionButtonList.clear();
			
			i++;

		}
		
		int spacing  = 1;
		for(PrisonAction action: possibleActions)
		{
			
			g1.drawString(action.name, 10, (int) optionButton.getBounds2D().getY() + buttonSpacing * spacing);
			Rectangle2D actionButton = new Rectangle2D.Double(0,optionButton.getBounds2D().getY() + buttonSpacing * (spacing-1), 100, buttonSpacing);
			actionButtonList.add(actionButton);
			g1.draw(actionButton);
			
			
			if(freeTime != 0 && showDropMenu == spacing - 1)
			{
				int spacing2 = 0;
				possiblePlaces.clear();
				freePlaceList.clear();
				for(Place place: getPossiblePlaces(action))
				{
					
					possiblePlaces.add(place);
					Rectangle2D newRect = new Rectangle2D.Double(100,optionButton.getBounds2D().getY() + buttonSpacing * (spacing-1) + spacing2 * buttonSpacing, 100, buttonSpacing);
					g1.draw(newRect);
					g1.drawString(place.name, 100,(int)optionButton.getBounds2D().getY() + buttonSpacing * (spacing) + spacing2 * buttonSpacing);
					freePlaceList.add(newRect);
					spacing2++;
				}
				
			}
			
			spacing++;
		}
     }
	
	private void setRectangles()
	{
		int index = 0;
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
	
	private List<Place> getPossiblePlaces(PrisonAction action)
	{
		List<Place> places = new ArrayList<>();
		
		
		if(action instanceof WellBeing)
		{
			places = WellBeing.getPlaces();
		}
		else if(action instanceof Learn)
		{
			places =  Learn.getPlaces();
		}
		else if(action instanceof Steal)
		{
			places =  Steal.getPlaces();
		}
		else if(action instanceof ResolveLegal)
		{
			places =  ResolveLegal.getPlaces();
		}
		else if(action instanceof Train)
		{
			places = Train.getPlaces();
		}
		else if(action instanceof Sell)
		{
			places = Sell.getPlaces();
		}
		else if(action instanceof StealWeaponTool)
		{
			places = StealWeaponTool.getPlaces();
		}
		else if(action instanceof Blackmail)
		{
			places = Blackmail.getPlaces();
		}
		else if(action instanceof Corrupt)
		{
			places = Corrupt.getPlaces();
		}
		else if(action instanceof Dig)
		{
			places = Dig.getPlaces();
		}
		else
		{
			places = Evasion.getPlaces();
		}
		
		return places;
	}

	
	private void setCharacterAction(int scheduleIndex, int actionIndex)
	{
		parent.getGameLogic().getCharacter().getSchedule().setAction(scheduleIndex, possibleActions.get(actionIndex));
	}

	
	public void set()
	{
		width = this.getWidth();
		height = this.getHeight();
		this.repaint();
	}




}
