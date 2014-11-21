package loginSystem;
import gameplay.GameFrame;
import highscore.HighScoreController;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PlayGame {
	
	LoginPanel panel = new LoginPanel();
	LoginPanel panel1 = new LoginPanel();
	LoginPanel parentPanel = new LoginPanel();
	//LoginFrame frame = new LoginFrame();
	
	public void notYet(final JFrame frame)
	{
		panel1.setLayout(new GridLayout(2,1,5,10));
		JLabel myLabel = new JLabel("This feature is not avalibe yet");
		myLabel.setVisible(true);
		JButton goBack = new JButton("Go back to the Play menu");
		goBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				parentPanel.remove(panel);
				parentPanel.repaint();
	            parentPanel.removeAll();
	            
	            panel1.repaint();
	            panel1.removeAll();
				playMenu(frame);	
			}
		});	
		panel1.add(myLabel);
		panel1.add(goBack);
		parentPanel.add(panel1);
		frame.add(parentPanel);
		
		
	}
	
	
	public void playMenu(final JFrame frame)
	{
		panel.setLayout(new GridLayout(4,1,5,10));
		JButton play =new JButton("Play Game");

		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("New Game Frame");
				GameFrame gameplay=new GameFrame();
				gameplay.setVisible(true);
				frame.dispose();
			}
		});		
		
		JButton saved =new JButton("Load Saved game"); 
		
		saved.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				parentPanel.remove(panel);
				parentPanel.revalidate();
				parentPanel.validate();
				parentPanel.repaint();
	            parentPanel.removeAll();
				notYet(frame);	
			}
		});	
		
		JButton high =new JButton("High Scores");
		
		high.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				//notYet();	
				HighScoreController.displayHighScore();
			}
		});	
		
		JButton logOut =new JButton("Log Out"); 
		
		logOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				//LoginMenu.loginMenu();	
				LoginMenu.main(null, frame);
			
			}
		});	
		
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(play);
		panel.add(saved);
		panel.add(high);
		panel.add(logOut);
		parentPanel.add(panel);
		frame.add(parentPanel);
	}
	
	public static void main(String[] args, JFrame frame){
		PlayGame nonStatic = new PlayGame();
		nonStatic.playMenu(frame);
	}
	 
}
