package eric;

import Adele.Projectile;
import Phys2D.Circle;
import Phys2D.Rectangle;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Room;


public class Character {
	private int direction; //0=left 1 = right
	private PImage img;
	private Rectangle hitbox;
	private int hp;
	private double speed;
	private Room environment;
	
	public Character(double x, double y, String imageFilePath) {
		img = new PApplet().loadImage(imageFilePath);
		hitbox = new Rectangle(x,y,img.width,img.height);
		hp=100;
	}
	
	public void draw(PApplet marker) {
		marker.image(img, (float)hitbox.x, (float)hitbox.y);
	}
	
	public void checkHit(Projectile p) {
		if(hitbox.isTouching(new Circle(p.getXPos(),p.getYPos(),p.getRadius()))) {
			hp--;
		}
		environment.deleteProjectile(p);
	}
	
	public void moveRight() {
		direction=1;
		int tileX = (int)(hitbox.x+hitbox.width)/environment.TILE_SIZE;
		int tileY1 = (int)(hitbox.y)/environment.TILE_SIZE;
		int tileY2 = (int)(hitbox.y+hitbox.height)/environment.TILE_SIZE;
		if(environment.tileAt(tileX,tileY1).getType() == 2)
			return;
		else if(environment.tileAt(tileX,tileY2).getType() == 2)
			return;
		else
			hitbox.x+=speed;
	}
	
	public void moveLeft() {
		direction=0;
		int tileX = (int)(hitbox.x)/environment.TILE_SIZE;
		int tileY1 = (int)(hitbox.y)/environment.TILE_SIZE;
		int tileY2 = (int)(hitbox.y+hitbox.height)/environment.TILE_SIZE;
		if(environment.tileAt(tileX,tileY1).getType() == 2)
			return;
		else if(environment.tileAt(tileX,tileY2).getType() == 2)
			return;
		else
			hitbox.x-=speed;
	}
	
	public void moveUp() {
		int tileY = (int)(hitbox.y)/environment.TILE_SIZE;
		int tileX1 = (int)(hitbox.x)/environment.TILE_SIZE;
		int tileX2 = (int)(hitbox.x+hitbox.width)/environment.TILE_SIZE;
		if(environment.tileAt(tileX1,tileY).getType() == 2)
			return;
		else if(environment.tileAt(tileX2,tileY).getType() == 2)
			return
		else
			hitbox.y-=speed;
	}
	
	public void moveDown() {
		int tileY = (int)(hitbox.y+hitbox.y)/environment.TILE_SIZE;
		int tileX1 = (int)(hitbox.x)/environment.TILE_SIZE;
		int tileX2 = (int)(hitbox.x+hitbox.width)/environment.TILE_SIZE;
		if(environment.tileAt(tileX1,tileY).getType() == 2)
			return;
		else if(environment.tileAt(tileX2,tileY).getType() == 2)
			return
		else
			hitbox.y+=speed;
	}
	
	
}
