import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.JPanel;


public class MovingObjectsPanel extends JPanel {
	
	
	final Dimension defaultDim;// = new Dimension(800,600);
	private Timer t;
	private Color backColor = new Color(255, 255, 255);
	GameMap gm;
	
	public MovingObjectsPanel() {
		this( new Dimension(800,600));

		
	}
	public MovingObjectsPanel(Dimension dim) {
		this.setPreferredSize(dim);		
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		makeGameMap();
		t.start();// start the timer which starts the "ticking"
	}
	private void makeGameMap() {
		gm = new CentipedeGameMap();
		t = new Timer(10, new ActionListener() {// fires off every 10 ms
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gm.tick();// I tell the GameMap to tick... do what
					// you do every time the clock goes off.
				repaint();// naturally, we want to see the new view
			}
				
		});
	// this semicolon is here because it is the end of the new Timer construction...
		setUpKeyMappings();
		
	}
	private void setUpKeyMappings() {
		// maps keys with actions...
		//  The code below maps a KeyStroke to an action to be performed
		// In this case I mapped the space bar key to the action named "shoot"
		// Whenever someone hits the Space Bar the action shoot is sent out

		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"shoot");
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"),"up");
		this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
		//this.getInputMap().put(KeyStroke.getKeyStroke(""))
		//  This associates the command shoot with some action.  In this 
		// case, the action triggers a shoot command invoked on my GameMap.  In general, whatever 
		// goes in the actionPerformed method will be executed when a shoot command
		// is sent...
			
		this.getActionMap().put("shoot",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gm.shoot();
			}
		});
		this.getActionMap().put("right",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gm.moveShooterRight();
			}
		});
		this.getActionMap().put("left",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gm.moveShooterLeft();
			}
		});
		this.getActionMap().put("up",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gm.moveShooterUp();
			}
		});
		this.getActionMap().put("down",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gm.moveShooterDown();
			}
		});
		this.requestFocusInWindow();		
	}

	public void paintComponent(Graphics g) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		g.drawImage(GameMap.backgroundImage, 0, 0, d.width, d.height, null);
		gm.draw(g);
		
	}
	

}
