package rishab;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Adele.Projectile;
import Logan.ImageLoader;
import eric.Enemy;
import eric.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Room { 
	
	private int[][] tileType;
	private int x = 42, y = 15;
	private Tile[] tileIndices = new Tile[19];
	private ArrayList<Projectile> myProjectiles;
	private ArrayList<Projectile> enemyProjectiles;
	private ArrayList<Enemy> enemies;
	public static final int TILE_SIZE = 64; 
	private String fs = System.getProperty("file.separator");
	private int numEnemies;
	public final PImage bulletImage;
	private boolean upDoor, downDoor, rightDoor, leftDoor;
	private Map map;
	private Hero h;
	
	//Constuctors
	public Room(int levelNumber, int numEnemies) {
		//tileType = new int [x][y];
		tileIndices = TileImageLoader.tileIndices;
		myProjectiles = new ArrayList<Projectile>();
		enemyProjectiles = new ArrayList<Projectile>();
		enemies = new ArrayList<Enemy>();
		PImage[] enemyImages = {};
		for(int c=0;c<numEnemies;c++) {
			//System.out.println(numEnemies);
			enemies.add(new Enemy(Math.random()*x*TILE_SIZE,Math.random()*y*TILE_SIZE,(int) (Math.random() * 2), this));
		}
		bulletImage = ImageLoader.RED_PROJECTILE;
		readData("Levels"+fs+"Level"+levelNumber+".txt");
		
	}
	
	// Methods
	/*public void assignIndices(PApplet p) {
		tileIndices[0] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"LeftRockWall.gif"),1);
		tileIndices[1] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"RightRockWall.gif"),1);
		tileIndices[2] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"RockTopFront.gif"),1);
		tileIndices[3] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"RockBottomFront.gif"),1);
		tileIndices[4] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"RockWallBack.gif"),1);
		tileIndices[5] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"InwardRockCornerBottomLeft.gif"),1);
		tileIndices[6] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"InwardRockCornerBottomRight.gif"),1);
		tileIndices[7] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"InwardRockCornerTopLeft.gif"),1);
		tileIndices[8] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"InwardRockCornerTopRight.gif"),1);
		tileIndices[9] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"OutwardRockCornerBottomLeft.gif"),1);
		tileIndices[10] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"OutWardRockCornerBottomRight.gif"),1);
		tileIndices[11] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"OutwardRockCornerTopLeft.gif"),1);
		tileIndices[12] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Wall"+fs+"OutwardRockCornerTopRight.gif"),1);
		tileIndices[13] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"1Tile.gif"),0);
		tileIndices[14] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"4Tile.gif"),0);
		tileIndices[15] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileBottomLeft.gif"),0);
		tileIndices[16] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileBottomRight.gif"),0);	tileIndices[17] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileTopLeft.gif"),0);
		tileIndices[18] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileTopRight.gif"),0);
	tileIndices[19]=new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"1Tile.gif"),2);

	}*/
	
	/*public void assignTiles() {
		
		for(int rows = 0; rows < x;rows++) {
			for(int cols = 0; cols < y; cols++) {
				if(rows == 0) {
					tileType[rows][cols] = 0;
				}
				else if(rows == y-1) {
					tileType[rows][cols] = 1;
				}
				else if(cols == 0) {
					tileType[rows][cols] = 2;
				}
				else if(cols == 1) {
					tileType[rows][cols] = 3;
				}
				else if(cols == x-1) {
					tileType[rows][cols] = 4;
				}
				else {
					tileType[rows][cols] = 5;
				}
			}
		}
	}*/

	
	private void readData (String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);
					String s = in.nextLine();
					x = Integer.parseInt(s.substring(0, s.indexOf(',')));
					s = s.substring(s.indexOf(',') + 1); 
					y = Integer.parseInt(s.substring(0, s.indexOf(',')));
					tileType = new int[x][y];
					

					while (in.hasNext()) {
						String line = in.nextLine();
						for(int i = 0; line.indexOf(',') != -1; line = line.substring(line.indexOf(',') + 1) ) {
							
							
							tileType[i][count] = Integer.parseInt(line.substring(0,line.indexOf(',')));
							i++;
							//System.out.println(gameData[i][count]);
						}
						count++;
					}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}
	
	
	public Tile tileAt(int x, int y) {
		return tileIndices[tileType[x][y]];
	}
	
	public void deleteProjectile(Projectile p) {
		if(myProjectiles.contains(p))
			myProjectiles.remove(p);
		
		if(enemyProjectiles.contains(p))
			enemyProjectiles.remove(p);
	}
	
	public void addProjectile(Projectile p,boolean isHero) {
		if(isHero)
		myProjectiles.add(p);
		else
			enemyProjectiles.add(p);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void draw(PApplet p) {
		
		p.pushMatrix();
		//System.out.println(TileImageLoader.tileIndices[0]);
		TileImageLoader.tileIndices[0].draw(p, TILE_SIZE);
		for(int cols = 0; cols < y;cols++) {
			
			for(int rows = 0; rows < x; rows++) {
				//System.out.println(tileType[rows][cols]);
				tileIndices[tileType[rows][cols]].draw(p, TILE_SIZE);
				p.translate(TILE_SIZE, 0);
			}
			p.translate(-x * TILE_SIZE, TILE_SIZE);
		}
		p.popMatrix();
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).act(h, myProjectiles);

			
			if(enemies.get(i).isDead())
				enemies.remove(i);
			else
				enemies.get(i).draw(p);
		}
		for(Projectile proj: myProjectiles) {
			proj.draw(p);
		}
		for(Projectile proj: enemyProjectiles) {
			proj.draw(p);
		}
	}
	
	public Hero getHero() {
		return h;
	}
	
	public Map getMap() {
		return map;
	}

	public ArrayList<Projectile> getMyProjectiles() {
		// TODO Auto-generated method stub
		return myProjectiles;
	}
}
