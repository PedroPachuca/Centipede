import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {

	private List<MovingObject> movers;
	public static Image backgroundImage;
	
	public GameMap() {
		movers = new ArrayList();
		openBackgroundImage();
	}

	
	public abstract void openBackgroundImage();


	public void add(GameObject go) {
		movers.add(go);
	}


	public void tick() {
		for(MovingObject mo: movers) {
			mo.move();
		}
	// TODO Auto-generated method stub
		
	}


	public void shoot() {
		movers.get(41).shoot();
		
	}


	public void draw(Graphics g) {
		for(MovingObject mover: movers) {
			mover.draw(g);
		}
		
	}


	public void moveShooterRight() {
		movers.get(41).right();
		
	}


	public void moveShooterLeft() {
		movers.get(41).left();
		
	}


	public void moveShooterUp() {
		movers.get(41).up();
		
	}


	public void moveShooterDown() {
		movers.get(41).down();
		
	} 	
}
