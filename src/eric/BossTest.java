package eric;

import java.awt.Dimension;

import javax.swing.JFrame;

import Logan.ImageLoader;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Map;
import rishab.Room;
import rishab.TileImageLoader;

public class BossTest extends PApplet {
	BossRoom r;
	boolean[] keys = new boolean[500];
	static String fS = System.getProperty("file.separator");
	Hero h;
	float startX = 300, startY = 200;
	float transX, transY;
	
	public void setup() {//character image is 14x36 pixels
		ImageLoader.setUp(this);
		TileImageLoader.loadTileImages(this);
			r=new BossRoom();
		h = new Hero(startX,startY,r);
	}
	
	public void draw() {
		transX=0;
		transY=0;
		translate(0,-11);
		transY-=11;
		if(keys[65]) {
			h.moveLeft();
		}  if(keys[87]) {
			h.moveUp();
		}  if(keys[68]) {
			h.moveRight();
		}  if(keys[83]) {
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
		h.shoot(mouseX-transX, mouseY-transY, true);
	}
	
	public static void main(String[] args) {
		BossTest drawing = new BossTest();
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
