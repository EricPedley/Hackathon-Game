package eric;

import processing.core.PApplet;
import processing.core.PImage;
import rishab.Room;

public class Hero extends Character {
	private static String fS = System.getProperty("file.separator");
	private PImage leftImage,rightImage;
	
	public Hero(double x, double y, PImage leftImage, PImage rightImage, Room env) {
		super(x, y, 14,36,null, env);
		this.leftImage=leftImage;
		this.rightImage=rightImage;
		img = leftImage;
		// TODO Auto-generated constructor stub
	}
	
	public void draw(PApplet marker) {
		if(super.getDirection()==0) {
			super.img=leftImage;
		} else {
			super.img=rightImage;
		}
		img.resize((int)hitbox.width, (int)hitbox.height);
		super.draw(marker);
	}

}
