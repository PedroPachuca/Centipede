import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Centipede extends GameObject{
	ArrayList<CentipedeSegment> segments = new ArrayList<CentipedeSegment>();
	public Centipede(double x, double y, double wid, double ht) {
		super(x, y, wid, ht);
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		createSegments();
		}
	private void createSegments() {
		for(int i = 1; i <= 10; i++) {
			segments.add(new CentipedeSegment(25*i, 25, 25, 25));
		}
		
	}
	public void move() {
		for(CentipedeSegment segment: segments) {
			segment.move();
		}
		
	}
	public void draw(Graphics g) {
		for(CentipedeSegment segment: segments) {
			segment.draw(g);
		}
	}
	public void collided(MovingObject check) {
		if(check.getClass().getName().equals("Shot") || check.getClass().getName().equals("Mushroom")) {
			for(CentipedeSegment cs: segments) {
				cs.checkInside(check);
			}
		}
	}

}
