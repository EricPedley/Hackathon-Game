package Adele;

import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;

public class Projectile 
{

	
	private Color color;
	boolean[] keys = new boolean[500];

	private float xPos;
	private float yPos;
	private float velocity;
	private float direction;
	private float radius;

	private PImage image;

	public Projectile(int xPos, int yPos, int radius, int direction) {
		
	}

	public Projectile(float xPos, float yPos, float velocity, float direction, float radius, PImage image) { 

		this.setXPos(xPos);
		this.setYPos(yPos);
		this.setRadius(radius);

		this.velocity = velocity;
		this.direction = direction;
		this.image = image;
		
	}
	
	public void setXPos(float x) 
	{
		xPos = x;
	}
	
	public float getXPos() 
	{
		return xPos;
	}
	
	public void setYPos(float y) 
	{
		yPos = y;
	}

	
	public float getYPos() 
	{
		return yPos;
	}
	
	public void setRadius(float r) 
	{
		radius = r;
	}
	
	public float getRadius() 
	{
		return radius;
	}
			
	
	public float getVel() 
	{
		return velocity;
	}
	
	public void setVel(float vel) 
	{
		velocity = vel;
	}
	
	public float getDirection() 
	{
		return direction;
	}
	
	public void setDirection(float dir) 
	{
		direction = dir;
	}
	
	public Projectile shoot() {
		
		return new Projectile(0, 50, 20, 0);
		
		
	}
	
	public void keyPressed() {
		keys[hashCode()]=true;
	}
	
	public void keyReleased() {
		keys[hashCode()]=false;
	}
	
	
	
	public void draw(PApplet board) {
		
		float xMove = velocity*PApplet.cos(direction);
		float yMove = velocity*PApplet.sin(direction);
		
		xPos += xMove;
		yPos += yMove;
		board.pushMatrix();
		board.translate(xPos, yPos);
		board.rotate(direction);
		board.image(image, -radius, -radius,radius * 2, radius * 2);
		board.popMatrix();
	}

}
