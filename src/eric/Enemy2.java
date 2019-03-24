package eric;

import Logan.ImageLoader;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Room;

public class Enemy2 extends Character {

	/*
	 * public Enemy(double x, double y, PImage image, Room env) { super(x, y,
	 * image.width,image.height,image,env); // TODO Auto-generated constructor stub
	 * }
	 */
	public Enemy2(double x, double y, Room env) {
		super(x, y, 23*3,30*3,null, env);
	}
	
	public void draw(PApplet marker) {
		if(super.getDirection()==0) {
			super.img=ImageLoader.SLIME_LEFT;
		} else {
			super.img=ImageLoader.SLIME_RIGHT;
		}
		img.resize((int)hitbox.width, (int)hitbox.height);
		super.draw(marker);
	}
	

	public void move(int direction) {
		switch(direction) {
		case 0:
			super.moveRight();
			break;
		case 1:
			super.moveLeft();
			break;
		case 2:
			super.moveUp();
			break;
		case 3:
			super.moveDown();
			break;
		case 4:
			super.moveRight();
			super.moveUp();
			break;
		case 5:
			super.moveLeft();
			super.moveUp();
			break;
		case 6:
			super.moveRight();
			super.moveDown();
			break;
		case 7:
			super.moveLeft();
			super.moveDown();
			break;
		}
	}
}
