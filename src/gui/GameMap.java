package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class GameMap extends JPanel {
	
	Border border;
	
	public GameMap()
	{
		border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);
	}

}
