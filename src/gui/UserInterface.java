package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.GameLogic;
import logic.Variables;
import net.miginfocom.swing.MigLayout;
import save.Deserialize;
import save.SerializeCharacter;

@SuppressWarnings("serial")
public class UserInterface extends JFrame
{
	JPanel panel;
	GameMap gameMap;
	ScheduleBox scheduleBox;
	InfoBox infoBox;
	MigLayout mainLayout;
	GameLogic gameLogic;
	WarningWindow warningWindow;
	MarketPlace marketPlace;
	Rectangle2D marketRect;

	boolean showMarketPlace;
	boolean info;
	boolean paused;
	
	int frame;

	public UserInterface(GameLogic _gameLogic, double resolutionMultiplier)
	{
		this.setUndecorated(true);
		info = false;
		paused = false;
		showMarketPlace = false;
		gameLogic = _gameLogic;
		panel = new JPanel(new MigLayout("fill"));
		infoBox = new InfoBox();
		gameMap = new GameMap(this);
		scheduleBox = new ScheduleBox(this);
		warningWindow = new WarningWindow(this);
		marketPlace = new MarketPlace(this);
		
		frame = 0;

		marketRect = new Rectangle2D.Double((725 * resolutionMultiplier), 0,
				(35 * resolutionMultiplier), (35 * resolutionMultiplier));

		panel.add(gameMap, "w 75%, h 75%");

		panel.add(infoBox, "h 25%, dock south");
		panel.add(scheduleBox, "w 25%, dock east");

		String string = new String("x 0, y 0, w "
				+ Variables.getRightwidth1024() * resolutionMultiplier + ", h "
				+ Variables.getTopheight1024() * resolutionMultiplier);
		panel.add(gameMap, string);

		string = "x 0, y " + Variables.getTopheight1024()
				* resolutionMultiplier + ", w " + Variables.getRightwidth1024()
				* resolutionMultiplier + ", h "
				+ Variables.getBottomheight1024() * resolutionMultiplier;
		panel.add(infoBox, string);

		string = "x " + Variables.getRightwidth1024() * resolutionMultiplier
				+ ", y " + Variables.getShouldbe0() * resolutionMultiplier
				+ ", w " + Variables.getLeftwidth1024() * resolutionMultiplier
				+ ", h " + Variables.getScheduleheight1024()
				* resolutionMultiplier;
		panel.add(scheduleBox, string);

		string = "x " + (Variables.getXresolution() / 3) * resolutionMultiplier
				+ ", y " + Variables.getYresolution() / 3
				* resolutionMultiplier + ", w " + Variables.getXresolution()
				/ 3 * resolutionMultiplier + ", h "
				+ Variables.getYresolution() / 3 * resolutionMultiplier;
		panel.add(warningWindow, string);
		panel.add(marketPlace, "x 0, y 0, w 300, h 300");
		marketPlace.setVisible(false);

		this.add(panel);

		pack();
		scheduleBox.set();
		
		Chronometer fpsCounter = new Chronometer();
		Timer fpsTimer = new Timer("Second");
		fpsTimer.scheduleAtFixedRate(fpsCounter, 0, 1000);

		OnTimer timerTask = new OnTimer();
		Timer timer = new Timer("Clock");
		timer.scheduleAtFixedRate(timerTask, 0, 16);

		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				mouseClickReaction(e);
			}

		});

		this.addMouseWheelListener(new MouseAdapter()
		{
			@Override
			public void mouseWheelMoved(MouseWheelEvent e)
			{
				mouseWheeled(e);
			}
		});

		this.addMouseMotionListener(new MouseAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent e)
			{
				motion(e);
			}

		});
		final UserInterface parrot = this;
		this.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent e)
			{
				

			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				

			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_UP)
				{
					gameLogic.speedUp();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					gameLogic.speedDown();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					Object[] options =
					{ "Save", "Load", "Cancel", "Quit game" };
					int n = JOptionPane.showOptionDialog(parrot,
							"Would you like to save/load your game?",
							"Option menu", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[3]);
					if(n == 0)
					{
						SerializeCharacter.save();
					}
					else if(n==1)
					{
						Deserialize.load();
					}
					else if(n == 3)
					{
						System.exit(0);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					pause();
				}

				

			}

			
		});

	}
	
	private void pause()
	{
		if(paused == false)
		{
			System.out.println("pass4");
			
			if(info == false)
			{
				paused = true;
				gameLogic.setMakeWait(true);
			}
			
			
		}
		else
		{
			paused = false;
			gameLogic.getTimerTask().free();
				
			
		}
		
		
	}

	protected void mouseWheeled(MouseWheelEvent e)
	{
		if (scheduleBox.getBounds().contains(e.getPoint()))
		{
			scheduleBox.mouseWheeled(e);
		}
	}

	protected void motion(MouseEvent e)
	{
		if (scheduleBox.getBounds().contains(e.getPoint()))
		{
			scheduleBox.mouseOverReaction(e);
		}
	}

	protected void mouseClickReaction(MouseEvent e)
	{
		if (info == true)
		{
			if (warningWindow.getBounds().contains(e.getPoint()))
			{
				warningWindow.mouseClickReaction(e);
			}
		} else
		{
			if (gameMap.getBounds().contains(e.getPoint()))
			{
				gameMap.mouseClickReaction(e);
			}
		}

		if (scheduleBox.getBounds().contains(e.getPoint()))
		{
			scheduleBox.mouseClickReaction(e);
		}

		if (showMarketPlace)
		{
			if (!marketPlace.getBounds().contains(e.getPoint()))
			{
				marketPlace.setVisible(false);
				showMarketPlace = false;
				gameLogic.getTimerTask().free();
			}
		}

		if (marketRect.getBounds().contains(e.getPoint()))
		{
			marketPlace.updateSlider();
			marketPlace.setVisible(true);
			showMarketPlace = true;
			gameLogic.setMakeWait(true);

		}

	}

	public GameLogic getGameLogic()
	{
		return gameLogic;
	}

	public InfoBox getInfoBox()
	{
		return infoBox;
	}

	public class OnTimer extends TimerTask
	{

		@Override
		public synchronized void run()
		{
			frame ++;
			if (info == true)
			{

				warningWindow.repaint();
			} else if (showMarketPlace == true)
			{
				marketPlace.repaint();
			} else
			{
				if(!paused)
				{
					gameMap.repaint();
				}
				infoBox.repaint();
				scheduleBox.repaint();
			}

		}

	}
	
	public class Chronometer extends TimerTask
	{

		@Override
		public void run()
		{
			Variables.setFramesPerSecond(frame);
			frame = 0;
			
		}
		
	}

	public void pulse(int currentTime)
	{
		gameMap.showAction();
		scheduleBox.pulse(currentTime);

	}

	public GameMap getGameMap()
	{
		return gameMap;
	}

	public ScheduleBox getScheduleBox()
	{
		return scheduleBox;
	}

	public void setInfo(boolean _info)
	{
		if (_info == true)
		{
			gameLogic.setMakeWait(true);
		} else
		{
			gameLogic.getTimerTask().free();
		}

		info = _info;
	}

	public WarningWindow getWarningWindow()
	{
		return warningWindow;
	}

	public MarketPlace getMarketPlace()
	{
		return marketPlace;
	}
}
