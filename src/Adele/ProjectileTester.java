package Adele;

import java.awt.Dimension;

import javax.swing.JFrame;

import eric.Hero;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Room;

public class ProjectileTester extends PApplet 
{
	
	boolean[] keys = new boolean[500];
	static String fS = System.getProperty("file.separator");
	Room r;
	Projectile b;
	float startX = 300, startY = 200;
	
	public void setup() {//character image is 14x36 pixels
		 PImage image = loadImage("Images"+fS+"Projectiles"+fS+"Red Projectile.gif");
		 
		 
		r = new Room(this);
		
	}
	
	
	public void draw() {
		if(keys[13]) {
			b.shoot();
		}
	}
	
	public void keyPressed() {
		keys[keyCode]=true;
	}
	
	public void keyReleased() {
		keys[keyCode]=false;
	}
	
	
	public static void main(String[] args) 
	{
		ProjectileTester bullet = new ProjectileTester();
		PApplet.runSketch(new String[]{""}, bullet);
		PSurfaceAWT surf = (PSurfaceAWT) bullet.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		
		window.setSize(600, 400);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		
	}
}
