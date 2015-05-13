package com.amo11k.Snake;

import javax.swing.Timer;

public class Food {
	private int row;
	private int col;
	private boolean special;
	private final long VISIBLE_TIME = 10;
	private Timer timerFood;

	private int random;

	public Food() {
		this.col = (int) (Math.random() * Board.COLS-1);
		this.row = (int) (Math.random() * Board.ROWS-1);

		random = (int) (Math.random() * 10);
		if ((random == 1) || (random == 0 || (random == 2))) {
			special = true;
		} else {
			special = false;
		}
		
	}

	public int getFoodRow() {
		return row;

	}

	public int getFoodCol() {
		return col;

	}

	public boolean isSpecial() {
		return special;
	}
}
