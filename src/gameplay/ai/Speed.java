package gameplay.ai;

/**
 * Enum containing the speed at which the AI will return commands.
 * 
 * @author MF
 *
 */
public enum Speed {
    SLOW(
	    15),
    NORMAL(
	    10),
    FAST(
	    5);

    private int querySpeed;

    Speed(int querySpeed) {
	this.querySpeed = querySpeed;
    }

    public int getSpeed() {
	return querySpeed;
    }
}