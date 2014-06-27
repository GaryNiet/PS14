package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.TexturePaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
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
	
	private BufferedImage buttonImage;
	private TexturePaint buttonTex;

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
		
		
		try
		{
			buttonImage = ImageIO.read(new File("floor.jpg"));
		} catch (IOException e)
		{
			System.out.println("floor not found");
		}
		
		buttonTex = new TexturePaint(buttonImage, new Rectangle2D.Double(0,0,200,200));

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
		e.translatePoint((int) (-parent.getBounds().getX()), (int)(-parent.getBounds().getY()));
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
		
		g1.setPaint(Color.black);
		g1.fillRect(0, 0, 2000, 2000);

		if (showsCharacters == true)
		{
			int spacing = 1;
			for (AICharacter aiCharacter : aiCharacters)
			{
				g1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
				Rectangle2D characterButton = null;
				
				if(spacing % 2 == 1)
				{
					
					
					characterButton = new Rectangle2D.Double(0, button
							.getBounds2D().getY()
							+ buttonSpacing * 3
							* (spacing - 1)/2, this.getBounds().getWidth(),
							buttonSpacing * 3);
					
					drawCharacterButton(g1, aiCharacter, characterButton);
					
					g1.setPaint(Color.white);
					g1.drawString(aiCharacter.getName(), 10, (int) (button
							.getBounds2D().getY()
							+ buttonSpacing * 3
							* (spacing)/2));
				}
				else
				{
					
					
					characterButton = new Rectangle2D.Double(this.getWidth()/2, button
							.getBounds2D().getY()
							+ buttonSpacing * 3
							* (int)((spacing - 1)/2), this.getBounds().getWidth(),
							buttonSpacing * 3);
					
					drawCharacterButton(g1, aiCharacter, characterButton);
					
					g1.setPaint(Color.white);
					g1.drawString(aiCharacter.getName(), 10 + this.getWidth()/2, (int) (button
							.getBounds2D().getY()
							+ buttonSpacing * 3
							* (spacing - 1)/2));
				}


				aiCharactersG.add(characterButton);
				

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
			g1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			for (PrisonAction action : possibleActions)
			{
				
				Rectangle2D actionButton = null;
				if (index == 6)
				{
					g1.drawString(action.name, 10, (int) button.getBounds2D()
							.getY() + buttonSpacing * spacing);
					actionButton = new Rectangle2D.Double(0, button
							.getBounds2D().getY()
							+ buttonSpacing
							* (spacing - 1), 100, buttonSpacing);
					
					drawActionButton(g1, action.name, actionButton);
				} else
				{
					if(spacing % 2 == 1)
					{
						
						
						actionButton = new Rectangle2D.Double(0, button
								.getBounds2D().getY()
								+ buttonSpacing * 3
								* (spacing - 1)/2, this.getBounds().getWidth(),
								buttonSpacing * 3);
						
						drawActionButton(g1, action.name, actionButton);
						
						g1.setPaint(Color.white);
						g1.drawString(action.name, 10, (int) (button
								.getBounds2D().getY()
								+ buttonSpacing * 3
								* (spacing)/2));
					}
					else
					{
						
						
						actionButton = new Rectangle2D.Double(this.getWidth()/2, button
								.getBounds2D().getY()
								+ buttonSpacing * 3
								* (int)((spacing - 1)/2), this.getBounds().getWidth(),
								buttonSpacing * 3);
						
						drawActionButton(g1, action.name, actionButton);
						
						g1.setPaint(Color.white);
						g1.drawString(action.name, 10 + this.getWidth()/2, (int) (button
								.getBounds2D().getY()
								+ buttonSpacing * 3
								* (spacing - 1)/2));
					}
					
				}
				

				g1.setPaint(Color.white);

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

	private void drawCharacterButton(Graphics2D g1, AICharacter aiCharacter,
			Rectangle2D characterButton)
	{
		actionButtonList.add(characterButton);
		
		g1.setPaint(buttonTex);
		
		g1.fill(characterButton);
		
		Stroke stroke = new BasicStroke(10);
		Shape strokedOutline = stroke.createStrokedShape(characterButton);
		g1.setPaint(Color.black);
		
		g1.fill(strokedOutline);
		
	}

	private void drawActionButton(Graphics2D g1, String name,
			Rectangle2D actionButton)
	{
		actionButtonList.add(actionButton);
		if (Variables.getPlayerCharacter().getSchedule()
				.getAction(index).name.equals(name))
		{
			g1.setPaint(Color.red);
		} else
		{
			g1.setPaint(buttonTex);
		}
		g1.fill(actionButton);
		
		Stroke stroke = new BasicStroke(10);
		Shape strokedOutline = stroke.createStrokedShape(actionButton);
		g1.setPaint(Color.black);
		
		g1.fill(strokedOutline);
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