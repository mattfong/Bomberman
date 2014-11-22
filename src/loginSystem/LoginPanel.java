package loginSystem;

import java.awt.Dimension;
import javax.swing.JPanel;

public class LoginPanel extends JPanel{

	static final int GWIDTH = 992, GHEIGHT = 448;

    static final Dimension gameDim = new Dimension(GWIDTH, GHEIGHT);
    public LoginPanel(){
    	setPreferredSize(gameDim);
		setFocusable(true);
    }
    
    
}
