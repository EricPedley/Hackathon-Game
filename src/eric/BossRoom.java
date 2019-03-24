package eric;

import Logan.Boss;
import processing.core.PApplet;
import rishab.Room;

public class BossRoom extends Room {

	private Boss boss;
	
	public BossRoom() {
		super(25, -1);
		boss = new Boss(300,200,100,100);
	}
	
	public void draw(PApplet p) {
		super.draw(p);
		boss.draw(p, super.getMyProjectiles());
	}
	
	

}
