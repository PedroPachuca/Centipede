import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public interface MovingObject {
	public int x = 0;
	int y = 0;
	int speed = 0;
	int health = 0;
	boolean alive = true;
	
	public static int getX() {
		return x;
	}
	public static int getY() {
		return y;
	}
	public static int getSpeed() {
		return speed;
	}
	public static int getHealth() {
		return health;
	}
	boolean getAlive();
	void setAlive(boolean nowAlive);
	void die();
	void detectCollision(MovingObject check);
	void move();
	Rectangle getBoundingRect();
	public void draw(Graphics g);
	void right();
	void left();
	void up();
	void down();
	void shoot();
	void collided(MovingObject check);
	void updateRect(double x, double y, double ht, double wid);
	boolean checkPos();
}
