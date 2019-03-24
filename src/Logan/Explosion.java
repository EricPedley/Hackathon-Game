package Logan;

import java.util.ArrayList;

import processing.core.PApplet;

public class Explosion {
	private int frame;
	private int x, y;
	public Explosion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(PApplet p, ArrayList<Explosion> e, int i) {
		p.image(ImageLoader.EXPLOSION[frame/5], x, y);
		if(frame >= 65)
			e.remove(i);
	}
}
