package gameplay.gameobject.powerups;

import gameplay.World;
import gameplay.gameobject.Bomberman;
import gameplay.gameobject.BombermanInterface;
import gameplay.gameobject.GameActor;
import gameplay.gameobject.GameObject;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Door extends GameObject implements Powerup {

    private boolean isOpen;

    public Door(Rectangle location, World world) {
	super(location, world);
	sprite = new ImageIcon(Door.class.getResource("/ClosedDoor.jpg"));

	destroyable = true;
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

    public boolean isOpen() {
	return isOpen;
    }

    @Override
    public void applyPowerup(BombermanInterface bomberman) {
	bomberman.moveToNextLevel();
    }

    @Override
    public void haveBeenBombed() {
	// TODO Auto-generated method stub

    }

}
