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
		
	}
	
	private void addShooter() {
		// TODO Auto-generated method stub
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		add(new Shooter(d.getWidth() / 2 - 15, d.getHeight() - 150, 80, 80));
	}

	private void addSpider() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		add(new Spider(d.getWidth()-200, d.getHeight() - 150, 90, 90));
		
	}

	private void addMushrooms() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dReal = d;
		dReal.setSize(d.width - 110, d.height -200);
		for(int i = 0; i<40; i++) {
		add(new Mushroom(Math.random()*dReal.getWidth(), Math.random()*dReal.getHeight(), 50, 50));
		}
		
	}

	@Override
	public void openBackgroundImage() {
		try {backgroundImage = ImageIO.read(new File("src/bg.jpg"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void paintcomponent(Graphics g) {
	}

}
