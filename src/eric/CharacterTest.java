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
		int tileX = (int)Math.ceil((h.getHitbox().x)/Room.TILE_SIZE)+1;
		int tileY1 = (int)Math.floor(h.getHitbox().y/Room.TILE_SIZE);
		int tileY2 = tileY1+1;
		int tileY3 = tileY1+2;
		noFill();
		h.getHitbox().draw(this);
		rect(tileX*Room.TILE_SIZE,tileY1*Room.TILE_SIZE,Room.TILE_SIZE,Room.TILE_SIZE);
		rect(tileX*Room.TILE_SIZE,tileY2*Room.TILE_SIZE,Room.TILE_SIZE,Room.TILE_SIZE);
		rect(tileX*Room.TILE_SIZE,tileY3*Room.TILE_SIZE,Room.TILE_SIZE,Room.TILE_SIZE);
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
