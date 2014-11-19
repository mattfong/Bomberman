package gameplay.powerups;

import gameplay.gameobject.GameActor;

/**
 * @author mfong8 Interface which defines the behvariour of a powerup
 */
public interface Powerup {

    /**
     * applies the powerup's effect onto the given gameactor.
     * 
     * @param actor
     *            actor on which the powerup will be applied to.
     */
    public void applyPowerup(GameActor actor);

}
