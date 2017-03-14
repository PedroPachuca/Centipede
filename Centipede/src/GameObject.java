import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;


public class GameObject implements MovingObject {
	private double speed, x,y,width, height, health, damage;
	//public static final int NORTH = 1, SOUTH = 3, EAST = 2,WEST = 4;
	
	private double direction;
	private Color color;
	private Image img;
	
	public GameObject(double x, double y, double wid, double ht) {
		setSpeed(5); 
		this.setX(x);
		this.setY(y);
		this.width = wid;
		this.height = ht;
		damage = 0;
		
	}
	
	@Override
	public void move() {
		setX(getX() + getSpeed()*Math.cos(direction));
		// there should be some checking that takes place
		
	}

	@Override
	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detectCollision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		
	}
	public void setImage(Image image) {
		this.img = image;
	}
	public Image getImage() {
		return this.img;
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	public void setWidth(double w) {
		width  =w;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double h) {
		height = h;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

}
