package Logan;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageLoader {
	private static String fs = System.getProperty("file.separator");
	public static PImage RED_PROJECTILE, GREEN_PROJECTILE, YELLOW_STAR, PURPLE_STAR, MAIN_CHARACTER_LEFT,
			MAIN_CHARACTER_RIGHT, BOSS_PILLAR, BOSS,MINION_RIGHT,MINION_LEFT,SLIME_RIGHT,SLIME_LEFT;

	public static void setUp(PApplet p) {
		
		SLIME_RIGHT =p.loadImage("Images" + fs + "Characters" + fs + "Enemy" + fs + "SLIME Right.gif");
		SLIME_LEFT =p.loadImage("Images" + fs + "Characters" + fs + "Enemy" + fs + "SLIME Left.gif");
		MINION_RIGHT =p.loadImage("Images" + fs + "Characters" + fs + "Enemy" + fs + "Minion Knight Right.gif");
		MINION_LEFT =p.loadImage("Images" + fs + "Characters" + fs + "Enemy" + fs + "Minion Knight Left.gif");
		RED_PROJECTILE = p.loadImage("Images" + fs + "Projectiles" + fs + "Red Projectile.gif");
		GREEN_PROJECTILE = p.loadImage("Images" + fs + "Projectiles" + fs + "Green Projectile.gif");
		YELLOW_STAR = p.loadImage("Images" + fs + "Projectiles" + fs + "Yellow Star.gif");
		PURPLE_STAR = p.loadImage("Images" + fs + "Projectiles" + fs + "Purple Star.gif");
		MAIN_CHARACTER_LEFT = p
				.loadImage("Images" + fs + "Characters" + fs + "Main Character" + fs + "Main Character Left.gif");
		MAIN_CHARACTER_RIGHT = p
				.loadImage("Images" + fs + "Characters" + fs + "Main Character" + fs + "Main Character Right.gif");
		BOSS_PILLAR = p.loadImage("Images" + fs + "Characters" + fs + "Boss" + fs + "Pillar.gif");
		BOSS = p.loadImage("Images" + fs + "Characters" + fs + "Boss" + fs + "Octocat.gif");
	}
}
