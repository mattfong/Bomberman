package gameplay.input;

import java.io.Serializable;

/**
 * @author MF Common interface to be shared across all classes that issues
 *         commands.
 */
public interface CommandIssuer extends Serializable {
    Command getCommand();
}
