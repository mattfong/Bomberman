package gameplay;

/**
 * @author mfong8 Enum representing directions on the game board. Possible enums
 *         are RIGHT, LEFT, UP, DOWN.
 *
 */
public enum Direction {
    LEFT(-1, 0), RIGHT(1, 0), UP(0, 1), DOWN(0, -1);

    private int x;
    private int y;

    Direction(int x, int y) {
	this.x = x;
	this.y = y;
    }

    /**
     * returns an integer value which represents the direction on the x-axis
     * 
     * @return 1 if in positive x-direction, -1 if in negative x direction (left
     *         and right)
     */
    public int getX() {
	return x;
    }

    /**
     * @return 1 if in positive x-direction, -1 if in negative y direction (up
     *         and down).
     */
    public int getY() {
	return y;
    }

}
