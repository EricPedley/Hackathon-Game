package Phys2D;
import processing.core.PApplet;

public class Vector {
	public double x, y;

	public Vector() {
		this(0,0);
	}
	
	public Vector(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public double calcMagnitude() {
		return Math.sqrt(x*x+y*y);
	}
	
	public Vector projectionOnto(Vector other) {
		double dp = x*other.x + y*other.y;
		double mag = other.calcMagnitude();
		return new Vector(other.x*dp/mag/mag,other.y*dp/mag/mag);
	}
	
	public Vector getOrthogonalComp(Vector other) {
		return projectionOnto(other).subtractFrom(this);
	}
	
	public Vector subtractFrom(Vector other) {
		return new Vector(other.x-x,other.y-y);
	}
	
	public void multiply(double scalar) {
		x*=scalar;
		y*=scalar;
	}
	
	public void draw(PApplet marker, double x, double y) {
		marker.line((float)x,(float)y, (float)(x+this.x),(float)(y+this.y));
	}
	
}
