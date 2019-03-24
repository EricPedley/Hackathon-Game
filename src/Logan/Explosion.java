package Logan;

import java.util.ArrayList;

import processing.core.PApplet;

public class Explosion {
	private int frame;
	private float x, y;
	public Explosion(float f, float g) {
		this.x = f;
		this.y = g;
	}
	
	public void draw(PApplet p, ArrayList<Explosion> e, int i) {
		p.image(ImageLoader.EXPLOSION[frame], x, y, 80, 80);
		if(frame >= 12)
			e.remove(i);
		frame++;
	}
}
