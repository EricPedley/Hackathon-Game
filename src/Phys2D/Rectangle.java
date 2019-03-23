package Phys2D;
import processing.core.PApplet;

public class Rectangle {
	public double x,y,width,height;
	
	public Rectangle(double x, double y, double width, double height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public Rectangle() {
		this(0,0,0,0);
	}

	public boolean isTouching(Circle circle) {
		if(circle.x+circle.radius>=x&&circle.y>=y&&circle.y<=y+height&&circle.x+circle.radius<=x+width)
			return true;
		else if(circle.x-circle.radius<=x+width&&circle.y>=y&&circle.y<=y+height&&circle.x-circle.radius>=x)
			return true;
		else if(circle.y+circle.radius>=y&&circle.x>=x&&circle.x<=x+width&&circle.y+circle.radius<=y+height)
			return true;
		else if(circle.y-circle.radius<=y+height&&circle.x>=x&&circle.x<=x+width&&circle.y-circle.radius>=y)
			return true;
		else if(getDistance(x,y,circle.x,circle.y)<=circle.radius)
			return true;
		else if(getDistance(x+width,y,circle.x,circle.y)<=circle.radius)
			return true;
		else if(getDistance(x,y+height,circle.x,circle.y)<=circle.radius)
			return true;
		else if(getDistance(x+width,y+height,circle.x,circle.y)<=circle.radius)
			return true;
		else
			return false;
	}
	
	public boolean isTouching(Rectangle other) {
		System.out.println();
		double leftEdge = Math.min(x, x+width);
		double rightEdge = Math.max(x, x+width);
		double topEdge = Math.max(y, y+height);
		double bottomEdge = Math.min(y, y+height);
		double leftEdgeOther = Math.min(other.x, other.x+other.width);
		double rightEdgeOther = Math.max(other.x, other.x+other.width);
		double topEdgeOther = Math.max(other.y, other.y+other.height);
		double bottomEdgeOther = Math.min(other.y, other.y+other.height);
		System.out.println(leftEdge<=rightEdgeOther&&leftEdge>=rightEdgeOther);
		return (leftEdge<=rightEdgeOther&&leftEdge>=leftEdgeOther||
				rightEdge>=leftEdgeOther&&rightEdge<=rightEdgeOther)&&
				(bottomEdge<=topEdgeOther&&bottomEdge>=bottomEdgeOther||
				topEdge>=bottomEdgeOther&&topEdge<=topEdgeOther);
	}
	
	public double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
	public void draw(PApplet marker) {
		marker.rect((float)x,(float)y,(float)width,(float)height);
	}
}
