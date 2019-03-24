package eric;

import processing.core.PApplet;
import processing.core.PImage;
import rishab.Room;
import Logan.*;

public class Hero extends Character {
	
	public Hero(double x, double y, Room env) {
		super(x, y, 23*3,30*3,null, env);
	}
	
	public void draw(PApplet marker) {
		if(super.getDirection()==0) {
			super.img=ImageLoader.MAIN_CHARACTER_LEFT;
		} else {
			super.img=ImageLoader.MAIN_CHARACTER_RIGHT;
		}
		img.resize((int)hitbox.width, (int)hitbox.height);
		super.draw(marker);
	}

}
