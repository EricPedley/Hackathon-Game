package eric;

import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Room;

public class CharacterTest extends PApplet {
	boolean[] keys = new boolean[500];
	static String fS = System.getProperty("file.separator");
	Hero h;
	Room r;
	float startX = 300, startY = 200;
	
	public void setup() {//character image is 14x36 pixels
		 PImage leftImage = loadImage("Images"+fS+"Characters"+fS+"Main Character"+fS+"Main Character Left.gif");
		 PImage rightImage = loadImage("Images"+fS+"Characters"+fS+"Main Character"+fS+"Main Character Right.gif");
		 
		r = new Room(this);
		h = new Hero(startX,startY,leftImage,rightImage,r);
	}
	
	public void draw() {
		if(keys[37]) {
			h.moveLeft(this);
		}  if(keys[38]) {
			h.moveUp(this);
		}  if(keys[39]) {
			h.moveRight(this);
		}  if(keys[40]) {
			h.moveDown(this);
		}
		translate(startX-(float)h.getHitbox().x,startY-(float)h.getHitbox().y);
		background(255);
		r.draw(this);
		h.draw(this);
		int tileY = (int)h.getHitbox().y/Room.TILE_SIZE;
		int tileX1 = (int) Math.floor((h.getHitbox().x+5)/Room.TILE_SIZE);
		int tileX2 = tileX1+1;
		int tileX3 = (int) Math.floor((h.getHitbox().x+h.getHitbox().width-5)/Room.TILE_SIZE);
		noFill();
		h.getHitbox().draw(this);
		rect(tileX1*Room.TILE_SIZE,tileY*Room.TILE_SIZE,Room.TILE_SIZE,Room.TILE_SIZE);
		rect(tileX2*Room.TILE_SIZE,tileY*Room.TILE_SIZE,Room.TILE_SIZE,Room.TILE_SIZE);
		rect(tileX3*Room.TILE_SIZE,tileY*Room.TILE_SIZE,Room.TILE_SIZE,Room.TILE_SIZE);
	}
	
	public void keyPressed() {
		keys[keyCode]=true;
	}
	
	public void keyReleased() {
		keys[keyCode]=false;
	}
	
	public static void main(String[] args) {
		CharacterTest drawing = new CharacterTest();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(600, 400);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}
}
