package eric;

import processing.core.PImage;
import rishab.Room;

public class Enemy extends Character {

	public Enemy(double x, double y, PImage image, Room env) {
		super(x, y, image.width,image.height,image,env);
		// TODO Auto-generated constructor stub
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
