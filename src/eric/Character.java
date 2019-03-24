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
		speed=5;
	}
	
	public void draw(PApplet marker) {//Change!
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
	
	public void moveRight(PApplet marker) {
		direction=1;
		int tileX = (int)(hitbox.x+hitbox.width)/Room.TILE_SIZE;
		int tileY1 = (int)Math.ceil(hitbox.y/Room.TILE_SIZE);
		int tileY2 = (int)Math.floor((hitbox.y+hitbox.height)/Room.TILE_SIZE);
		if(environment.tileAt(tileX,tileY1).getType() == 0)
			return;
		else if(environment.tileAt(tileX,tileY2).getType() == 0)
			return;
		else
			hitbox.x+=speed;
	}
	
	public void moveLeft(PApplet marker) {
		direction=0;
		int tileX = (int)hitbox.x/Room.TILE_SIZE;
		int tileY1 = (int)Math.ceil(hitbox.y/Room.TILE_SIZE);
		int tileY2 = (int)Math.floor((hitbox.y+hitbox.height)/Room.TILE_SIZE);
		if(environment.tileAt(tileX,tileY1).getType() == 0)
			return;
		else if(environment.tileAt(tileX,tileY2).getType() == 0)
			return;
		else
			hitbox.x-=speed;
	}
	
	public void moveUp(PApplet marker) {
		int tileY = (int)hitbox.y/Room.TILE_SIZE;
		int tileX1 = (int) Math.ceil(hitbox.x/Room.TILE_SIZE);
		int tileX2 = (int) Math.floor((hitbox.x+hitbox.width)/Room.TILE_SIZE);
		if(environment.tileAt(tileX1,tileY).getType() == 0) {
			return;
		}else if(environment.tileAt(tileX2,tileY).getType() == 0) {
			return;
		}else
			hitbox.y-=speed;
	}
	
	public void moveDown(PApplet marker) {
		int tileY = (int)(hitbox.y+hitbox.height)/Room.TILE_SIZE;
		int tileX1 = (int) Math.ceil(hitbox.x/Room.TILE_SIZE);
		int tileX2 = (int) Math.floor((hitbox.x+hitbox.width)/Room.TILE_SIZE);
		if(environment.tileAt(tileX1,tileY).getType() == 0)
			return;
		else if(environment.tileAt(tileX2,tileY).getType() == 0)
			return;
		else
			hitbox.y+=speed;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	
}
