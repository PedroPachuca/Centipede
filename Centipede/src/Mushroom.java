import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class Mushroom extends GameObject {
	public Mushroom(double x, double y, double wid, double ht) {
		super(x, y, wid, ht);
		openImage();
		this.setHeight(ht);
		this.setWidth(wid);
		this.setX(x);
		this.setY(y);
		// TODO Auto-generated constructor stub
	}
	

	private void openImage() {
		try {
			Image image = ImageIO.read(new File("src/mushroom.png"));
			setImage(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	


	@Override
	public void move() {
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(getImage(), (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
	}
}
