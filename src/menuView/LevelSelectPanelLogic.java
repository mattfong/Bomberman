package menuView;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version 1.7 (current version number of program)
 * @since 2014-12-1 (the version of the package this class was first added to)
 */
public class LevelSelectPanelLogic {
	 private static JFrame controllingFrame;
	
	 public boolean visable(int levelsUnlocked, int thisLevel){
		 if(thisLevel>levelsUnlocked)
			 return false;
		 return true;
	 }
	 
	public void play(int level ){
		System.out.println(level);
	}
	 
	 public void locked(){
		JOptionPane.showMessageDialog(controllingFrame,
                "This level is locked");
	}
	
	 

}
