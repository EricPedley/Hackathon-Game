package Logan;

import Adele.Projectile;
import processing.core.PApplet;
import processing.core.PImage;

public class SineProjectile extends Projectile {

	private float amplitude;
	private float period;
	private int count;
	public SineProjectile(int xPos, int yPos, float velocity, int direction, int radius, PImage image, float amplitude, float period) {
		super(xPos, yPos, velocity, direction,radius,image);

		this.amplitude = amplitude;
		this.period = period;
		count = 0;
	}
	
	public void draw(PApplet p) {
		float height = amplitude * PApplet.sin(PApplet.TWO_PI * count / period);
		p.pushMatrix();
		p.translate(PApplet.sin(super.getDirection()) * height, PApplet.cos(super.getDirection()) * height);
		super.draw(p);
		p.popMatrix();
		count++;
		
	}

}
