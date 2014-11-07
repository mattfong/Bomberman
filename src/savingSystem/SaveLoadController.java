package savingSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SaveLoadController {

	public static void displaySaveLoadView() {
		
		final JFrame frame = new JFrame("Load and Save Menu Options");
		frame.setVisible(true);
	    frame.setSize(400, 400);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new GridLayout(2,1));
	    
	    JButton save = new JButton("Save Game");
	    frame.add(save);
	    save.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			//Save Game Menu View	
			}
			
		});	
	    
	    JButton load = new JButton("Load Game");
	    frame.add(load);
	    load.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			//Load Game Menu View	
			}
			
		});	
	}
	
	
	public static void displaySaveGameMenu(){
		
	}
	
	public static void displayLoadGameMenu(){
		
	}
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displaySaveLoadView();
	}*/
}
