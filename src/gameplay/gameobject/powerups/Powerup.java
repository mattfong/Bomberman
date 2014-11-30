package gameplay.gameobject.powerups;

import gameplay.gameobject.BombermanInterface;

/**
 * @author mfong8 Interface which defines the behavior of a powerup
 */
public interface Powerup {

    /**
     * applies the powerup's effect onto the given gameactor.
     *
     * @param bomberman
     *            actor on which the powerup will be applied to.
     */
    public void applyPowerup(BombermanInterface bomberman);

    /**
     * Method that is called to inform the powerup that it's been bombed.
     */
    public void haveBeenBombed();

}
