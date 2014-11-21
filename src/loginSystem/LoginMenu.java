package loginSystem;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginMenu {
	JTextField jt= new JTextField(30);
	JPasswordField pf = new JPasswordField(30);
	private JFrame controllingFrame;
	LoginPanel panel = new LoginPanel();

	
	public void loginMenuWindow(final JFrame frame){
		jt.setText(null);
		pf.setText(null);
		panel.setLayout(new GridLayout(7,1,5,10));
		
		JLabel enterUser = new JLabel("If you have an account enter your username enter it here");
		JLabel enterPass = new JLabel("If you have an account enter your Password here");
		
		JButton login = new JButton("To Login click here");
		JButton newUser = new JButton("IF you do not have an account click here to create one");
		JButton deleteUser = new JButton("To delete your Account click here");
		
		newUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				panel.revalidate();
				panel.validate();
				panel.repaint();
	            panel.removeAll();
				
				//frame.remove(panel);
		        //frame.revalidate();
		        //frame.validate();
		        //frame.removeAll();
		        newAccount.main(null, frame);	
			}
			
		});	
		
		deleteUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				//frame.remove(panel);
		        //frame.revalidate();
		        //frame.validate();
		        //frame.removeAll();
				panel.revalidate();
				panel.validate();
				panel.repaint();
	            panel.removeAll();
		        deleteAccount.main(null, frame);	
			}
			
		});	
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					if(CSVreader.checkUser(jt.getText(), pf.getText())==true){
						//frame.remove(panel);
				        //frame.revalidate();
				        //frame.validate();
				        //frame.removeAll();
						//PlayGame.playMenu();
						panel.revalidate();
						panel.validate();
						panel.repaint();
			            panel.removeAll();
						PlayGame.main(null, frame);
						System.out.println("Username entered correctly");
					}
					else{
						 JOptionPane.showMessageDialog(controllingFrame,
					                "Wrong username or password");
						 jt.setText(null);
						 pf.setText(null);
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
			}
		});	
		
		
		panel.add(enterUser);
		panel.add(jt);
		panel.add(enterPass);
		panel.add(pf);
		panel.add(login);
		panel.add(newUser);
		panel.add(deleteUser);
		frame.add(panel);
		System.out.println("all is well in the loginMenu");
		System.out.println("breakpooint here");
	}
	
	public static void main(String[] args, JFrame frame){
		LoginMenu nonStaticLM = new LoginMenu();
		nonStaticLM.loginMenuWindow(frame);
	}
}
