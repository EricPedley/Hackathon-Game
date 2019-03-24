package Logan;

import java.util.ArrayList;

import Adele.Projectile;
import Phys2D.Circle;
import Phys2D.Rectangle;
import eric.Hero;
import processing.core.PApplet;

public class Boss {

	private int health = 200;
	private final int MAX_HEALTH = 200;
	private int frame = 1140;
	private float x;
	private float y;
	private boolean direction;
	private float width, height;
	private float scalar = 10;
	private ArrayList<Explosion> explosions;
	private Hero h;

	public Boss() {
		this.h=h;
		explosions = new ArrayList<Explosion>();

	}
	
	public void setHero(Hero h) {
		this.h=h;
	}

	public void testShot(ArrayList<Projectile> p) {
		for(int i = 0; i < p.size(); i++) {
			
			if((new Rectangle( x - width / 2, y - height / 2, width-20, height - 40)).isTouching(new Circle(p.get(i).getXPos(),p.get(i).getYPos(),p.get(i).getRadius()))) {
				explosions.add(new Explosion(p.get(i).getXPos() - 40,p.get(i).getYPos() - 40));
				p.remove(i);
				
				int prev = health;
				health --;
				if (prev > MAX_HEALTH * 3 / 4 && health <= MAX_HEALTH * 3 / 4)
					frame = 0;
				else if (prev > MAX_HEALTH / 2 && health <= MAX_HEALTH / 2)
					frame = 0;
				else if (prev > MAX_HEALTH / 4 && health <= MAX_HEALTH / 4)
					frame = 0;
			}
		}
		

	}

	public void draw(PApplet p, ArrayList<Projectile> projectiles) {
		width = p.width / 9;
		height = p.height / 4;
		x = p.width / 2;
		y = p.height / 2;
		p.image(ImageLoader.BOSS_PILLAR, x - p.width / 6 - width / 10, y + p.width / 12 - height / 4, width / 5,
				height / 2);
		p.image(ImageLoader.BOSS_PILLAR, x + p.width / 6 - width / 10, y + p.width / 12 - height / 4, width / 5,
				height / 2);
		p.image(ImageLoader.BOSS_PILLAR, x - p.width / 6 - width / 10, y - p.width / 12 - height / 4, width / 5,
				height / 2);
		p.image(ImageLoader.BOSS_PILLAR, x + p.width / 6 - width / 10, y - p.width / 12 - height / 4, width / 5,
				height / 2);
		p.image(ImageLoader.BOSS, x - width / 2, y - height / 2, width, height);
		p.pushStyle();
		p.stroke(0);

		p.strokeWeight(p.width / 200);
		p.rect(p.width / 4, p.height / 16, p.width / 2, p.height / 16);
		p.noStroke();
		if (health > 500)
			p.fill(255 - 255 * (health - MAX_HEALTH / 2) / (MAX_HEALTH / 2), 255, 0);
		else
			p.fill(255, 255 * health / (MAX_HEALTH / 2), 0);
		p.rect(p.width / 4, p.height / 16, p.width / 2 * health / MAX_HEALTH, p.height / 16);
		p.popStyle();
		
		for(int i = 0; i < explosions.size(); i++) {
			explosions.get(i).draw(p, explosions, i);
		}

		if (health > MAX_HEALTH * 3 / 4) {
			if (frame < 1200) {
				if (frame % 10 == 0) {
					if (direction) {
						projectiles.add(new Projectile(x, y, 1 * scalar, frame / 200f, 5, ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, frame / 200f + PApplet.TWO_PI / 5, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, frame / 200f + PApplet.TWO_PI / 5 * 2, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, frame / 200f + PApplet.TWO_PI / 5 * 3, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, frame / 200f + PApplet.TWO_PI / 5 * 4, 5,
								ImageLoader.RED_PROJECTILE));
					} else {
						projectiles.add(new Projectile(x, y, 1 * scalar, -frame / 200f, 5, ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, -frame / 200f + PApplet.TWO_PI / 5, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, -frame / 200f + PApplet.TWO_PI / 5 * 2, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, -frame / 200f + PApplet.TWO_PI / 5 * 3, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, -frame / 200f + PApplet.TWO_PI / 5 * 4, 5,
								ImageLoader.RED_PROJECTILE));
					}
				}
				if (frame % 60 == 0) {
					float dir = PApplet.atan(((float)h.getHitbox().y - y) / ((float)h.getHitbox().x - x));
					if ((float)h.getHitbox().x < x)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x, y, 5f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x, y, 5f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));
				}
				if (frame % 120 == 0)
					if (Math.random() < 0.25)
						direction = !direction;

			} else {
				if (frame % 240 == 0) {
					projectiles.add(new Projectile(x, y, 0.5f * scalar, 0, 20, ImageLoader.PURPLE_STAR));
					projectiles.add(new Projectile(x, y, 0.5f * scalar, PApplet.HALF_PI, 20, ImageLoader.PURPLE_STAR));
					projectiles.add(new Projectile(x, y, 0.5f * scalar, PApplet.PI, 20, ImageLoader.PURPLE_STAR));
					projectiles.add(new Projectile(x, y, 0.5f * scalar, PApplet.HALF_PI * 3, 20, ImageLoader.PURPLE_STAR));
				} else if (frame % 120 == 0) {
					projectiles.add(new Projectile(x, y, 0.5f * scalar, PApplet.QUARTER_PI, 20, ImageLoader.PURPLE_STAR));
					projectiles.add(new Projectile(x, y, 0.5f * scalar, PApplet.HALF_PI + PApplet.QUARTER_PI, 20,
							ImageLoader.PURPLE_STAR));
					projectiles.add(
							new Projectile(x, y, 0.5f * scalar, PApplet.PI + PApplet.QUARTER_PI, 20, ImageLoader.PURPLE_STAR));
					projectiles.add(new Projectile(x, y, 0.5f * scalar, PApplet.HALF_PI * 3 + PApplet.QUARTER_PI, 20,
							ImageLoader.PURPLE_STAR));
				}
				if (frame % 120 == 0) {
					float dir = PApplet.atan(((float)h.getHitbox().y - y) / ((float)h.getHitbox().x - x));
					if ((float)h.getHitbox().x < x)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x, y, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x, y, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x, y, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
				}
				frame = frame % 2400;
			}
		} else if (health > MAX_HEALTH / 2) {
			if (frame % 60 == 0) {
				projectiles.add(new Projectile(x - p.width / 6, y + p.width / 12, 1 * scalar, frame / 60 * PApplet.QUARTER_PI,
						10, ImageLoader.RED_PROJECTILE));
				projectiles.add(new Projectile(x - p.width / 6, y + p.width / 12, 1 * scalar,
						frame / 60 * PApplet.QUARTER_PI + PApplet.PI, 10, ImageLoader.RED_PROJECTILE));

				projectiles.add(new Projectile(x + p.width / 6, y + p.width / 12, 1 * scalar, frame / 60 * PApplet.QUARTER_PI,
						10, ImageLoader.RED_PROJECTILE));
				projectiles.add(new Projectile(x + p.width / 6, y + p.width / 12, 1 * scalar,
						frame / 60 * PApplet.QUARTER_PI + PApplet.PI, 10, ImageLoader.RED_PROJECTILE));

				projectiles.add(new Projectile(x - p.width / 6, y - p.width / 12, 1 * scalar, frame / 60 * PApplet.QUARTER_PI,
						10, ImageLoader.RED_PROJECTILE));
				projectiles.add(new Projectile(x - p.width / 6, y - p.width / 12, 1 * scalar,
						frame / 60 * PApplet.QUARTER_PI + PApplet.PI, 10, ImageLoader.RED_PROJECTILE));

				projectiles.add(new Projectile(x + p.width / 6, y - p.width / 12, 1 * scalar, frame / 60 * PApplet.QUARTER_PI,
						10, ImageLoader.RED_PROJECTILE));
				projectiles.add(new Projectile(x + p.width / 6, y - p.width / 12, 1 * scalar,
						frame / 60 * PApplet.QUARTER_PI + PApplet.PI, 10, ImageLoader.RED_PROJECTILE));
			}
			if (frame < 1200) {
				if (frame % 60 == 0) {
					float dir = PApplet.atan(((float)h.getHitbox().y - y) / ((float)h.getHitbox().x - x));
					if ((float)h.getHitbox().x < x)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x, y, 0.5f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x, y, 0.5f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));
				}
			} else {
				if (frame % 120 == 0) {
					float dir = PApplet.atan(((float)h.getHitbox().y - y) / ((float)h.getHitbox().x - x));
					if ((float)h.getHitbox().x < x)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x, y, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x, y, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x, y, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
				}
			}
			frame = frame % 2400;
		} else if (health > MAX_HEALTH / 4) {
			if (frame < 1200) {
				if (frame % 120 == 0) {
					float dir = PApplet.atan(((float)h.getHitbox().y - y) / ((float)h.getHitbox().x - x));
					if ((float)h.getHitbox().x < x)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x, y, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x, y, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x, y, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));

					float x2 = x - p.width / 6;
					float y2 = y + p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));

					x2 = x + p.width / 6;
					y2 = y + p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));

					x2 = x + p.width / 6;
					y2 = y - p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));

					x2 = x - p.width / 6;
					y2 = y - p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
				}
			} else {
				if (frame % 60 == 0) {
					float dir = PApplet.atan(((float)h.getHitbox().y - y) / ((float)h.getHitbox().x - x));
					if ((float)h.getHitbox().x < x)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x, y, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x, y, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));

					float x2 = x - p.width / 6;
					float y2 = y + p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));

					x2 = x + p.width / 6;
					y2 = y + p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));

					x2 = x + p.width / 6;
					y2 = y - p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));

					x2 = x - p.width / 6;
					y2 = y - p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));
				}
			}
			frame = frame % 2400;
		} else if (health > 0) {
			if (frame < 1200) {
				if (frame % 120 == 0) {
					float dir = PApplet.atan(((float)h.getHitbox().y - y) / ((float)h.getHitbox().x - x));
					if ((float)h.getHitbox().x < x)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x, y, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x, y, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x, y, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));

					float x2 = x - p.width / 6;
					float y2 = y + p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));

					x2 = x + p.width / 6;
					y2 = y + p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));

					x2 = x + p.width / 6;
					y2 = y - p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));

					x2 = x - p.width / 6;
					y2 = y - p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir + PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
					projectiles.add(new Projectile(x2, y2, 3 * scalar, dir - PApplet.THIRD_PI / 2, 10, ImageLoader.YELLOW_STAR));
				}
				if (frame % 60 == 0) {
					float dir = PApplet.atan(((float)h.getHitbox().y - y) / ((float)h.getHitbox().x - x));
					if ((float)h.getHitbox().x < x)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x, y, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x, y, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));

					float x2 = x - p.width / 6;
					float y2 = y + p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));

					x2 = x + p.width / 6;
					y2 = y + p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));

					x2 = x + p.width / 6;
					y2 = y - p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));

					x2 = x - p.width / 6;
					y2 = y - p.width / 12;
					dir = PApplet.atan(((float)h.getHitbox().y - y2) / ((float)h.getHitbox().x - x2));
					if ((float)h.getHitbox().x < x2)
						dir += PApplet.PI;
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, 20, 120, 0));
					projectiles.add(new SineProjectile(x2, y2, 1f * scalar, dir, 5, ImageLoader.GREEN_PROJECTILE, -20, 120, 0));
				}
			} else {
				if (frame % 10 == 0) {
					if (direction) {
						projectiles.add(new Projectile(x, y, 1 * scalar, frame / 200f, 5, ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, frame / 200f + PApplet.TWO_PI / 5, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, frame / 200f + PApplet.TWO_PI / 5 * 2, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, frame / 200f + PApplet.TWO_PI / 5 * 3, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, frame / 200f + PApplet.TWO_PI / 5 * 4, 5,
								ImageLoader.RED_PROJECTILE));
					} else {
						projectiles.add(new Projectile(x, y, 1 * scalar, -frame / 200f, 5, ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, -frame / 200f + PApplet.TWO_PI / 5, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, -frame / 200f + PApplet.TWO_PI / 5 * 2, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, -frame / 200f + PApplet.TWO_PI / 5 * 3, 5,
								ImageLoader.RED_PROJECTILE));
						projectiles.add(new Projectile(x, y, 1 * scalar, -frame / 200f + PApplet.TWO_PI / 5 * 4, 5,
								ImageLoader.RED_PROJECTILE));
					}
				}

				if (frame % 60 == 0) {
					projectiles.add(new Projectile(x - p.width / 6, y + p.width / 12, 1 * scalar,
							frame / 60 * PApplet.QUARTER_PI, 10, ImageLoader.RED_PROJECTILE));
					projectiles.add(new Projectile(x - p.width / 6, y + p.width / 12, 1 * scalar,
							frame / 60 * PApplet.QUARTER_PI + PApplet.PI, 10, ImageLoader.RED_PROJECTILE));

					projectiles.add(new Projectile(x + p.width / 6, y + p.width / 12, 1 * scalar,
							frame / 60 * PApplet.QUARTER_PI, 10, ImageLoader.RED_PROJECTILE));
					projectiles.add(new Projectile(x + p.width / 6, y + p.width / 12, 1 * scalar,
							frame / 60 * PApplet.QUARTER_PI + PApplet.PI, 10, ImageLoader.RED_PROJECTILE));

					projectiles.add(new Projectile(x - p.width / 6, y - p.width / 12, 1 * scalar,
							frame / 60 * PApplet.QUARTER_PI, 10, ImageLoader.RED_PROJECTILE));
					projectiles.add(new Projectile(x - p.width / 6, y - p.width / 12, 1 * scalar,
							frame / 60 * PApplet.QUARTER_PI + PApplet.PI, 10, ImageLoader.RED_PROJECTILE));

					projectiles.add(new Projectile(x + p.width / 6, y - p.width / 12, 1 * scalar,
							frame / 60 * PApplet.QUARTER_PI, 10, ImageLoader.RED_PROJECTILE));
					projectiles.add(new Projectile(x + p.width / 6, y - p.width / 12, 1 * scalar,
							frame / 60 * PApplet.QUARTER_PI + PApplet.PI, 10, ImageLoader.RED_PROJECTILE));
				}

			}
			frame = frame % 2400;
		}
		frame+=5;
	}
}
