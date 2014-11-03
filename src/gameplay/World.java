//TODO migrate this stuff to the board class and whereever this stupid stuff neeeds to go

package gameplay;



import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Arrays;

import javax.swing.ImageIcon;



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
