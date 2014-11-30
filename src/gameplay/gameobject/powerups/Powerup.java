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

    public void haveBeenBombed();

}
