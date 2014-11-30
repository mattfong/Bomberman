package gameplay.overlays;

import gameplay.World;
import gameplay.gameobject.Bomberman;

import java.io.Serializable;

public class CountdownTimer implements Serializable {

    // private transient Timer timer;
    // Timer timer;
    int countdown;
    private World world;
    private int frameRate = 25;// 25 frames per second, shoud match the frame
			       // rate in the gamepanel engine
    private int counter;

    public int getcountdown() {
	return countdown;
    }

    public CountdownTimer(World world) {
	countdown = 200;
	this.world = world;
	// timer = new Timer(1000, this);
	// timer.start();
	counter = 0;
    }

    public void update() {
	counter++;
	if ((counter % frameRate) == 0) {
	    countdown--;
	    if (countdown == 0) {
		if (world != null) {
		    Bomberman bomberman = (Bomberman) world.getBomberman();
		    bomberman.die();
		}
		countdown = 200;
	    }
	    counter = 0;
	}
    }

    /**
     * Resets the gametimer back to 200 seconds
     */
    public void reset() {
	countdown = 200;
    }

}
