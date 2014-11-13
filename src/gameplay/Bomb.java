package gameplay;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Bomb extends GameObject implements ActionListener{
	private boolean isSolid;
	private int explosionRadius;
	private Timer bombTimer;
	private final int countdownTimer=3000;//in miliseconds
	
	public Bomb(Rectangle location, World world){
		super(location); 
		isSolid=true;
		this.world=world;
		sprite=new ImageIcon(Bomb.class.getResource("/BombSprite.png")).getImage();
		bombTimer=new Timer(countdownTimer,this);
		bombTimer.start();
		
	}
	
	public void explode(){
		remove();
		
	}
	
	public void actionPerformed(ActionEvent e){
		this.explode();
	}
	
}
