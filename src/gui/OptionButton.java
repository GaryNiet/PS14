package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import characters.AICharacter;

import logic.Variables;
import places.Job;
import places.Place;
import schedule.PrisonAction;

@SuppressWarnings("serial")
public class OptionButton extends JPanel
{
	ScheduleBox parent;

	final int buttonQte = 16;
	final int buttonSpacing = 23;

	Rectangle2D button;
	boolean showsCharacters;
	boolean showsChangeJobMenu;
	boolean eraseFlag;

	int shift;

	List<Rectangle2D> actionButtonList;
	List<Rectangle2D> freePlaceList;
	List<Place> possiblePlaces;
	List<PrisonAction> possibleActions;
	List<AICharacter> aiCharacters;
	List<Rectangle2D> aiCharactersG;
	List<Rectangle2D> jobButtonsG;

	// would be cleaner with enumeration
	int index;
	int showDropMenu;

	OptionButton(ScheduleBox _parent)
	{
		shift = 0;
		parent = _parent;
		showsCharacters = false;
		showsChangeJobMenu = false;

		button = new Rectangle2D.Double();

		actionButtonList = new ArrayList<>();
		freePlaceList = new ArrayList<>();
		possiblePlaces = new ArrayList<>();
		possibleActions = new ArrayList<>();
		aiCharacters = new ArrayList<>();
		aiCharactersG = new ArrayList<>();
		jobButtonsG = new ArrayList<>();

		this.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				mouseClickReaction(me);
			}

		});

	}

	protected void mouseOverReaction(MouseEvent e)
	{
		e.translatePoint((int) (-parent.getBounds().getX()), 25);
		if (showsCharacters == false && showsChangeJobMenu == false)
		{
			for (Rectangle2D rect : actionButtonList)
			{

				if (rect.getBounds().contains(e.getPoint()))
				{
					int actionIndex = actionButtonList.indexOf(rect);

					Variables.getGameLogic().getUserInterface().getInfoBox()
							.fillInfo(possibleActions.get(actionIndex));
				}
			}

			for (Rectangle2D rect : freePlaceList)
			{
				if (rect.contains(e.getPoint()))
				{
					int placeIndex = freePlaceList.indexOf(rect);
					Variables.getGameLogic().getUserInterface().getInfoBox()
							.fillInfo(possiblePlaces.get(placeIndex));
				}
			}
		} else if (showsChangeJobMenu == true)
		{
			for (Rectangle2D rect : jobButtonsG)
			{
				if (rect.contains(e.getPoint()))
				{
					int jobIndex = jobButtonsG.indexOf(rect);
					Variables.getGameLogic().getUserInterface().getInfoBox()
							.fillInfo(Job.getJobs()[jobIndex]);

				}
			}
		} else
		{
			for (Rectangle2D rect : aiCharactersG)
			{
				if (rect.contains(e.getPoint()))
				{
					int characterIndex = aiCharactersG.indexOf(rect);
					Variables.getGameLogic().getUserInterface().getInfoBox()
							.fillInfo(aiCharacters.get(characterIndex));

				}

			}
		}

	}

	protected void mouseClickReaction(MouseEvent me)
	{
		if (showsCharacters == false && showsChangeJobMenu == false)
		{
			for (Rectangle2D rect : actionButtonList)
			{
				if (rect.contains(me.getPoint()))
				{
					int actionIndex = actionButtonList.indexOf(rect);
					if (actionIndex == 0)
					{
						showsCharacters = true;
						aiCharacters = Variables.getCharacterList();
					}
					setCharacterAction(index, actionIndex);
					showDropMenu = actionIndex;

					if ((index == 3 || index == 5)
							&& actionIndex == actionButtonList.size() - 1)
					{
						showsChangeJobMenu = true;
					}
				}

			}

			for (Rectangle2D rect : freePlaceList)
			{
				// System.out.println(freePlaceList.size());
				if (rect.contains(me.getPoint()))
				{
					int placeIndex = freePlaceList.indexOf(rect);
					Variables.getGameLogic().getCharacter()
							.setFreeChoice(possiblePlaces.get(placeIndex));
				}
			}
		} else if (showsChangeJobMenu == true)
		{
			for (Rectangle2D rect : jobButtonsG)
			{
				if (rect.contains(me.getPoint()))
				{
					int placeIndex = jobButtonsG.indexOf(rect);
					Variables.getGameLogic().getCharacter()
							.setNextJob(Job.getJobs()[placeIndex]);
					showsChangeJobMenu = false;
				}
			}
		} else
		{
			for (Rectangle2D rect : aiCharactersG)
			{
				if (rect.contains(me.getPoint()))
				{
					int characterIndex = aiCharactersG.indexOf(rect);
					Variables.getPlayerCharacter().setvictim(
							aiCharacters.get(characterIndex));
					showsCharacters = false;

				}

			}

			if (showsCharacters == false)
			{
				aiCharacters = new ArrayList<>();
				aiCharactersG = new ArrayList<>();
			}
		}

	}

	protected void mouseWheeled(MouseWheelEvent e)
	{

		int nextShift = shift - e.getWheelRotation();
		if (nextShift <= 0
				&& nextShift >= -(aiCharacters.size() - 13) * buttonSpacing)
		{
			shift = nextShift;
		}
	}

	public void paint(Graphics g)
	{
		Graphics2D g1 = (Graphics2D) g;
		super.paintComponent(g1);
		setRect();

		if (showsCharacters == true)
		{
			int spacing = 1;
			for (AICharacter aiCharacter : aiCharacters)
			{

				g1.drawString(aiCharacter.getName(), 10, (int) button
						.getBounds2D().getY() + shift + buttonSpacing * spacing);
				Rectangle2D characterButton = new Rectangle2D.Double(0, button
						.getBounds2D().getY()
						+ shift
						+ buttonSpacing
						* (spacing - 1), 100, buttonSpacing);

				aiCharactersG.add(characterButton);
				g1.draw(characterButton);

				spacing++;
			}
		} else if (showsChangeJobMenu == true)
		{
			int spacing = 1;
			for (Place place : Job.getJobs())
			{
				if (place.isDoable(Variables.getPlayerCharacter()))
				{
					g1.drawString(place.getJobName(), 10, (int) button
							.getBounds2D().getY() + buttonSpacing * spacing);
					Rectangle2D jobButton = new Rectangle2D.Double(0, button
							.getBounds2D().getY()
							+ buttonSpacing
							* (spacing - 1), 100, buttonSpacing);

					jobButtonsG.add(jobButton);
					g1.draw(jobButton);
				}

				spacing++;
			}
		} else
		{
			int spacing = 1;
			actionButtonList.clear();
			getPossibleActions();
			for (PrisonAction action : possibleActions)
			{
				g1.drawString(action.name, 10, (int) button.getBounds2D()
						.getY() + buttonSpacing * spacing);
				Rectangle2D actionButton = null;
				if (index == 6)
				{
					actionButton = new Rectangle2D.Double(0, button
							.getBounds2D().getY()
							+ buttonSpacing
							* (spacing - 1), 100, buttonSpacing);
				} else
				{
					actionButton = new Rectangle2D.Double(0, button
							.getBounds2D().getY()
							+ buttonSpacing
							* (spacing - 1), this.getBounds().getWidth(),
							buttonSpacing);
				}
				actionButtonList.add(actionButton);
				if (Variables.getPlayerCharacter().getSchedule()
						.getAction(index).name.equals(action.name))
				{
					g1.setPaint(Color.red);
				} else
				{
					g1.setPaint(Color.black);
				}
				g1.draw(actionButton);

				g1.setPaint(Color.black);

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
										* (spacing - 1) + spacing2
										* buttonSpacing, 100, buttonSpacing);
						g1.draw(newRect);
						g1.drawString(place.name, 100, (int) button
								.getBounds2D().getY()
								+ buttonSpacing
								* (spacing) + spacing2 * buttonSpacing);
						freePlaceList.add(newRect);
						spacing2++;
					}

				}

				spacing++;
			}
		}

	}

	private void setCharacterAction(int scheduleIndex, int actionIndex)
	{
		// System.out.println("si: " + scheduleIndex + " ai: " + actionIndex);
		Variables.getGameLogic().getCharacter().getSchedule()
				.setAction(scheduleIndex, possibleActions.get(actionIndex));
	}

	private void getPossibleActions()
	{
		possibleActions = Variables.getGameLogic().getCharacter().getSchedule()
				.getPlace(index)
				.getPossibleActions(Variables.getGameLogic().getCharacter());

		if (index == 3 || index == 5)
		{
			possibleActions = ((Job) Variables.getGameLogic().getCharacter()
					.getSchedule().getPlace(index)).jobActions(Variables
					.getGameLogic().getCharacter());
		}
	}

	private List<Place> getPossiblePlaces(PrisonAction action)
	{
		return action.getAllPlaces();
	}

	private void setRect()
	{
		button.setFrame(this.getX(), this.getY(), this.getWidth(),
				this.getHeight());
	}

	public void setIndex(int _index)
	{
		index = _index;
	}

	public int getIndex()
	{
		return index;
	}

}