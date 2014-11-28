package gameplay.gameobject;

import gameplay.World;
import gameplay.statemanagers.ScoreManager;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.ImageIcon;

public abstract class GameObject implements Serializable {
	
	private static final long serialVersionUID = -3547634888898588379L;
    protected final int pictureSize = 32;
    protected ScoreManager scoreManager;

    protected Rectangle gridLocation;
    protected World world;
    
    protected ImageIcon sprite;
    protected boolean solid;
    protected boolean destroyable;
    protected boolean conductsExplosions;
    protected int score;

    public int getScore() {
	return score;
    }

    public void setLocation(Rectangle location) {
	this.gridLocation = location;
    }

    public GameObject(Rectangle location, World world) {
	gridLocation = location;
	this.world = world;
	scoreManager = ScoreManager.getInstance();
    }

    // Game Engine related items
    /**
     * draws the object to the graphics object supplied.
     *
     * @param g
     *            Graphics object that will be drawn on.
     */
    public void draw(Graphics g) {

	g.drawImage(sprite.getImage(), gridLocation.x, gridLocation.y, null);
    }

    /**
     * Updates the model of the game object.
     */
    public void update() {

    }

    // Property Inquiries
    /**
     * @return true if the object can be destroyed, false if the object cannot be destroyed.
     */
    public boolean isDestroyable() {
	return destroyable;
    }

    /**
     * @return true if the object is solid, false if it's not.
     */
    public boolean isSolid() {
	return solid;
    }

    /**
     * Returns if the game object conducts explosions through it.
     *
     * @return a boolean true if explosions should pass through the object, false if object stops explosions.
     */
    public boolean conductsExplosions() {
	return conductsExplosions;
    }

    /**
     * Checks if the current gameobject has collided with another gameobject obj.
     *
     * @param obj
     *            -GameObject to check against
     * @return true if the instance collides with obj, false if they do not collide.
     */
    public boolean hasCollided(GameObject obj) {
	if (gridLocation.intersects(obj.getCollisionBoundaries())) {
	    return true;
	}
	return false;
    }

    /**
     * Method generates a rectangle which represents the collision boundaries of the instance of GameObject
     *
     * @return a Rectangle which represents the collision boundaries of the GameObject.
     */
    public Rectangle getCollisionBoundaries() {
	return new Rectangle(this.gridLocation.x, this.gridLocation.y, pictureSize, pictureSize);
    }

    /**
     * Method returns the location of this GameObject as a rectangle populated with the location and size of the gameobject.
     *
     * @return rectangle whose x and y are the same as the top left location of the game object and whose width and heigh as the same as the gameobject's sprite.
     */
    public Rectangle getLocation() {
	return new Rectangle(this.gridLocation.x, this.gridLocation.y, pictureSize, pictureSize);
    }

    // Changes in state
    /**
     * Method which removes GameObject instance from the gameboard.
     */
    public void destroy() {
	scoreManager.addToScore(score);
	world.removeGameObject(this);
    }

    // Getters and setters
    public int getXCoordinate() {
	return gridLocation.x;
    }

    public int getYCoordinate() {
	return gridLocation.y;
    }

    public void setXCoordinate(int newXCoord) {
	gridLocation.x = newXCoord;
    }

    public void setYCoordinate(int newYCoord) {
	gridLocation.y = newYCoord;
    }

    public int getWidth() {
	return pictureSize;
    }

    public int getHeight() {
	return pictureSize;
    }

}
