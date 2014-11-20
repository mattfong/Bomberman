package gameplay.gameobject;

import gameplay.World;
import gameplay.gameobject.blocks.Bomb;
import gameplay.input.CommandManager;
import gameplay.input.InputListener;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;

public class Bomberman extends GameActor {

    Queue<Bomb> bombList = new LinkedList<Bomb>();
    CommandManager inputManager;

    public Bomberman(World world, Rectangle location) {
	super(location, world);
	sprite = new ImageIcon(Bomberman.class.getResource("/Sprite.png")).getImage();
	inputManager = new CommandManager(this, InputListener.getInstance());

    }

    @Override
    public void update() {
	inputManager.processCommand();
    }

    /**
     * places bomb at the location where bomberman is standing.
     */
    public void placeBomb() {

	Bomb bomb = new Bomb(new Rectangle(gridLocation), this.world, this.explosionRadius);
	bombList.add(bomb);
	world.addGameObject(bomb);

    }

    /**
     * checks if the GameActor has the ability to remote detonate and if true,
     * detonates the boms in order that they are placed.
     */
    public void detonateBomb() {

	Bomb bomb;
	bomb = bombList.poll();

	if (bomb != null) {
	    bomb.explode();
	}

    }

}
