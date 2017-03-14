import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


public abstract class GameMap {

	private List<MovingObject> movers;
	public Image backgroundImage;
	
	public GameMap() {
		movers = new ArrayList();
		openBackgroundImage();
	}

	
	public void openBackgroundImage() {
		try {
			URL url = getClass().getResource("res/bg.jpg");
			System.out.println(url);
			Image image = ImageIO.read(url);
			this.backgroundImage = image;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void add(GameObject go) {
		movers.add(go);
	}


	public void tick() {
		checkAllPos();
		for(MovingObject mo: movers) {
			mo.move();
			for(MovingObject mo2: movers) {
				if(mo != mo2) {
					mo.detectCollision(mo2);
				}
			}
		}
	// TODO Auto-generated method stub
		
	}


	public void shoot() {
		for(int i = 0; i < movers.size(); i++) {
			if(movers.get(i).getClass().getName().equals("Shooter")) {
				Shooter myShooter = (Shooter) movers.get(i);
				add(new Shot(myShooter.getX() + 50, myShooter.getY() - 30, 20, 30));
				add(new Shot(myShooter.getX() - 10,myShooter.getY() - 30, 20, 30));
			}
		}
	}


	public void draw(Graphics g) {
		for(MovingObject mover: movers) {
			mover.draw(g);
		}
		
	}


	public void moveShooterRight() {
		for(MovingObject mover: movers) {
			if(mover.getClass().getName().equals("Shooter")) {
				Shooter myShooter = (Shooter) mover;
				myShooter.right();
			}
		}
		
	}


	public void moveShooterLeft() {
		for(MovingObject mover: movers) {
			if(mover.getClass().getName().equals("Shooter")) {
				Shooter myShooter = (Shooter) mover;
				myShooter.left();
			}
		}
		
	}


	public void moveShooterUp() {
		for(MovingObject mover: movers) {
			if(mover.getClass().getName().equals("Shooter")) {
				Shooter myShooter = (Shooter) mover;
				myShooter.up();
			}
		}
		
	}


	public void moveShooterDown() {
		for(MovingObject mover: movers) {
			if(mover.getClass().getName().equals("Shooter")) {
				Shooter myShooter = (Shooter) mover;
				myShooter.down();
			}
		}
		
	}


	public void checkAllPos() {
		for(int i = 0; i < movers.size(); i++) {                  
		 	 
			if(movers.get(i).checkPos() == true || !movers.get(i).getAlive()) {
				movers.remove(i);
				i--;
			}
		}
	} 	 
}
