import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class CentipedeGameMap extends GameMap {
	
	public CentipedeGameMap() {
		addMushrooms();
		addSpider();
		addShooter();
		createCentipede();
		
	}
	
	private void createCentipede() {
		add(new Centipede(50, 50, 100, 100));
		
	}

	private void addShooter() {
		// TODO Auto-generated method stub
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		add(new Shooter(d.getWidth() / 2 - 60, d.getHeight() - 150, 60, 60));
	}

	private void addSpider() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		add(new Spider(d.getWidth()-200, d.getHeight() - 150, 50, 50));
		
	}

	private void addMushrooms() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dReal = d;
		dReal.setSize(d.width - 110, d.height -300);
		for(int i = 0; i<40; i++) {
			add(new Mushroom(Math.random()*dReal.getWidth(), Math.random()*dReal.getHeight() + 100, 50, 50));
		}
		
	}


	public void paintcomponent(Graphics g) {
	}


}
