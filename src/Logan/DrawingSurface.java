package Logan;


import Adele.Projectile;
import java.awt.Point;
import processing.event.KeyEvent;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;



public class DrawingSurface extends PApplet {

	private String fs = System.getProperty("file.separator");
	
	Boss boss;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	PImage[] images = new PImage[4];
	
	public DrawingSurface() {
		
		
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		ImageLoader.setUp(this);
		images[0] = this.loadImage("Images" + fs + "Projectiles" + fs + "Red Projectile.gif");
		images[1] = this.loadImage("Images" + fs + "Projectiles" + fs + "Green Projectile.gif");
		images[2] = this.loadImage("Images" + fs + "Projectiles" + fs + "Purple Star.gif");
		boss = new Boss(200, 200, 50, 50);
		//projectiles.add(new Projectile(50, 50, 0, 5, this.loadImage("Images" + fs + "Projectiles" + fs + "Red Projectile.gif")));

		//size(0,0,PApplet.P3D);
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);
		for(Projectile p: projectiles) {
			p.draw(this);
		}
		boss.draw(this, projectiles);
		
		
	}
	
	public void mouseClicked() {
		boss.takeDamage(100);
	}
	
	
	

	
}










