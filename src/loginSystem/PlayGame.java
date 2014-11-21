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
	//LoginFrame frame = new LoginFrame();
	
	public void notYet(final JFrame frame)
	{
		panel.setLayout(new GridLayout(2,1,5,10));
		JLabel myLabel = new JLabel("This feature is not avalibe yet");
		myLabel.setVisible(true);
		JButton goBack = new JButton("Go back to the Play menu");
		goBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				panel.revalidate();
				panel.validate();
				panel.repaint();
	            panel.removeAll();
				playMenu(frame);	
			}
		});	
		panel.add(myLabel);
		panel.add(goBack);
		frame.add(panel);
		
		
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
				panel.revalidate();
				panel.validate();
				panel.repaint();
	            panel.removeAll();
				notYet(frame);	
			}
		});	
		
		JButton high =new JButton("High Scores");
		
		high.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				panel.revalidate();
				panel.validate();
				panel.repaint();
	            panel.removeAll();
				frame.dispose();
				//notYet();	
				HighScoreController.displayHighScore();
			}
		});	
		
		JButton logOut =new JButton("Log Out"); 
		
		logOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {	
				panel.revalidate();
				panel.validate();
				panel.repaint();
	            panel.removeAll();
				LoginMenu.main(null, frame);
			
			}
		});	
		
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(play);
		panel.add(saved);
		panel.add(high);
		panel.add(logOut);
		frame.add(panel);
		
		System.out.println("All play menu completed");
		
		
		System.out.println("we good");
		
	}
	
	public static void main(String[] args, JFrame frame){
		PlayGame nonStatic = new PlayGame();
		nonStatic.playMenu(frame);
	}
	 
}
