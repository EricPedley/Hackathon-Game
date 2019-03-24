package Logan;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

import Adele.Projectile;

public class Boss {
	
	private int health = 1000;
	private final int MAX_HEALTH = 1000;
	private int frame = 1140;
	private float x;
	private float y;
	private boolean direction;
	private float width, height;
	
	private PImage[] images;
	private PImage image;
	
	public Boss(int x, int y, PImage[] images, int width, int height, PImage image) {
		this.x = x;
		this.y = y;
		this.images = images;
		this.image = image;
		this.width = width;
		this.height = height;
	}
	
	public void takeDamage(int damage) {
		health -= damage;
	}
	
	
	
	public void draw(PApplet p, ArrayList<Projectile> projectiles) {
		x = p.width / 2;
		y = p.height / 2;
		p.image(image, x - width / 2, y - height / 2, width, height);
		p.pushStyle();
		p.stroke(0);
		
		p.strokeWeight(p.width/200);
		p.rect(p.width/4, p.height/16, p.width/2, p.height/16);
		p.noStroke();
		if(health > 500)
			p.fill(255 - 255 * (health - MAX_HEALTH / 2) / (MAX_HEALTH / 2), 255, 0);
		else
			p.fill(255, 255 * health / (MAX_HEALTH / 2), 0);
		p.rect(p.width/4, p.height/16, p.width/2 * health / MAX_HEALTH, p.height/16);
		p.popStyle();
		
		if(health > MAX_HEALTH * 3 / 4) {
			if(frame < 1200) {
				if(frame % 10 == 0) {
					if(direction) {
						projectiles.add(new Projectile(x, y, 1, frame/100f, 5, images[0]));
						projectiles.add(new Projectile(x, y, 1, frame/100f + PApplet.TWO_PI/5, 5, images[0]));
						projectiles.add(new Projectile(x, y, 1, frame/100f + PApplet.TWO_PI/5 * 2 , 5, images[0]));
						projectiles.add(new Projectile(x, y, 1, frame/100f + PApplet.TWO_PI/5 * 3, 5, images[0]));
						projectiles.add(new Projectile(x, y, 1, frame/100f + PApplet.TWO_PI/5 * 4, 5, images[0]));
					} else {
						projectiles.add(new Projectile(x, y, 1, -frame/100f, 5, images[0]));
						projectiles.add(new Projectile(x, y, 1, -frame/100f + PApplet.TWO_PI/5, 5, images[0]));
						projectiles.add(new Projectile(x, y, 1, -frame/100f + PApplet.TWO_PI/5 * 2 , 5, images[0]));
						projectiles.add(new Projectile(x, y, 1, -frame/100f + PApplet.TWO_PI/5 * 3, 5, images[0]));
						projectiles.add(new Projectile(x, y, 1, -frame/100f + PApplet.TWO_PI/5 * 4, 5, images[0]));
					}
				}
				if(frame % 60 == 0) {
					float dir = PApplet.atan((p.mouseY - y)/ (p.mouseX - x));
					if(p.mouseX < x)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x, y, 0.5f, dir, 5, images[1], 20, 120, 0));
					projectiles.add(new SineProjectile(x, y, 0.5f, dir, 5, images[1], -20, 120, 0));
				}
				if(frame % 120 == 0)
					if(Math.random() < 0.25)
						direction = !direction;
				
			} else {
				if(frame % 240 == 0) {
					projectiles.add(new Projectile(x, y, 0.5f, 0, 20, images[2]));
					projectiles.add(new Projectile(x, y, 0.5f, PApplet.HALF_PI, 20, images[2]));
					projectiles.add(new Projectile(x, y, 0.5f, PApplet.PI, 20, images[2]));
					projectiles.add(new Projectile(x, y, 0.5f, PApplet.HALF_PI * 3, 20, images[2]));
				} else if(frame % 120 == 0) {
					projectiles.add(new Projectile(x, y, 0.5f, PApplet.QUARTER_PI, 20, images[2]));
					projectiles.add(new Projectile(x, y, 0.5f, PApplet.HALF_PI + PApplet.QUARTER_PI, 20, images[2]));
					projectiles.add(new Projectile(x, y, 0.5f, PApplet.PI + PApplet.QUARTER_PI, 20, images[2]));
					projectiles.add(new Projectile(x, y, 0.5f, PApplet.HALF_PI * 3 + PApplet.QUARTER_PI, 20, images[2]));
				}
				if(frame % 120) {
					projectiles.addAll(new Projectile(x, y, 2, ))
				}
			}
		}
		frame++;
	}
}
