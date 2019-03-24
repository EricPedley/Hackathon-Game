package eric;

import Logan.Boss;
import processing.core.PApplet;
import rishab.Room;

public class BossRoom extends Room {

	private Boss boss;
	
	public BossRoom() {
		super(25, -1);
		boss = new Boss();
	}
	
	public void setHero(Hero h) {
		super.setHero(h);
		boss.setHero(h);
	}
	public void draw(PApplet p) {
		super.draw(p);
		boss.testShot(super.getMyProjectiles());
		boss.draw(p, super.getEnemyProjectiles());
	}
	
	

}
