package gameplay.gameobject;

public interface BombermanInterface {

    public boolean canDetonateBomb();

    public boolean canBombPass();

    public void increaseExplosionRadius();

    public void increaseBombLimit();

    public boolean canTakeTheHeat();

    public void setWallPass(boolean wallPass);

    public void setBombPass(boolean bombPass);

    public void setFlamePass(boolean flamePass);

    public void setDetonator(boolean detonator);

    public void placeBomb();

    public void detonateBomb();

    public void respawn();

    public void moveToNextLevel();

}
