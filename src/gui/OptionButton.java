package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import logic.Variables;
import places.Place;
import schedule.PrisonAction;

@SuppressWarnings("serial")
public class OptionButton extends JPanel
{
	
	final int buttonQte = 16;
	final int buttonSpacing = 20;
	
	Rectangle2D button;
	boolean showsCharacters;

	List<Rectangle2D> actionButtonList;
	List<Rectangle2D> freePlaceList;
	List<Place> possiblePlaces;
	List<PrisonAction> possibleActions;

	int index;
	int showDropMenu;

	OptionButton()
	{
		button = new Rectangle2D.Double();

		actionButtonList = new ArrayList<>();
		freePlaceList = new ArrayList<>();
		possiblePlaces = new ArrayList<>();
		possibleActions = new ArrayList<>();


		this.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				mouseClickReaction(me);
			}
		});
	}

	protected void mouseClickReaction(MouseEvent me)
	{
		for (Rectangle2D rect : actionButtonList)
		{
			if (rect.contains(me.getPoint()))
			{

				int actionIndex = actionButtonList.indexOf(rect);
				setCharacterAction(index, actionIndex);
				showDropMenu = actionIndex;
			}
		}

		for (Rectangle2D rect : freePlaceList)
		{
			// System.out.println(freePlaceList.size());
			if (rect.contains(me.getPoint()))
			{
				int placeIndex = freePlaceList.indexOf(rect);
				Variables.getGameLogic().getCharacter().setFreeChoice(possiblePlaces.get(placeIndex));
			}
		}

	}

	public void paint(Graphics g)
	{
		
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		setRect();
		
		int spacing = 1;
		actionButtonList.clear();
		getPossibleActions();
		for (PrisonAction action : possibleActions)
		{
			g1.drawString(action.name, 10, (int) button.getBounds2D()
					.getY() + buttonSpacing * spacing);
			Rectangle2D actionButton = new Rectangle2D.Double(0, button
					.getBounds2D().getY() + buttonSpacing * (spacing - 1), 100,
					buttonSpacing);
			actionButtonList.add(actionButton);
			g1.draw(actionButton);

			if (index == 6 && showDropMenu == spacing - 1)
			{
				int spacing2 = 0;
				possiblePlaces.clear();
				freePlaceList.clear();
				for (Place place : getPossiblePlaces(action))
				{

					possiblePlaces.add(place);
					Rectangle2D newRect = new Rectangle2D.Double(100,
							button.getBounds2D().getY() + buttonSpacing
									* (spacing - 1) + spacing2 * buttonSpacing,
							100, buttonSpacing);
					g1.draw(newRect);
					g1.drawString(place.name, 100, (int) button
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

	private void setCharacterAction(int scheduleIndex, int actionIndex)
	{
		System.out.println("si: " + scheduleIndex + " ai: " + actionIndex);
		Variables.getGameLogic().getCharacter().getSchedule()
				.setAction(scheduleIndex, possibleActions.get(actionIndex));
	}

	private void getPossibleActions()
	{
		possibleActions = Variables.getGameLogic().getCharacter().getSchedule()
				.getPlace(index).getPossibleActions();
	}
	
	private List<Place> getPossiblePlaces(PrisonAction action)
	{
		return action.getAllPlaces();
	}
	
	private void setRect()
	{
		button.setFrame(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
	public void setIndex(int _index)
	{
		index = _index;
	}

}
