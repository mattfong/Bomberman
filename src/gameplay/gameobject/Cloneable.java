package gameplay.gameobject;

import java.awt.Rectangle;

public interface Cloneable {

    abstract GameActor clone(Rectangle location);
}
