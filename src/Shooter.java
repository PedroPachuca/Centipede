import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;


public class Shooter extends GameObject{
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	public Shooter(double x, double y, double wid, double ht) {
		super(x, y, wid, ht);
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		openImage();
	}
	

	private void openImage() {
		try {
			URL url = getClass().getResource("res/shooter.png");
			Image image = ImageIO.read(url);
			setImage(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public void move() {
		this.updateRect(this.getX(), this.getY(), this.getHeight(), this.getWidth());
	}
	public void right(){
		this.setX(this.getX() + getSpeed());
	}
	public void left() {
		this.setX(this.getX() - getSpeed());
	}
	public void up() {
		if(this.getY() - getSpeed() > 650) {
		this.setY(this.getY() - getSpeed());
		}
	}
	public void down() {
			this.setY(this.getY() + getSpeed());
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(getImage(), (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
	}
	public void collided(MovingObject check) {
		if(check.getClass().getName().equals("Spider")) {
			this.setAlive(false);
		}
			
	}
}
