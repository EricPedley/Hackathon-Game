package eric;

import Adele.Projectile;
import Phys2D.Circle;
import Phys2D.Rectangle;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Room;


public class Character {
	private int direction; //0=left 1 = right
	protected PImage img;
	protected Rectangle hitbox;
	private int hp;
	private double speed;
	private Room environment;
	
	public Character(double x, double y, double width, double height, PImage image, Room env) {
		img = image;
		hitbox = new Rectangle(x,y,width,height);
		hp=10;
		environment = env;
		speed=10;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void draw(PApplet marker) {//Change!
		marker.image(img, (float)hitbox.x, (float)hitbox.y);
		marker.pushMatrix();
		marker.noFill();
		marker.rect((float)(hitbox.x-20),(float)(hitbox.y-30),100,20);
		marker.fill(0,255,0);
		marker.rect((float)(hitbox.x-20),(float)(hitbox.y-30),hp/10f*100,20);
		marker.popMatrix();
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void checkHit(Projectile p) {
		if(hitbox.isTouching(new Circle(p.getXPos(),p.getYPos(),p.getRadius()))) {
			environment.deleteProjectile(p);
			hp--;
		}
		
	}
	
	public void shoot(double targetX, double targetY, boolean isHero) {
		double angle = Math.atan((targetY-hitbox.y-50)/(targetX-hitbox.x-69*direction));
		if((targetX)<hitbox.x+69*direction)
			angle+=Math.PI;
		environment.addProjectile(new Projectile((float)hitbox.x+69*direction,(float)hitbox.y+50,10,(float)angle,10, environment.bulletImage),isHero);
	}
	
	public void moveRight() {
		direction=1;
		int tileX = (int)Math.floor((getHitbox().x+getHitbox().width)/Room.TILE_SIZE);
		int tileY1 = (int)Math.floor((getHitbox().y+speed)/Room.TILE_SIZE);
		int tileY2 = tileY1+1;
		int tileY3 = (int)Math.floor((hitbox.y+hitbox.height-speed)/Room.TILE_SIZE);
		if(environment.tileAt(tileX,tileY1).getType() == 1)
			return;
		else if(environment.tileAt(tileX,tileY2).getType() == 1)
			return;
		else if(environment.tileAt(tileX,tileY3).getType() == 2)
			return;
		else
			hitbox.x+=speed;
	}
	
	public void moveLeft() {
		direction=0;
		int tileX = (int)hitbox.x/Room.TILE_SIZE;
		int tileY1 = (int)Math.floor((getHitbox().y+speed)/Room.TILE_SIZE);
		int tileY2 = tileY1+1;
		int tileY3 = (int)Math.floor((hitbox.y+hitbox.height-speed)/Room.TILE_SIZE);
		if(environment.tileAt(tileX,tileY1).getType() == 1)
			return;
		else if(environment.tileAt(tileX,tileY2).getType() == 1)
			return;
		else if(environment.tileAt(tileX,tileY3).getType() == 2)
			return;
		else
			hitbox.x-=speed;
	}
	
	public void moveUp() {
		int tileY = (int)(hitbox.y)/Room.TILE_SIZE;
		int tileX1 = (int) Math.floor((hitbox.x+(1-2*direction)*speed)/Room.TILE_SIZE);
		int tileX2 = tileX1+1;
		int tileX3 = (int) Math.floor((hitbox.x+hitbox.width-speed)/Room.TILE_SIZE);
		if(environment.tileAt(tileX1,tileY).getType() == 1) {
			return;
		}else if(environment.tileAt(tileX2,tileY).getType() == 1) {
			return;
		}else if(environment.tileAt(tileX3,tileY).getType() == 2) {
			return;
		}else
			hitbox.y-=speed;
	}
	
	public void moveDown() {
		int tileY = (int)(hitbox.y+hitbox.height)/Room.TILE_SIZE;
		int tileX1 = (int) Math.floor((hitbox.x+(1-2*direction)*speed)/Room.TILE_SIZE);
		int tileX2 = tileX1+1;
		int tileX3 = (int) Math.floor((hitbox.x+hitbox.width-speed)/Room.TILE_SIZE);
		if(environment.tileAt(tileX1,tileY).getType() ==1) {
			return;
		}else if(environment.tileAt(tileX2,tileY).getType() ==1 ) {
			return;
		}else if(environment.tileAt(tileX3,tileY).getType() ==1) {
			return;
		}else if(environment.tileAt(tileX3,tileY).getType() ==2) {
				environment.getMap().changeActiveRoom(0, -1);
			}else
			hitbox.y+=speed;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public void move() {
		
	}
	
	
}
