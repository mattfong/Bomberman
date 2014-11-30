package gameplay.ai;

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