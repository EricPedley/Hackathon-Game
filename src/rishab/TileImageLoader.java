package rishab;

import processing.core.PApplet;
import processing.core.PImage;

public class TileImageLoader {
	public static Tile[] tileIndices;
	public static void loadTileImages(PApplet p) {
		System.out.println("hi");
		String fs = System.getProperty("file.separator");
		tileIndices = new Tile[20];
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
		tileIndices[16] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileBottomRight.gif"),0);
		tileIndices[17] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileTopLeft.gif"),0);
		tileIndices[18] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"BigTileTopRight.gif"),0);
		tileIndices[19] = new Tile(p.loadImage("Images"+fs+"Map"+fs+"Floor"+fs+"1Tile.gif"),2);
	}
}
