package gameplay.gameobject;

import gameplay.World;
import gameplay.input.CommandManager;
import gameplay.input.InputListener;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;

public class Bomberman extends GameActor{
	
	Queue<Bomb> bombList= new LinkedList<Bomb>();
	CommandManager inputManager;
	
	public Bomberman (World world, Rectangle location){
		super(location, world);
		sprite=new ImageIcon(Bomberman.class.getResource("/Sprite.png")).getImage();
		inputManager= new CommandManager(this,InputListener.getInstance());

	}
	
	public void update(){
		inputManager.processCommand();
	}


	public void placeBomb(){
		Bomb bomb=new Bomb( new Rectangle(gridLocation),this.world, this.explosionRadius);
		bombList.add(bomb);
		world.addGameObject(bomb);
	}
	
	public void detonateBomb(){
		Bomb bomb;
		bomb=bombList.poll();
		
		if(bomb!=null){
			bomb.explode();
		}
	}
	
	

}
