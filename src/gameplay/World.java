//TODO migrate this stuff to the board class and whereever this stupid stuff neeeds to go

package gameplay;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;



public class World{

	private final int probabilityConstant=20;

	private int gridWidth;
	private int gridHeight;
	private final int blockSize=32; 
	public GameObject[][] grid;

	public World(int widthInBlocks,int heightInBlocks){

		gridHeight=heightInBlocks;
		gridWidth=widthInBlocks;

		grid=new GameObject[widthInBlocks][heightInBlocks];
		fillGrid();

	}
	public void draw(Graphics g){
		for(int i=0;i<gridWidth;i++){
			for(int j=0;j<gridHeight;j++){
				if(grid[i][j]!=null){
					grid[i][j].draw(g);
				}
			}
		}

	}


	private void fillGrid(){
		fillTopAndBottomBorders();
		fillLeftAndRightBorders();
		fillInnerGrid();
		placeBricks();
		grid[2][1]=null; // fix later when implementing the game board.
		grid[1][2]=null; //
		grid[1][1]=null;
	}

	Random rng=new Random(4);
	double percentage;
	
	private void placeBricks(){
		for(int i=0;i<gridWidth;i++){
			for(int j=0;j<gridHeight;j++){
				if(grid[i][j]==null &&(rng.nextInt(100)>=(100-probabilityConstant))){ 
					grid[i][j]=new Brick( new Rectangle(i*blockSize,j*blockSize,blockSize,blockSize));
				}
			}
		}

	}
	private void fillTopAndBottomBorders(){
		for(int i=0;i<gridWidth;i++){
			//Top
			grid[i][0]= new Wall( new Rectangle(i*blockSize,0*blockSize,blockSize,blockSize));

			//Bottom
			grid[i][gridHeight-1]=new Wall(new Rectangle(i*blockSize,(gridHeight-1)*blockSize,blockSize,blockSize));

		}
	}

	private void fillLeftAndRightBorders(){
		//we can over ride the blocks that are generated by fillTopAndBottomBorders() since they all get initialized to the same values either way
		for(int j=0;j<gridHeight;j++){
			//Left
			grid[0][j]= new Wall( new Rectangle(0*blockSize,j*blockSize,blockSize,blockSize));
			//Right
			grid[gridWidth-1][j]=new Wall(new Rectangle((gridWidth-1)*blockSize,j*blockSize,blockSize,blockSize));

		}
	}

	private void fillInnerGrid(){
		for(int i=0;i<gridWidth;i=i+2){
			for(int j=0;j<gridHeight;j+=2){
				grid[i][j]=new Wall( new Rectangle(i*blockSize,j*blockSize,blockSize,blockSize));
			}
		}

	}

	
	public void removeGameObject(GameObject obj){
		for (int i=0;i<gridWidth;i++){
			for(int j=0;j<gridHeight;j++){
				if(grid[i][j]==obj){
					grid[i][j]=null;
				}
			}
		}
		
	}
	
	public int getGridWidth(){
		return gridWidth;
	}
	public int getGridHeight(){
		return gridHeight;
	}


}



/*
public class World {
		public Rectangle[] blocks;
		public boolean[] isSolid;
		private Image[] blockImg;
		private Image BLOCK_HARD;
		public final int arrayNum=403;
		private int x,y,xDirection,yDirection,rowNumber;

		//Map navigation
		static final int PAN_UP=0, PAN_DOWN=1, PAN_LEFT=2, PAN_RIGHT=3;

		public World(){
			BLOCK_HARD=new ImageIcon("./src/gameplay/HardBlock.png").getImage();
			blocks= new Rectangle[403];
			isSolid=new boolean[403];
			blockImg=new Image[403];
			loadArrays();

		}


		private void loadArrays(){
			rowNumber=0;	

			for(int i = 0; i < arrayNum ;  i++ ){
				isSolid[i]=false;
				if(x>=992){
					x=0;
					y+=32;
					rowNumber++;
				}
				//set first row of blocks
				if (i<31){
					blockImg[i]=BLOCK_HARD;
					isSolid[i]=true;
				}
				if (i>371){
					blockImg[i]=BLOCK_HARD;
					isSolid[i]=true;
				}
				if (i%31==0){
					blockImg[i]=BLOCK_HARD;
					isSolid[i]=true;
				}
				if (i%31==30){
					blockImg[i]=BLOCK_HARD;
					isSolid[i]=true;
				}

				if ((i%2==0)&&(rowNumber%2==0)){
					blockImg[i]=BLOCK_HARD;
					isSolid[i]=true;
				}
				blocks[i] = new Rectangle(x,y,32,32);
				x+=32;
			}
		}

		public void draw(Graphics g){
			for(int i=0;i<arrayNum;i++){
				g.drawImage(blockImg[i], blocks[i].x, blocks[i].y, null);
			}
		}

		public void moveMap(){
			for(Rectangle r:blocks){
				r.x+=xDirection;
				r.y+=yDirection;
			}
		}
		public void stopMoveMap(){
			xDirection=0;
			yDirection=0;
		}

		private void setXDirection(int dir){
			xDirection=dir;

		}
		private void setYDirection(int dir){
			yDirection=dir;
		}
		public void navigateMap(int nav){
			switch(nav){
				default:
					System.out.println("default case entered");
					break;
				case PAN_UP:
					setYDirection(+1);
					break;
				case PAN_DOWN:
					setYDirection(-1);
					break;
				case PAN_LEFT:
					setXDirection(+1);
					break;
				case PAN_RIGHT:
					setXDirection(-1);
					break;				
			}
		}

}
 */
