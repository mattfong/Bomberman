package gameplay.gameobject.bomberman;

import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;
import gameplay.gameobject.blocks.Bomb;
import gameplay.gameobject.blocks.Brick;
import gameplay.gameobject.powerups.Door;
import gameplay.gameobject.powerups.Powerup;
import gameplay.input.CommandManager;
import gameplay.input.InputListener;
import gameplay.statemanagers.GameStateManager;
import gameplay.world.World;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * 
 * Class implementing Bomberman gameactor, uses BombermnaInterface to implement
 * all the behavior associated with bomberman.
 * 
 * @author MF
 */
public class Bomberman extends GameActor implements BombermanInterface {

    protected int bombLimit;
    protected boolean bombPass;
    protected boolean flamePass;
    protected boolean detonator;
    protected int explosionRadius;

    public Bomberman(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Bomberman.class.getResource("/Sprite.png"));
	inputManager = new CommandManager(this, InputListener.getInstance());
	bombPass = false;
	flamePass = false;
	detonator = false;
	explosionRadius = 1;
	bombLimit = 1;

    }

    /**
     * Overridden method which takes into account passing through bombs for
     * bomberman.
     */
    @Override
    public boolean canPassThrough(GameObject object) {
	if (object instanceof Brick) {
	    return wallPass;
	} else if (object instanceof Bomb) {
	    return bombPass;
	} else if (object.isSolid()) {
	    return false;
	}
	return true;

    }

    /**
     * places bomb at the location where Bomberman is standing.
     */
    @Override
    public void placeBomb() {

	if (!(world.getGameObjectInstanceAt(gridLocation) instanceof Bomb) && (Bomb.numberOfBombOnBoard() < bombLimit)) {
	    Bomb bomb = new Bomb(new Rectangle(gridLocation), this.world, this.explosionRadius);
	    // Bomb.addBomb(bomb); // This is the culprit if it all goes to
	    // shit...
	    world.addGameObject(bomb);

	}
    }

    private void checkForAndApplyPowerup() {

	GameObject checkObject = world.getGameObjectInstanceAt(this.getLocation());
	if ((checkObject instanceof Powerup) && !(checkObject instanceof Door)) {
	    Powerup bacon = (Powerup) world.getGameObjectInstanceAt(this.getLocation());
	    bacon.applyPowerup(this);
	    GameObject eggs = world.getGameObjectInstanceAt(this.getLocation());
	    eggs.destroy();
	}

    }

    private void checkForDoor() {
	GameObject checkObject = world.getGameObjectInstanceAt(this.getLocation());
	if (checkObject instanceof Door) {
	    if (((Door) checkObject).isOpen()) {
		((Door) checkObject).applyPowerup(this);
	    }
	}
    }

    @Override
    public int getBombLimit() {
	return bombLimit;
    }
    /**
     * checks if the GameActor has the ability to remote detonate and if true,
     * detonates the bombs in order that they are placed.
     */
    @Override
    public void detonateBomb() {

	if (detonator) {
	    Bomb.detonateBomb();
	}

    }

    @Override
    public void update() {
	inputManager.processCommand();
	checkForAndApplyPowerup();
	checkIfDead();
	checkForDoor();

    }

    private void checkIfDead() {
	ArrayList<GameActor> actorList = world.getActorList();
	for (GameActor actor : actorList) {
	    if (!(actor instanceof Bomberman)) {
		if (actor.hasCollided(this)) {
		    if (GameStateManager.getInstance().getCurrentGameState().getRemainingLives() > 0) {
			respawn();
		    } else {
			isDead = true;
		    }
		}
	    }
	}

	if (checkIfBombed()) {
	    if (flamePass) { // oh hello there bomberman, i see you
			     // are surounded by bombs Schönling. I
		// sure hope that you can.... TAKE THE
		// HEAT

	    } else {
		if (GameStateManager.getInstance().getCurrentGameState().getRemainingLives() > 0) {
		    respawn();
		} else {
		    isDead = true;
		}
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

    private void respawn() {
	bombPass = false;
	wallPass = false;
	wallPass = false;
	detonator = false;
	gridLocation.x = 32;
	gridLocation.y = 32;
	GameStateManager.getInstance().getCurrentGameState().decreaseRemainingLives();

    }

    @Override
    public void moveToNextLevel() {
	Bomb.resetBombList(); // reset bomb list to avoid 'leaving; bombs behind
	gridLocation.x = 32;
	gridLocation.y = 32;
	world.loadNextLevel();

    }

    @Override
    public void die() {
	if (GameStateManager.getInstance().getCurrentGameState().getRemainingLives() > 0) {
	    respawn();
	} else {
	    isDead = true;
	}
    }

    @Override
    public void increaseMoveSpeed() {
	InputListener.getInstance().increaseQuerySpeed();
    }

    @Override
    public int getBombRadius() {
	return explosionRadius;
    }

}
