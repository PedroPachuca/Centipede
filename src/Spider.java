import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Spider extends GameObject{
	int oldDir = 1;
	public Spider(double x, double y, double wid, double ht) {
		super(x, y, wid, ht);
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		openImage();
	}
	private void openImage() {
		try {
			URL url = getClass().getResource("res/spider.png");
			Image image = ImageIO.read(url);
			setImage(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	


	@Override
	public void move() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		if(oldDir == 1) {
			if(this.getX() - this.getSpeed() > 0) {
				this.setX(this.getX() - this.getSpeed());
				oldDir = 1;
			}
			else {
				oldDir = 0;
			}
		}
		else if(oldDir == 0) {
			if(this.getX() + this.getSpeed() < d.getWidth()) {
				this.setX(getX() + this.getSpeed());
				oldDir = 0;
			}
			else {
				oldDir = 1;
			}
		}
		int UD = (int) (Math.random()*2 +1);
		if(UD == 1) {
			if(this.getY() - this.getSpeed() > 0) {
				this.setY(this.getY() - this.getSpeed());
			}
			else {
				UD = 2;
			}
		}
		if(UD == 2) {
			if(this.getY() + this.getSpeed() < d.getHeight()) {
				this.setY(this.getY() + this.getSpeed());
			}
		}
		updateRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(getImage(), (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
		
	}
	public void collided(MovingObject check) {
		if(check.getClass().getName().equals("Shot")) {
			this.setAlive(false);
		}
	}
}
