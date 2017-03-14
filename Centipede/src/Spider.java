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
	int oldDir = 0;
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
			Image image = ImageIO.read(new File("src/spider.png"));
			setImage(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	


	@Override
	public void move() {
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	int dir  = (int) ((Math.random() * 4) + 1);
	oldDir = dir;
	
	
	boolean up = this.getY() + this.getSpeed() < d.getHeight();
	boolean down = this.getY() - this.getSpeed() > 0;
	boolean right = this.getX() + this.getSpeed() < d.getWidth();
	boolean left  = this.getX() - this.getSpeed() > 0;
	
	if( dir == 1) {
		if(down && left) {
		 this.setX(this.getX() - this.getSpeed());
		 this.setY(this.getY() - this.getSpeed());
		}
	}
	else if(dir == 2) {
		if(up && left) {
		 this.setX(this.getX() - this.getSpeed());
		 this.setY(this.getY() + this.getSpeed());
		}
		
	}
	else if(dir == 3) {
		if(down && right) {
			this.setX(this.getX() + this.getSpeed());
			
			this.setY(this.getY() - this.getSpeed());
		}
	}
	else if(dir == 4) {
		if(up && right) {
			this.setX(this.getX() + this.getSpeed());
			this.setY(this.getY() + this.getSpeed());
		}
	}
	}
	
	public void draw(Graphics g) {
		g.drawImage(getImage(), (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
		
	}

}
