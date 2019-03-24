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
	float transX, transY;
	
	public void setup() {//character image is 14x36 pixels
		 PImage leftImage = loadImage("Images"+fS+"Characters"+fS+"Main Character"+fS+"Main Character Left.gif");
		 PImage rightImage = loadImage("Images"+fS+"Characters"+fS+"Main Character"+fS+"Main Character Right.gif");
		 
		r = new Room(this);
		h = new Hero(startX,startY,leftImage,rightImage,r);
	}
	
	public void draw() {
		transX=0;
		transY=0;
		translate(0,-11);
		transY-=11;
		if(keys[37]) {
			h.moveLeft();
		}  if(keys[38]) {
			h.moveUp();
		}  if(keys[39]) {
			h.moveRight();
		}  if(keys[40]) {
			h.moveDown();
		}
		translate(startX-(float)h.getHitbox().x,startY-(float)h.getHitbox().y);
		transX+=startX-(float)h.getHitbox().x;
		transY+=startY-(float)h.getHitbox().y;
		if(h.getHitbox().x<width/2) {
			translate((float)(h.getHitbox().x-width/2),0);
			transX+=(float)(h.getHitbox().x-width/2);
		}
		if(h.getHitbox().y<height/2) {
			translate(0,(float)(h.getHitbox().y-height/2));
			transY+=(float)(h.getHitbox().y-height/2);
		}
		if(r.getX()*Room.TILE_SIZE-h.getHitbox().x<width/2) {
			translate((float)(-(r.getX()*Room.TILE_SIZE-h.getHitbox().x)+width/2),0);
			transX+=(float)(-(r.getX()*Room.TILE_SIZE-h.getHitbox().x)+width/2);
		}
		if(r.getY()*Room.TILE_SIZE-h.getHitbox().y<height/2) {
			translate(0,(float)(-(r.getY()*Room.TILE_SIZE-h.getHitbox().y)+height/2));
			transY+=(float)(-(r.getY()*Room.TILE_SIZE-h.getHitbox().y)+height/2);
		}
		background(255);
		r.draw(this);
		h.draw(this);
	}
	
	public void keyPressed() {
		keys[keyCode]=true;
	}
	
	public void keyReleased() {
		keys[keyCode]=false;
	}
	
	public void mouseClicked() {
		System.out.println(transX);
		h.shoot(mouseX-transX, mouseY-transY, true);
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
