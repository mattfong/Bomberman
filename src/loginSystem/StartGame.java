package loginSystem;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTextField;



public class StartGame {
		
	private static Color bgColor = Color.YELLOW;
	
	public static void main(String[] args)
	{
		
		
		final JFrame frame=new JFrame("Bomberman");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);
		
		
		JPanel panel = new JPanel();
		//frame.setBackground(Color.BLUE);
		frame.setBackground(Color.red);
		
		panel.setLayout(new GridLayout(2,1,5,10));
		JButton play =new JButton("Play Game");
		JLabel enterUser = new JLabel("Start the game!");
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {		
				frame.dispose();
				LoginMenu.loginMenu();	
			}
		});	
		panel.add(enterUser);
		panel.add(play);
		frame.add(panel);
	}
}
