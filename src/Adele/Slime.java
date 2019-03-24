package Adele;


import processing.core.PApplet;
import processing.core.PImage;


import java.util.ArrayList;



import Logan.SineProjectile;
import eric.Enemy;


public class Slime 
{
	
	private int health = 250;
	private int x;
	private int y;
	
	private PImage slime;
	
	public Slime (int x, int y, PImage slime) 
	{
		this.x = x;
		this.y = y;
		this.slime = slime;
	}
	
	public void draw(PApplet p, ArrayList<Projectile> projectiles) {
		
		projectiles.add(new SineProjectile(x, y, 1, 3, 5, slime, 200, 200));
			
	
		
	}
	
	
	

}
