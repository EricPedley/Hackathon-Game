package eric;

import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PImage;
import rishab.Room;

public class CharacterTest extends PApplet {
	static String fS = System.getProperty("file.separator");
	private PImage leftImage = new PApplet().loadImage("Images"+fS+"Characters"+fS+"Main Character"+"fS"+"Main Character Left.gif");
	private PImage rightImage = new PApplet().loadImage("Images"+fS+"Characters"+fS+"Main Character"+"fS"+"Main Character Right.gif");
	Hero h;
	Room r;
	public void setup() {//character image is 14x36 pixels
		PImage img = loadImage("Images"+fS+"Characters"+fS+"Main Character"+fS+"Main Character Left.gif");
		r=new Room();
		h = new Hero(100,100,leftImage,rightImage,r);
	}
	
	public void draw() {
		r.draw(this);
		h.draw(this);
	}
	
	public static void main(String[] args) {
		CharacterTest drawing = new CharacterTest();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(400, 300);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}
}