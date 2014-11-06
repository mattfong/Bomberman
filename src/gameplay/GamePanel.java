package gameplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	int xCoord;
	int yCoord;
	
	private long period=6*1000000;
	//Double buffering
	private Image dbImage;
	private Graphics dbg;
	
	//Jpanel Variables
	//static final int GWIDTH=992,GHEIGHT=448;
	static final int GWIDTH=1500,GHEIGHT=1500;
	
	static final Dimension gameDim=new Dimension(GWIDTH,GHEIGHT);
	
	//Game variables
	
	private Thread game;
	private volatile boolean running=false;
	
	
	//GameObjects
	World world;
	Bomberman p1;
	
	public GamePanel(){
		
		setPreferredSize(gameDim);
		setFocusable(true);
		requestFocus();
		world=new World(31,13);
		p1=new Bomberman(world, new Rectangle(32,32,32,32));
		
		addKeyListener(new InputListener(p1));
		
	}
	
	public void run(){
		long beforeTime,afterTime,diff,sleepTime,overSleepTime=0;
		while(running){
			beforeTime=System.nanoTime();
			gameUpdate();
			gameRender();
			paintScreen();
			afterTime=System.nanoTime();
			diff=afterTime-beforeTime;
			sleepTime=(period-diff)-overSleepTime;
			if(sleepTime<period && sleepTime>0){
				
				try {
					game.sleep(sleepTime/1000000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				overSleepTime=diff-period;
			}
			
			
		}
	}
	
	private void gameUpdate(){
		if(running && game!=null){
			p1.update();
		}
		
	}
	
	private void gameRender(){
		if(dbImage==null){//create the buffer
			dbImage=createImage(GWIDTH,GHEIGHT);
			if(dbImage==null){
				System.err.println("dbImage is still null!");
				return;
			}
			else{
				dbg=dbImage.getGraphics();
			}
		}
		//clear the screen
		dbg.setColor(Color.GRAY);
		dbg.fillRect(0,0,GWIDTH,GHEIGHT);
		//Draw game elements
		draw(dbg);
	}
	
	/*draw all game stuff in here */
	public void draw(Graphics g){
		world.draw(g);
		p1.draw(g);
		
	}
	
	private void paintScreen(){
		Graphics g;
		try {
			g=this.getGraphics();
			if((dbImage!=null)&&(g!=null)){
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
