package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.GameLogic;
import logic.Variables;
import net.miginfocom.swing.MigLayout;

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
	
	boolean info;
	
	public UserInterface(GameLogic _gameLogic, double resolutionMultiplier)
	{
		info = false;
		gameLogic = _gameLogic;
		panel = new JPanel(new MigLayout("fill"));
		infoBox = new InfoBox();
		gameMap = new GameMap(this);
		scheduleBox = new ScheduleBox(this);
		warningWindow = new WarningWindow(this);
		
		
		panel.add(gameMap, "w 75%, h 75%");
		
		panel.add(infoBox, "h 25%, dock south");
		panel.add(scheduleBox, "w 25%, dock east");
		
		
		
		String string = new String("x 0, y 0, w " + Variables.getRightwidth1024() * resolutionMultiplier + ", h " + Variables.getTopheight1024()* resolutionMultiplier);
		panel.add(gameMap, string);
		
		string = "x 0, y " + Variables.getTopheight1024()* resolutionMultiplier + ", w " + Variables.getRightwidth1024()* resolutionMultiplier + ", h " + Variables.getBottomheight1024()* resolutionMultiplier;
		panel.add(infoBox, string);
		
		string = "x " + Variables.getRightwidth1024()* resolutionMultiplier + ", y " + Variables.getShouldbe0()* resolutionMultiplier + ", w " + Variables.getLeftwidth1024()* resolutionMultiplier + ", h " + Variables.getScheduleheight1024()* resolutionMultiplier;
		panel.add(scheduleBox, string);
		
		string = "x " + (Variables.getXresolution()/3)* resolutionMultiplier + ", y " + Variables.getYresolution()/3* resolutionMultiplier + ", w " + Variables.getXresolution()/3* resolutionMultiplier + ", h " + Variables.getYresolution()/3* resolutionMultiplier;
		panel.add(warningWindow, string);
		
		gameMap.setBackground(Color.green);
		infoBox.setBackground(Color.red);
		scheduleBox.setBackground(Color.black);
		
		
		
		this.add(panel);
		
		pack();
		scheduleBox.set();
		
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
		
		this.addMouseMotionListener(new MouseAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent e)
			{
				motion(e);
			}
		});
		
		this.addKeyListener(new KeyListener()
		{
			
			@Override
			public void keyTyped(KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					gameLogic.speedUp();
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					gameLogic.speedDown();
				}
				
			}
		});
		
	}
	
	protected void motion(MouseEvent e)
	{
		if(scheduleBox.getBounds().contains(e.getPoint()))
		{
			scheduleBox.mouseOverReaction(e);
		}
	}

	
	protected void mouseClickReaction(MouseEvent e)
	{
		if(info == true)
		{
			if(warningWindow.getBounds().contains(e.getPoint()))
			{
				warningWindow.mouseClickReaction(e);
			}
		}
		else
		{
			if(gameMap.getBounds().contains(e.getPoint()))
			{
				gameMap.mouseClickReaction(e);
			}
		}
		
		if(scheduleBox.getBounds().contains(e.getPoint()))
		{
			scheduleBox. mouseClickReaction(e);
		}
		
		
	}



	public GameLogic getGameLogic()
	{
		return gameLogic;
	}

	public InfoBox getInfoBox() {
		return infoBox;
	}
	
	public class OnTimer extends TimerTask
	{

		@Override
		public synchronized void run()
		{
			if(info == true)
			{

				warningWindow.repaint();
			}
			else
			{
				gameMap.repaint();
				infoBox.repaint();
				scheduleBox.repaint();
			}
			

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
		info = _info;
	}
	
	public WarningWindow getWarningWindow()
	{
		return warningWindow;
	}
}
