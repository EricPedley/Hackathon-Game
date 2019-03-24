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
	
	
	public static void main(String[] args) {
        PApplet.main("eric.BossTest");

    }
	
	public void settings() {
		this.fullScreen();
	}
	
	public void setup() {
		//character image is 14x36 pixels
		ImageLoader.setUp(this);
		TileImageLoader.loadTileImages(this);
		r= new BossRoom();	
		h = new Hero(r.getX()/2 * r.TILE_SIZE,r.getY()/2 * r.TILE_SIZE,r);
		r.setHero(h);
		
	}
	
	public void draw() {
		//System.out.println(height);
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
		/*translate(startX-(float)h.getHitbox().x,startY-(float)h.getHitbox().y);
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
		h.draw(this);*/
		translate(width/2  -(float)h.getHitbox().x ,r.getY()/4 * r.TILE_SIZE-(float)h.getHitbox().y);
		transX+=width/2  -(float)h.getHitbox().x;
		transY+=r.getY()/4 * r.TILE_SIZE-(float)h.getHitbox().y;
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
	
	
}
