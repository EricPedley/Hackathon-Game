package eric;

import Phys2D.Rectangle;
import processing.core.PApplet;
import processing.core.PImage;


public class Character {
	private int direction; //0=left 1 = right
	private PImage img;
	private Rectangle hitbox;
	private int hp;
	private double speed;
	private Room environment;
	
	public Character(double x, double y, PImage img) {
		hitbox = new Rectangle(x,y,img.width,img.height);
		hp=100;
	}
	
	public void draw(PApplet marker) {
		marker.image(img, (float)hitbox.x, (float)hitbox.y);
	}
	
	public void moveRight() {
		direction=1;
		int tileX = (int)(hitbox.x+hitbox.width)/enironment.TILE_SIZE;
		int tileY1 = (int)(hitbox.y)/environment.TILE_SIZE;
		int tileY2 = (int)(hitbox.y+hitbox.height)/environment.TILE_SIZE;
		if(environment.tileAt(tileX,tileY1) instanceOf SolidTile)
			return;
		else
			hitbox.x+=speed;
	}
	
	
}
