package Logan;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

import Adele.Projectile;

public class Boss {
	
	private int health = 1000;
	private int frame = 0;
	private int x;
	private int y;
	
	private PImage redProj;
	
	public Boss(int x, int y, PImage redProj) {
		this.x = x;
		this.y = y;
		this.redProj = redProj;
	}
	
	
	
	public void draw(PApplet p, ArrayList<Projectile> projectiles) {
		if(frame % 5 == 0) {
			projectiles.add(new Projectile(x, y, 1, frame/10f, 5, redProj));
			projectiles.add(new Projectile(x, y, 1, frame/10f + 72, 5, redProj));
			projectiles.add(new Projectile(x, y, 1, frame/10f + 144, 5, redProj));
			projectiles.add(new Projectile(x, y, 1, frame/10f + 216, 5, redProj));
			projectiles.add(new Projectile(x, y, 1, frame/10f + 288, 5, redProj));
		}
		if(frame % 60 == 0)
			projectiles.add(new SineProjectile(x, y, 1, 0, 5, redProj, 20, 20));
		frame++;
	}
}
