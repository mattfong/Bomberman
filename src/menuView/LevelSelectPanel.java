package menuView;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelSelectPanel extends JPanel{
	
	private PanelTransitionManager manager = PanelTransitionManager.getInstance();
	
	public LevelSelectPanel() {
		initUI();
	}

	private void initUI() {
		setLayout(new GridLayout(5,1,5,10));
		JButton level1 = new JButton("Level 1");
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
		level25.setOpaque(true);
		level24.setOpaque(false);
		level23.setContentAreaFilled(false);
		level22.setContentAreaFilled(true);
		
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
