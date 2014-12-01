package gameplay.gameobject.powerups;

import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;
import gameplay.gameobject.bomberman.Bomberman;
import gameplay.gameobject.bomberman.BombermanInterface;
import gameplay.gameobject.enemies.Oneal;
import gameplay.world.World;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * 
 * Class implementing the door object.
 * 
 * @author MF
 *
 */
public class Door extends GameObject implements Powerup {

    private boolean isOpen;

    public Door(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Door.class.getResource("/ClosedDoor.jpg"));

	destroyable = false;
	solid = false;
	conductsExplosions = false;
	isOpen = false;
    }

    @Override
    public void update() {
	ArrayList<GameActor> actorList = world.getActorList();
	if (actorList.size() == 1 && (actorList.get(0) instanceof Bomberman)) {
	    isOpen = true;
	    sprite = new ImageIcon(Door.class.getResource("/OpenedDoor.jpg"));
	}

    }

    /**
     * @return true if the door is open, false if it's closed.
     */
    public boolean isOpen() {
	return isOpen;
    }

    @Override
    public void applyPowerup(BombermanInterface bomberman) {
	bomberman.moveToNextLevel();
    }

    @Override
    public void haveBeenBombed() {
	ArrayList<GameActor> actorList = new ArrayList<GameActor>();
	for (int i = 0; i < 5; i++) {
	    actorList.add(new Oneal(gridLocation, world));
	}
	world.spawnEnemies(actorList);

    }

}
