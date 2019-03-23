package Adele;

import java.awt.Color;

import processing.core.PApplet;

public class Projectile 
{
	private int xPos;
	private int yPos;
	private int velocity;
	private int direction;
	private int radius;
	private Color color;
	
	
	public Projectile(int xPos, int yPos, int direction, int radius) 
	{
		this.setXPos(xPos);
		this.setYPos(yPos);
		this.setRadius(radius);
		this.color = Color.BLACK;
		this.velocity = 10;
		this.direction = direction;
		
	}
	
	public void setXPos(int x) 
	{
		xPos = x;
	}
	
	public int getXPos() 
	{
		return xPos;
	}
	
	public void setYPos(int y) 
	{
		yPos = y;
	}

	
	public int getYPos() 
	{
		return yPos;
	}
	
	public void setRadius(int r) 
	{
		radius = r;
	}
	
	public int getRadius() 
	{
		return radius;
	}
			
	
	public int getVel() 
	{
		return velocity;
	}
	
	public void setVel(int vel) 
	{
		velocity = vel;
	}
	
	public int getDirection() 
	{
		return direction;
	}
	
	public void setDirection(int dir) 
	{
		direction = dir;
	}
	
	public void draw(PApplet board) {
		
		double xMove = velocity*Math.cos(Math.toRadians(direction));
		double yMove = velocity*Math.sin(Math.toRadians(direction));
		
		xPos += xMove;
		yPos -= yMove;
		
		board.pushMatrix();
		board.pushStyle();
		board.fill(color.getRed(), color.getGreen(), color.getBlue());
		board.ellipse(xPos, yPos, radius, radius);
		board.popMatrix();
		board.popStyle();
	}

}
