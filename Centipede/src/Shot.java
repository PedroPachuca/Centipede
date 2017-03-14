import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Shot extends GameObject{

	public Shot(double x, double y, double wid, double ht) {
		super(x, y, wid, ht);
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		openImage();
	}
	private void openImage() {
		try {
			Image image = ImageIO.read(new File("src/shot.png"));
			setImage(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void move() {
		this.setX(getX() - getSpeed());
		this.detectCollision();
	}
	public void detectCollision() {
		
	}
	public void draw(Graphics g) {
		g.drawImage(getImage(), (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
		
	}

}
