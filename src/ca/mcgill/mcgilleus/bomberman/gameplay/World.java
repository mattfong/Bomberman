//TODO migrate this stuff to the board class and whereever this stupid stuff neeeds to go

package ca.mcgill.mcgilleus.bomberman.gameplay;



import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;



public class World {
		private Rectangle[] blocks;
		private Image[] blockImg;
		private Image BLOCK_HARD;
		private final int arrayNum=195;
		private int x,y;
		
		
		public World(){
			BLOCK_HARD=new ImageIcon("C:/Users/MF/Documents/GitHub/Team-7/src/ca/mcgill/mcgilleus/bomberman/gameplay/HardBlock.png").getImage();
			blocks= new Rectangle[195];
			blockImg=new Image[195];
			loadArrays();
			
		}
		
		
		private void loadArrays(){
				
			
			for(int i = 0; i < arrayNum ;  i++ ){
				if(x>=480){
					x=0;
					y+=32;
				}
				
				blockImg[i]=BLOCK_HARD;
				blocks[i] = new Rectangle(x,y,32,32);
				x+=32;
			}
		}
		public void draw(Graphics g){
			for(int i=0;i<arrayNum;i++){
				g.drawImage(blockImg[i], blocks[i].x, blocks[i].y, null);

			}
		}
}
