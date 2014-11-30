package menuView;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveGameMenuView extends JPanel{
	
//	private String saveGameNameText;
	private final JTextField saveGameNameField;
	
	public SaveGameMenuView() {
//		saveGameNameText = "";
		saveGameNameField= new JTextField(30);
		initUI();
	}
	
	private void initUI() {
		setLayout(new GridLayout(5,1,5,10));
		JLabel saveMenuLabel = new JLabel("Save Game Menu");
		saveMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		
		saveGameNameField.setText(null);
		
		JLabel saveGameNameLabel = new JLabel("Enter a name to save your game");
		JButton saveGameButton = new JButton("Save Game");
		JButton goBackButton = new JButton("goBack");
		
		
		saveGameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String saveGameNameText = saveGameNameField.getText();
//				frame.dispose();
			}
		});	
		
		goBackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
//				frame.dispose();
			}
		});	
		
		add(saveGameNameLabel);
		add(saveGameNameField);
		add(saveGameButton);
		add(goBackButton);
	}
}
