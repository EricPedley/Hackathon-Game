package Adele;
import eric.Character;
import processing.core.PImage;
import rishab.Room;

import eric.Hero;

public class Enemy extends Character {
	
	
	public Enemy(double x, double y, PImage image, Room env) 
	{
		super(x, y, image.width,image.height,image,env);
		
	}
	
	
	
	public void act(Hero h) 
	{
		
		super.shoot(h.getHitbox().x, h.getHitbox().y, true);
	}
	
	public void checkHits() 
	{
		
	}
	
	public void draw() 
	{
		
	}
	
	

}
