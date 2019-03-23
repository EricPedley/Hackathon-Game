package Phys2D;
import processing.core.PApplet;

public class Circle {
	public double x,y,radius;
	
	public Circle(double x, double y, double radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	
	public void draw(PApplet marker) {
		marker.ellipseMode(PApplet.CENTER);
		marker.ellipse((float)x,(float)y,(float)radius*2,(float)radius*2);
	}
}
