package gameplay.gameobject;

import gameplay.World;
import gameplay.gameobject.blocks.Bomb;
import gameplay.input.CommandManager;
import gameplay.input.InputListener;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;

public class Bomberman extends GameActor implements BombermanInterface {

    Queue<Bomb> bombList = new LinkedList<Bomb>();
    CommandManager inputManager;
    protected int bombLimit;
    protected boolean bombPass;
    protected boolean flamePass;
    protected boolean detonator;
    protected int explosionRadius;

    public Bomberman(World world, Rectangle location) {
	super(location, world);
	sprite = new ImageIcon(Bomberman.class.getResource("/Sprite.png")).getImage();
	inputManager = new CommandManager(this, InputListener.getInstance());
	bombPass = false;
	flamePass = false;
	detonator = false;
	explosionRadius = 3;
    }

    @Override
    public void update() {
	inputManager.processCommand();
    }

    /**
     * places bomb at the location where bomberman is standing.
     */
    @Override
    public void placeBomb() {

	Bomb bomb = new Bomb(new Rectangle(gridLocation), this.world, this.explosionRadius);
	bombList.add(bomb);
	world.addGameObject(bomb);

    }

    /**
     * checks if the GameActor has the ability to remote detonate and if true,
     * detonates the boms in order that they are placed.
     */
    @Override
    public void detonateBomb() {

	Bomb bomb;
	bomb = bombList.poll();

	if (bomb != null) {
	    bomb.explode();
	}

    }

    @Override
    public boolean canBombPass() {
	return bombPass;
    }

    /**
     * Increase the explosion radius of the bombs placed by 1.
     */
    @Override
    public void increaseExplosionRadius() {
	this.explosionRadius++;
    }

    /**
     * Increases the amount of bombs that can be placed on the board at a given
     * time by 1.
     */
    @Override
    public void increaseBombLimit() {
	this.bombLimit++;
    }

    /**
     * returns if the gameactor is immune to bomb fire.
     *
     * @return true if the actor can "take the heat", false if he turns into
     *         jerky.
     */
    @Override
    public boolean canTakeTheHeat() {
	return flamePass;
    }

    @Override
    public void setWallPass(boolean wallPass) {
	this.wallPass = wallPass;
    }

    @Override
    public void setBombPass(boolean bombPass) {
	this.bombPass = bombPass;
    }

    @Override
    public void setFlamePass(boolean flamePass) {
	this.flamePass = flamePass;
    }

    @Override
    public void setDetonator(boolean detonator) {
	this.detonator = detonator;
    }

    /**
     * @return true if the GameActor can detonate bombs.
     */
    @Override
    public boolean canDetonateBomb() {
	return detonator;

    }

}
