package Phys2D;
import processing.core.PApplet;

public class Tester extends PApplet {
	
	
	public void settings() {
		size(500,500);
	}
	
	public void draw() {
		background(255);
		Vector v1 = new Vector();
		v1.x=mouseX-width/2;
		v1.y=mouseY-height/2;
		Vector v2 = new Vector(100,50);
		Vector v3 = v1.projectionOnto(v2);
		Vector v4 = v1.getOrthogonalComp(v2);
		stroke(255,0,0);
		v1.draw(this, width/2, height/2);
		stroke(0,0,255);
		v3.draw(this, width/2, height/2);
		stroke(0,255,0);
		v2.draw(this, width/2, height/2);
		stroke(255,0,255);
		v4.draw(this, width/2, height/2);
		Circle r = new Circle(0,0,50);
		r.x=mouseX;
		r.y=mouseY;
		r.draw(this);
		Rectangle r2 = new Rectangle(200,200,50,70);
		r2.draw(this);
		if(r2.isTouching(r)) {
			fill(255,0,0);
		} else {
			noFill();
		}
	}
	
	public static void main(String[] args) {
		PApplet.main("Tester");
	}
}
