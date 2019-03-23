package rishab;

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

}
