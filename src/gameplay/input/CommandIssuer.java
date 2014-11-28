package gameplay.input;

import java.io.Serializable;

public interface CommandIssuer extends Serializable{
	Command getCommand();
}
