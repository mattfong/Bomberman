package menuView;

import gameplay.Level;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelSelectPanel extends JPanel{
	
	LevelSelectPanelLogic LSPL = new LevelSelectPanelLogic();
	
	private PanelTransitionManager manager = PanelTransitionManager.getInstance();
	
	public LevelSelectPanel() {
		initUI();
	}

	private void initUI() {
		setLayout(new GridLayout(5,1,5,10));
		
		int i =3;
		
		JButton level1 = new JButton("Level 1");
		level1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//GameStateManager manager = GameStateManager.getInstance();
				//GameState state = manager.getCurrentGameState();
				//state.setLevel(Level.L1);
			}
		});
		JButton level2 = new JButton("Level 2");
		
		JButton level3 = new JButton("Level 3");
		
		JButton level4 = new JButton("Level 4");
		
		JButton level5 = new JButton("Level 5");
		
		JButton level6 = new JButton("Level 6");
		
		JButton level7 = new JButton("Level 7");
		
		JButton level8 = new JButton("Level 8");
		JButton level9 = new JButton("Level 9");
		JButton level10 = new JButton("Level 10");
		JButton level11 = new JButton("Level 11");
		JButton level12 = new JButton("Level 12");
		JButton level13 = new JButton("Level 13");
		JButton level14 = new JButton("Level 14");
		JButton level15 = new JButton("Level 15");
		JButton level16 = new JButton("Level 16");
		JButton level17 = new JButton("Level 17");
		JButton level18 = new JButton("Level 18");
		JButton level19 = new JButton("Level 19");
		JButton level20 = new JButton("Level 20");
		JButton level21 = new JButton("Level 21");
		JButton level22 = new JButton("Level 22");
		JButton level23 = new JButton("Level 23");
		JButton level24 = new JButton("Level 24");
		JButton level25 = new JButton("Level 25");
		int k;
		JButton[] buttons = new JButton[25];
		for(k=1;k<(buttons.length+1);k++){
			buttons[k]= new JButton("Level "+k);
			if(LSPL.visable(i, k)){
				level2.setContentAreaFilled(true);
				level2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("it's good");
					}
				});
				
			}
			else{
				level2.setContentAreaFilled(false);
				level2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						LSPL.locked();
					}
				});
			}
			
			add(buttons[k]);
			
		}
		
		if(LSPL.visable(i, 2)){
			level2.setContentAreaFilled(false);
			level2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LSPL.locked();
				}
			});
		}
		else{
			level2.setContentAreaFilled(true);
			level2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("it's good");
				}
			});
		}
		
		
		
		if(LSPL.visable(i, 3)){
			level3.setContentAreaFilled(false);
			level3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LSPL.locked();
				}
			});
		}
		else{
			level3.setContentAreaFilled(true);
			level3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("it's good3");
				}
			});
		}
		
		if(LSPL.visable(i, 4)){
			level4.setContentAreaFilled(false);
			level4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LSPL.locked();
				}});
		}else{
			level4.setContentAreaFilled(true);
			level4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("it's good4");
				}});
		}
		
		if(LSPL.visable(i, 5)){
			level5.setContentAreaFilled(false);
			level5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LSPL.locked();
				}});
		}else{
			level5.setContentAreaFilled(true);
			level5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("it's good5");
				}});
		}
		
		if(LSPL.visable(i, 6)){
			level6.setContentAreaFilled(false);
			level6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LSPL.locked();
				}});
		}else{
			level6.setContentAreaFilled(true);
			level6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("it's good6");
				}});
		}
		
		if(LSPL.visable(i, 7)){
			level7.setContentAreaFilled(false);
			level7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LSPL.locked();
				}});
		}else{
			level7.setContentAreaFilled(true);
			level7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("it's good7");
				}});
		}
		
		if(LSPL.visable(i, 8)){
			level8.setContentAreaFilled(false);
			level8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LSPL.locked();
				}});
		}else{
			level8.setContentAreaFilled(true);
			level8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("it's good8");
				}});
		}
		
		
		level23.setContentAreaFilled(false);
		
		add(level1);
		add(level2);
		add(level3);
		add(level4);
		add(level5);
		add(level6);
		add(level7);
		add(level8);
		add(level9);
		add(level10);
		add(level11);
		add(level12);
		add(level13);
		add(level14);
		add(level15);
		add(level16);
		add(level17);
		add(level18);
		add(level19);
		add(level20);
		add(level21);
		add(level22);
		add(level23);
		add(level24);
		add(level25);
		
	}
}
