package eric;

import processing.core.PApplet;
import processing.core.PImage;
import rishab.Map;
import rishab.Room;

public class DrawingSurface extends PApplet {

		private Map m = new Map();
		private boolean[] keys = new boolean[500];
		private static String fS = System.getProperty("file.separator");
		private Hero h;
		private Room r;
		private float startX = 300, startY = 200;
		
		public void setup() {
			 PImage leftImage = loadImage("Images"+fS+"Characters"+fS+"Main Character"+fS+"Main Character Left.gif");
			 PImage rightImage = loadImage("Images"+fS+"Characters"+fS+"Main Character"+fS+"Main Character Right.gif");
			r = new Room(this);
			h = new Hero(startX,startY,leftImage,rightImage,r);
		}
		
		public void draw() {
			translate(0,-11);
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
			if(h.getHitbox().x<width/2)
				translate((float)(h.getHitbox().x-width/2),0);
			if(h.getHitbox().y<height/2)
				translate(0,(float)(h.getHitbox().y-height/2));
			if(r.getX()*Room.TILE_SIZE-h.getHitbox().x<width/2) {
				translate((float)(-(r.getX()*Room.TILE_SIZE-h.getHitbox().x)+width/2),0);
			}
			if(r.getY()*Room.TILE_SIZE-h.getHitbox().y<height/2) {
				translate(0,(float)(-(r.getY()*Room.TILE_SIZE-h.getHitbox().y)+height/2));
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
			h.shoot(mouseX, mouseY, true);
		}
}
