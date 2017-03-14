import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;


public class CentipedeSegment extends GameObject{
	int oldDir = 1;
	public CentipedeSegment(double x, double y, double wid, double ht) {
		super(x, y, wid, ht);
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		openImage();
	}
	public void draw(Graphics g) {
		if(this.getAlive())
		g.drawImage(getImage(), (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
	}
	public void move() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(oldDir == 1) {
			if(this.getX() + this.getSpeed() < d.getWidth()) {
				this.setX(this.getX() + this.getSpeed());
				oldDir = 1;
			}
			else {
				oldDir = 2;
				this.setY(this.getY() + this.getHeight());
			}
			
		}
		if(oldDir == 2) {
			if(this.getX() - this.getSpeed() > 0) {
				this.setX(this.getX() - this.getSpeed());
				oldDir = 2;
			}
			else {
				oldDir = 1;
				this.setY(this.getY() + this.getHeight());
			}
		}
		this.updateRect(this.getX(), this.getY(), this.getHeight(), this.getWidth());
	}
	
	private void openImage() {
		try {
			URL url = getClass().getResource("res/segment.jpg");
			Image image = ImageIO.read(url);
			setImage(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void collided(MovingObject check) {
		if(check.getClass().getName().equals("Shot")) {
			this.setAlive(false);
		}
	}
	public void checkInside(MovingObject check) {
		
		if(this.getBoundingRect().intersects(check.getBoundingRect())) {
			if(check.getClass().getName().equals("Mushroom")) {
				if(oldDir == 1) {
						oldDir = 2;
						this.setY(this.getY() + this.getHeight());

				}
				else if(oldDir == 2) {
						oldDir = 1;
						this.setY(this.getY() + this.getHeight());
				}
				this.updateRect(this.getX(), this.getY(), this.getHeight(), this.getWidth());
				
			}
			else if(this.getAlive()) {
			this.setAlive(false);
			System.out.println("PLACE MUSH HERE");
			check.setAlive(false);
			}
		}
	}
}
