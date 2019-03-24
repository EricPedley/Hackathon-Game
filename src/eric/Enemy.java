package eric;

import Logan.ImageLoader;

import java.util.ArrayList;

import Adele.Projectile;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Room;

public class Enemy extends Character {

	/*
	 * public Enemy(double x, double y, PImage image, Room env) { super(x, y,
	 * image.width,image.height,image,env); // TODO Auto-generated constructor stub
	 * }
	 */
	
	private int type;
	private int moveFrame;
	private int shootFrame;
	private int direction;
	public Enemy(double x, double y, int type, Room env) {
		super(x, y, 23*3,30*3,null, env);
		this.type = type;
	}
	
	public void draw(PApplet marker) {
		if(type == 0) {
			if(super.getDirection()==0) {
				super.img=ImageLoader.MINION_LEFT;
			} else {
				super.img=ImageLoader.MINION_RIGHT;
			}
		} else {
			if(super.getDirection()==0) {
				super.img=ImageLoader.SLIME_LEFT;
			} else {
				super.img=ImageLoader.SLIME_RIGHT;
			}
		}
		img.resize((int)hitbox.width, (int)hitbox.height);
		super.draw(marker);
	}
	
	public void act(Hero h, ArrayList<Projectile> proj) {
		if(shootFrame == 30) {
			super.shoot(h.getHitbox().x, h.getHitbox().y, false);
			shootFrame = 0;
		}
			
		if(moveFrame > 60) {
			if(Math.random() < 0.05) {
				direction = (int)(Math.random() * 9);
				moveFrame = 0;
			}
		}
		move();
		for(int i = 0; i < proj.size(); i++)
			super.checkHit(proj.get(i));
	}
	
	public boolean isDead() {
		return super.getHp() <= 0;
	}
	

	public void move() {
		switch(direction) {
		case 0:
			super.moveRight();
			break;
		case 1:
			super.moveLeft();
			break;
		case 2:
			super.moveUp();
			break;
		case 3:
			super.moveDown();
			break;
		case 4:
			super.moveRight();
			super.moveUp();
			break;
		case 5:
			super.moveLeft();
			super.moveUp();
			break;
		case 6:
			super.moveRight();
			super.moveDown();
			break;
		case 7:
			super.moveLeft();
			super.moveDown();
			break;
		}
	}
}
