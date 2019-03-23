package eric;

import Adele.Projectile;
import Phys2D.Circle;
import Phys2D.Rectangle;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Room;


public class Character {
	private int direction; //0=left 1 = right
	protected PImage img;
	protected Rectangle hitbox;
	private int hp;
	private double speed;
	private Room environment;
	
	public Character(double x, double y, double width, double height, PImage image, Room env) {
		img = image;
		hitbox = new Rectangle(x,y,width,height);
		hp=100;
		environment = env;
	}
	
	public void draw(PApplet marker) {
		marker.image(img, (float)hitbox.x, (float)hitbox.y);
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void checkHit(Projectile p) {
		if(hitbox.isTouching(new Circle(p.getXPos(),p.getYPos(),p.getRadius()))) {
			hp--;
		}
		environment.deleteProjectile(p);
	}
	
	public void moveRight() {
		direction=1;
		int tileX = (int)(hitbox.x+hitbox.width)/Room.TILE_SIZE;
		int tileY1 = (int)(hitbox.y)/Room.TILE_SIZE;
		int tileY2 = (int)(hitbox.y+hitbox.height)/Room.TILE_SIZE;
		if(environment.tileAt(tileX,tileY1).getType() == 0)
			return;
		else if(environment.tileAt(tileX,tileY2).getType() == 0)
			return;
		else
			hitbox.x+=speed;
	}
	
	public void moveLeft() {
		direction=0;
		int tileX = (int)(hitbox.x)/Room.TILE_SIZE;
		int tileY1 = (int)(hitbox.y)/Room.TILE_SIZE;
		int tileY2 = (int)(hitbox.y+hitbox.height)/Room.TILE_SIZE;
		if(environment.tileAt(tileX,tileY1).getType() == 0)
			return;
		else if(environment.tileAt(tileX,tileY2).getType() == 0)
			return;
		else
			hitbox.x-=speed;
	}
	
	public void moveUp() {
		int tileY = (int)(hitbox.y)/Room.TILE_SIZE;
		int tileX1 = (int)(hitbox.x)/Room.TILE_SIZE;
		int tileX2 = (int)(hitbox.x+hitbox.width)/Room.TILE_SIZE;
		if(environment.tileAt(tileX1,tileY).getType() == 0)
			return;
		else if(environment.tileAt(tileX2,tileY).getType() == 0)
			return;
		else
			hitbox.y-=speed;
	}
	
	public void moveDown() {
		int tileY = (int)(hitbox.y+hitbox.y)/Room.TILE_SIZE;
		int tileX1 = (int)(hitbox.x)/Room.TILE_SIZE;
		int tileX2 = (int)(hitbox.x+hitbox.width)/Room.TILE_SIZE;
		if(environment.tileAt(tileX1,tileY).getType() == 0)
			return;
		else if(environment.tileAt(tileX2,tileY).getType() == 0)
			return;
		else
			hitbox.y+=speed;
	}
	
	
}
