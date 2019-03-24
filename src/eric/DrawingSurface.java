package eric;

import Logan.ImageLoader;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Map;
import rishab.Room;
import rishab.TileImageLoader;

public class DrawingSurface extends PApplet {

		private Map m = new Map();
		private boolean[] keys = new boolean[500];
		private static String fS = System.getProperty("file.separator");
		private Hero h;
		private float startX = 300, startY = 200;
		
		public void setup() {
			TileImageLoader.loadTileImages(this);
			ImageLoader.setUp(this);
			 PImage leftImage = loadImage("Images"+fS+"Characters"+fS+"Main Character"+fS+"Main Character Left.gif");
			 PImage rightImage = loadImage("Images"+fS+"Characters"+fS+"Main Character"+fS+"Main Character Right.gif");
			m=new Map();
			h = new Hero(startX,startY,m.getActiveRoom());
			
		}
		
		public void draw() {
			translate(0,-11);
			handleKeys();
			translate(startX-(float)h.getHitbox().x,startY-(float)h.getHitbox().y);
			Room r = m.getActiveRoom();
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
		
		public void handleKeys() {
			
			if(keys[65]) {
				h.moveLeft();
			}  if(keys[87]) {
				h.moveUp();
			}  if(keys[68]) {
				h.moveRight();
			}  if(keys[83]) {
				h.moveDown();
			}
		}
		
		public void keyPressed() {
			//System.out.println(keyCode);
			keys[keyCode]=true;
		}
		
		public void keyReleased() {
			keys[keyCode]=false;
		}
		
		public void mouseClicked() {
			h.shoot(-startX+(float)h.getHitbox().x+mouseX, -startY+(float)h.getHitbox().y+mouseY, true);
		}
}
