package rishab;

import processing.core.PApplet;
import processing.core.PImage;

public class Tile {
	
	private PImage image;
	private int type;
	
	public Tile(PImage image, int type ) { 
		this.type = type;
		this.image = image;
	}
	
	public int getType() {
		return type;
	}
	
	public void draw(PApplet p) {
		p.image(image, 0, 0);
	}

}
