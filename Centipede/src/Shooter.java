import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;


public class Shooter extends GameObject{

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
			Image image = ImageIO.read(new File("src/shooter.png"));
			setImage(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void move() {
		
	}
	public void right(){
		this.setX(this.getX() + getSpeed());
	}
	public void left() {
		this.setX(this.getX() - getSpeed());
	}
	public void up() {
		this.setY(this.getY() - getSpeed());
	}
	public void down() {
		this.setY(this.getY() + getSpeed());
	}
	
	public void draw(Graphics g) {
		g.drawImage(getImage(), (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
		
	}
	public void shoot() {
		System.out.println("SHOOT");
	}
}
