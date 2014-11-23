package gameplay.gameobject;

import gameplay.World;
import gameplay.gameobject.blocks.Bomb;
import gameplay.input.CommandManager;
import gameplay.input.InputListener;
import gameplay.statemanagers.GameStateManager;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;

public class Bomberman extends GameActor implements BombermanInterface {

    Queue<Bomb> bombList = new LinkedList<Bomb>();

    protected int bombLimit;
    protected boolean bombPass;
    protected boolean flamePass;
    protected boolean detonator;
    protected int explosionRadius;

    private GameStateManager gameStateManager;

    public Bomberman(World world, Rectangle location) {
	super(location, world);
	sprite = new ImageIcon(Bomberman.class.getResource("/Sprite.png")).getImage();
	inputManager = new CommandManager(this, InputListener.getInstance());
	bombPass = false;
	flamePass = false;
	detonator = false;
	explosionRadius = 1;
	bombLimit = 1;
	gameStateManager = GameStateManager.getInstance();
    }

    /**
     * places bomb at the location where Bomberman is standing.
     */
    @Override
    public void placeBomb() {

	if (!(world.getGameObjectInstanceAt(gridLocation) instanceof Bomb) && (world.numberOfBombsOnMap() < bombLimit)) {
	    Bomb bomb = new Bomb(new Rectangle(gridLocation), this.world, this.explosionRadius);
	    bombList.add(bomb);
	    world.addGameObject(bomb);
	}
    }

    /**
     * checks if the GameActor has the ability to remote detonate and if true,
     * detonates the bombs in order that they are placed.
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
    public void update() {
	inputManager.processCommand();
	if (checkIfBombed()) {
	    if (gameStateManager.getCurrentGameState().getRemainingLives() > 0) {
		respawn();
	    } else {
		isDead = true;
	    }
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

    @Override
    public void respawn() {
	bombPass = false;
	wallPass = false;
	wallPass = false;
	detonator = false;
	gridLocation.x = 32;
	gridLocation.y = 32;
	gameStateManager.getCurrentGameState().decreaseRemainingLives();

    }

}
