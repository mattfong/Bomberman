package menuView;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LevelSelectPanelLogic {
	 private static JFrame controllingFrame;
	
	 public boolean visable(int levelsUnlocked, int thisLevel){
		 if(thisLevel>levelsUnlocked)
			 return false;
		 return true;
	 }
	 
	//public void center(String )
	 
	 public void locked(){
		JOptionPane.showMessageDialog(controllingFrame,
                "This level is locked");
	}
	
	//public 

}
