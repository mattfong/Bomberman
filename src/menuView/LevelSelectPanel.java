package menuView;

//import gameplay.Level;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version 1.7 (current version number of program)
 * @since 2014-12-1 (the version of the package this class was first added to)
 */
public class LevelSelectPanel extends JPanel{
	
	LevelSelectPanelLogic LSPL = new LevelSelectPanelLogic();
	
	private PanelTransitionManager manager = PanelTransitionManager.getInstance();
	
	public LevelSelectPanel() {
		initUI();
	}

	private void initUI() {
		setLayout(new GridLayout(5,1,5,10));
		
		int i =3;
	
		int counter, counterPlusOne;
		JButton[] buttons = new JButton[25];
		for(counter=0;counter<(buttons.length);counter++){
			counterPlusOne=(counter+1);
			buttons[counter]= new JButton("Level "+(counterPlusOne));
			if(LSPL.visable(i, counterPlusOne)){
				buttons[counter].setContentAreaFilled(true);
				buttons[counter].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("it's good");
					}
				});
				
			}
			else{
				buttons[counter].setContentAreaFilled(false);
				buttons[counter].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						LSPL.locked();
					}
				});
			}
			
			add(buttons[counter]);
			
		}
		
		JButton goBack = new JButton("Go back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//manager.displayPlayGameMenu(userName);
			}
		});
		
		
	}
}
