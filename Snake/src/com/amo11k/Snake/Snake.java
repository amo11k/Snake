package com.amo11k.Snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Snake {
	private static ArrayList<Node> snake;
	Direction direction;

	private int count = 0;
	protected static int tailLenght = 5;
	private Graphics g;
	private Random random;
	private int col, row;
	static int lenght;

	public Snake() {
		this.snake = new ArrayList<>();
		snake.add(new Node(5, 5));
	}

	public ArrayList<Node> getArray() {
		return snake;
	}

	public void move(Direction dir) {
		int last;

		switch (dir) {
		case UP:
			row = getHeadRow();
			col = getHeadCol();
			if (snake.get(0).getNodeRow() <= 1) {
				Board.GOver = true;
			}
			snake.add(0, new Node(row - 1, col));
			if (Board.come) {

			} else {
				last = snake.size() - 1;
				snake.remove(last);
			}

			break;
		case DOWN:
			if (snake.get(0).getNodeRow() >= 50) {
				Board.GOver = true;
			}
			row = getHeadRow();
			col = getHeadCol();
			snake.add(0, new Node(row + 1, col));
			if (Board.come) {

			} else {
				last = snake.size() - 1;
				snake.remove(last);
			}
			break;
		case RIGHT:
			if (snake.get(0).getNodeCol() >= 50) {
				Board.GOver = true;
			}
			row = getHeadRow();
			col = getHeadCol();
			snake.add(0, new Node(row, col + 1));
			if (Board.come) {

			} else {
				last = snake.size() - 1;
				snake.remove(last);
			}
			break;
		case LEFT:
			if (snake.get(0).getNodeCol() <= 1) {
				Board.GOver = true;
			}
			row = getHeadRow();
			col = getHeadCol();
			snake.add(0, new Node(row, col - 1));
			if (Board.come) {

			} else {
				last = snake.size() - 1;
				snake.remove(last);
			}
			break;
		default:
			break;
		}
	}

	public int getHeadCol() {
		return snake.get(0).getNodeCol();
	}

	public int getHeadRow() {
		return snake.get(0).getNodeRow();
	}

	public void SetDir(Direction dir) {
		direction = dir;
	}

	public Direction getDir() {
		return direction;
	}

	public static String incrementLenght() {
		String s = null;
		lenght = snake.size();
		s = Integer.toString(lenght);
		return s;
	}

	/*
	 * public void grow(){ snake.add(snake.size()-1, new Node); }
	 */
}
