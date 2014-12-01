package gameplay.gameobject.bomberman;

/**
 * Interface which characterizes all of bomberman's functionality.
 * 
 * @author MF
 */

public interface BombermanInterface {

    /**
     * @return true if Bomberman can remotely detonate bombs else false.
     */
    public boolean canDetonateBomb();

    /**
     * @return true if Bomberman can pass through bombs, else fase.
     */
    public boolean canBombPass();

    /**
     * Increases bomberman's bomb explosion radius by 1 block.
     */
    public void increaseExplosionRadius();

    /**
     * Increases bomberman's bomb limit by 1.
     */
    public void increaseBombLimit();

    /**
     * @return true if bomberman is immune to bomb fire, else false.
     */
    public boolean canTakeTheHeat();

    /**
     * Set Bombermna's ability to pass through walls.
     * 
     * @param wallPass
     *            boolean of true or false.
     */
    public void setWallPass(boolean wallPass);

    /**
     * Set bomberman's ability to pass through bombs
     * 
     * @param bombPass
     *            true or false
     */
    public void setBombPass(boolean bombPass);

    /**
     * Set bomberman's ability to pass through fire
     * 
     * @param flamePass
     */
    public void setFlamePass(boolean flamePass);

    /**
     * Set if bombermna has a remote detonator.
     * 
     * @param detonator
     */
    public void setDetonator(boolean detonator);

    /**
     * Places a bomb on the game map at Bombermna's feet
     */
    public void placeBomb();

    /**
     * Detonates the oldest bomb on the board if bomberman has the detonator
     * powerup.
     */
    public void detonateBomb();

    /**
     * Bomberman triggers a movement to the next level, this method is a wrapper
     * for the method on the world class
     */
    public void moveToNextLevel();

    /**
     * Causes bomberman to die when called, reduces bomberman's lives by 1 and
     * respawns him/
     */
    public void die();

    /**
     * increase the speed at which bomberman moves by a given amount.
     */
    public void increaseMoveSpeed();

}
