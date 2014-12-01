package gameplay.input.commandobjects;

import java.io.Serializable;

/**
 * Common interface to be shared across all classes that issues commands.
 * 
 * @author MF
 */
public interface CommandIssuer extends Serializable {
    Command getCommand();
}
