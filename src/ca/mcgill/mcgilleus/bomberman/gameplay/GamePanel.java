package ca.mcgill.mcgilleus.bomberman.gameplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	private int boardSizeX;
	private int boardSizeY;
	private int viewSizeX;
	private int viewSizeY;
	int xCoord;
	int yCoord;
	

	
	//Double buffering
	private Image dbImage;
	private Graphics dbg;
	
	//Jpanel Variables
	static final int GWIDTH=480,GHEIGHT=416;
	static final Dimension gameDim=new Dimension(GWIDTH,GHEIGHT);
	
	//Game variables
	
	private Thread game;
	private volatile boolean running=false;
	
	
	//GameObjects
	World world;
	
	public GamePanel(){
		setPreferredSize(gameDim);
		setFocusable(true);
		requestFocus();
		world = new World();
		
		addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e){
				
			}
			@Override
			public void keyReleased(KeyEvent e){
				
			}
			@Override
			public void keyTyped(KeyEvent e){
				
			}
		});
		
	}
	
	public void run(){
		while(running){
			
			gameUpdate();
			gameRender();
			paintScreen();
			
			
		}
	}
	
	private void gameUpdate(){
		if(running && game!=null){
			//update game state
		}
		
	}
	
	private void gameRender(){
		if(dbImage==null){//create the buffer
			dbImage=createImage(GWIDTH,GHEIGHT);
				if(dbImage==null){
					System.err.println("dbImage is still null!");
					return;
				}else{
					dbg=dbImage.getGraphics();
				}
				//clear the screen
				dbg.setColor(Color.WHITE);
				dbg.fillRect(0,0,GWIDTH,GHEIGHT);
				//Draw game elements
				draw(dbg);
				
		}
	}
	
	/*draw all game stuff in here */
	public void draw(Graphics g){
		world.draw(g);
		
	}
	
	private void paintScreen(){
		Graphics g;
		try {
			g=this.getGraphics();
			if(dbImage!=null&g!=null){
				g.drawImage(dbImage, 0, 0, null);
			}
			Toolkit.getDefaultToolkit().sync();//for linux
			g.dispose();
			
			
		}catch(Exception e){
			System.err.println(e);
		}
		
		
	}
	
	
	
	public void addNotify(){
		super.addNotify();
		startGame();
		
	}
	
	private void startGame(){	
		if(game==null||!running){
			game=new Thread(this);
			game.start();
			running=true;
		}
	}
	
	public void stopGame(){
		if(running){
			running=false;
		}
		
	}
	
	
	
	
	
	
}
