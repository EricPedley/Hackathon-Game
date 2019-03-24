package eric;

import java.awt.Dimension;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import java.io.File;
import java.io.IOException;

import Logan.ImageLoader;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Map;
import rishab.Room;
import rishab.TileImageLoader;
import sun.audio.AudioPlayer;


public class BossTest extends PApplet {
	BossRoom r;
	boolean[] keys = new boolean[500];
	static String fS = System.getProperty("file.separator");
	Hero h;
	float startX = 300, startY = 200;
	float transX, transY;
	
	Clip clip; 
	AudioInputStream audioInputStream;
	
	private String fs = System.getProperty("file.separator");
	public static void main(String[] args) {
        PApplet.main("eric.BossTest");

    }
	
	public void settings() {
		this.fullScreen();
	}
	
	public void setup() {
		try {
			audioInputStream =  
			        AudioSystem.getAudioInputStream(new File("Music" + fs + "Boss Music.wav").getAbsoluteFile());
			// create clip reference 
	        try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	          
	        // open audioInputStream to the clip 
	        try {
				clip.open(audioInputStream);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
          
        
          
        clip.loop(Clip.LOOP_CONTINUOUSLY);
		//character image is 14x36 pixels
		ImageLoader.setUp(this);
		TileImageLoader.loadTileImages(this);
		r= new BossRoom();	
		h = new Hero(r.getX()/2 * r.TILE_SIZE,r.getY()/2 * r.TILE_SIZE,r);
		r.setHero(h);
		
	}
	
	public void draw() {
		if(h.getHp()>0) {
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
		} else {
			System.out.println("about to die");
			image(ImageLoader.GAME_OVER,0,0,width,height);
		}
	}
	
	public void keyPressed() {//fuck this
		keys[keyCode]=true;
	}
	
	public void keyReleased() {
		keys[keyCode]=false;
	}
	
	public void mouseClicked() {
		h.shoot(mouseX-transX, mouseY-transY, true);
	}
	
	
}
