package gameplay.overlays;

import gameplay.gameobject.GameActor;

public class Camera {
    private int x;
    private final int y = 0;
    private GameActor bomberman;

    public Camera(int x, GameActor bomberman) {
	this.bomberman = bomberman;
	this.x = x;
    }

    /**
     * @return the x value
     */
    public int getX() {
	return x;
    }

    public void update() {

	if (bomberman.getXCoordinate() > (6 * 32) && bomberman.getXCoordinate() < (24 * 32)) {
	    x = -bomberman.getXCoordinate() + (7 * 32);
	}
    }

    public int getY() {
	return y;
    }
}