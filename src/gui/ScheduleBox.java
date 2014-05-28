package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

import places.Place;
import schedule.PrisonAction;

@SuppressWarnings("serial")
public class ScheduleBox extends JComponent
{
	UserInterface parent;

	Border border;

	final int buttonQte = 16;
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

	ScheduleButton button0to6;
	ScheduleButton button6to7;
	ScheduleButton button7to8;
	ScheduleButton button8to12;
	ScheduleButton button12to13;
	ScheduleButton button13to17;
	ScheduleButton button17to22;
	ScheduleButton button22to23;
	ScheduleButton button23to24;

	Rectangle2D optionButton;

	ScheduleButton pressedButton;

	List<ScheduleButton> buttonList;


	public ScheduleBox(UserInterface _parent)
	{
		parent = _parent;

		freeTime = 0;
		showDropMenu = 0;


		border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);

		button0to6 = new ScheduleButton("invisible");
		button6to7 = new ScheduleButton("qewf");
		button7to8 = new ScheduleButton("qwef");
		button8to12 = new ScheduleButton("verbqeb");
		button12to13 = new ScheduleButton("qerbq");
		button13to17 = new ScheduleButton("bqerbrn");
		button17to22 = new ScheduleButton("brnr");
		button22to23 = new ScheduleButton("rsner");
		button23to24 = new ScheduleButton("netzdj");


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
				freeTime = 0;
				int index = buttonList.indexOf(rect);
				if (index == 6)
				{
					freeTime = index;
				}

			}
		}

		for (Rectangle2D rect : actionButtonList)
		{
			if (rect.contains(me.getPoint()))
			{
				int index = actionButtonList.indexOf(rect);
				setCharacterAction(buttonList.indexOf(pressedButton), index);
				showDropMenu = index;
			}
		}

		for (Rectangle2D rect : freePlaceList)
		{
			//System.out.println(freePlaceList.size());
			if (rect.contains(me.getPoint()))
			{
				int index = freePlaceList.indexOf(rect);
				parent.getGameLogic().getCharacter()
						.setFreeChoice(possiblePlaces.get(index));
			}
		}

		setRectangles();

	}

	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		setRectangles();
		
		
		
		
		getPossibleActions();
		for (ScheduleButton rect : buttonList)
		{
			rect.paint(g);
			
			g1.setPaint(Color.red);
			

			actionButtonList.clear();

		}

		int spacing = 1;
		for (PrisonAction action : possibleActions)
		{

			g1.drawString(action.name, 10, (int) optionButton.getBounds2D()
					.getY() + buttonSpacing * spacing);
			Rectangle2D actionButton = new Rectangle2D.Double(0, optionButton
					.getBounds2D().getY() + buttonSpacing * (spacing - 1), 100,
					buttonSpacing);
			actionButtonList.add(actionButton);
			g1.draw(actionButton);

			if (freeTime != 0 && showDropMenu == spacing - 1)
			{
				int spacing2 = 0;
				possiblePlaces.clear();
				freePlaceList.clear();
				for (Place place : getPossiblePlaces(action))
				{

					possiblePlaces.add(place);
					Rectangle2D newRect = new Rectangle2D.Double(100,
							optionButton.getBounds2D().getY() + buttonSpacing
									* (spacing - 1) + spacing2 * buttonSpacing,
							100, buttonSpacing);
					g1.draw(newRect);
					g1.drawString(place.name, 100, (int) optionButton
							.getBounds2D().getY()
							+ buttonSpacing
							* (spacing)
							+ spacing2 * buttonSpacing);
					freePlaceList.add(newRect);
					spacing2++;
				}

			}

			spacing++;
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
				optionButton.setFrame(0, index * this.height / (buttonQte),
						this.width, (this.height / (buttonQte)) * 4);

				index += 6;

			} else
			{
				rect.setBounds(0, index * this.height / (buttonQte),
						this.width, this.height / (buttonQte));
				index++;
			}
		}
		this.repaint();
	}

	private void getPossibleActions()
	{
		possibleActions = parent.getGameLogic().getCharacter().getSchedule()
				.getPlace(buttonList.indexOf(pressedButton))
				.getPossibleActions();
	}

	private List<Place> getPossiblePlaces(PrisonAction action)
	{
		return action.getAllPlaces();
	}

	private void setCharacterAction(int scheduleIndex, int actionIndex)
	{
		parent.getGameLogic().getCharacter().getSchedule()
				.setAction(scheduleIndex, possibleActions.get(actionIndex));
	}

	public void set()
	{
		width = this.getWidth();
		height = this.getHeight();
		this.repaint();
	}

}
