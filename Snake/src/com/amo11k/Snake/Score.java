package com.amo11k.Snake;

import javax.swing.JPanel;

public class Score extends JPanel {
	protected static int score = 0;
	public JPanel scorePan;

	public Score() {
		score = 0;
	}

	public static String incrementScore() {
		String s = null;
		score += 100;
		s = Integer.toString(score);
		return s;
	}
	
	public static String incrementSpecialScore() {
		String s = null;
		score += 500;
		s = Integer.toString(score);
		return s;
	}

}
