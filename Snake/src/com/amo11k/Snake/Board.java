package com.amo11k.Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel {
	private Snake snake;
	static Direction currentDir;
	private Food food;
	protected final static int ROWS = 50;
	protected final static int COLS = 50;
	private Timer timerBoard;
	private KeyAdapter keyAdapter;
	private int deltaTime = 120;
	protected Score score;

	private Timer foodTimer;
	private int deltaFoodTime = 100;
	private Graphics g;
	private Random random;
	public static Boolean come;
	public static Boolean GOver;
	int countTerror = 0;
	int terrorTime;
	private Terror terror;

	class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if ((Board.currentDir == Direction.RIGHT)
						&& (snake.getArray().size() > 1)) {

				} else {
					currentDir = Direction.LEFT;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if ((Board.currentDir == Direction.LEFT)
						&& (snake.getArray().size() > 1)) {

				} else {
					currentDir = Direction.RIGHT;
				}
				break;
			case KeyEvent.VK_UP:
				if ((Board.currentDir == Direction.DOWN)
						&& (snake.getArray().size() > 1)) {

				} else {
					currentDir = Direction.UP;
				}
				break;
			case KeyEvent.VK_DOWN:
				if ((Board.currentDir == Direction.UP)
						&& (snake.getArray().size() > 1)) {

				} else {
					currentDir = Direction.DOWN;
				}
				break;
			case KeyEvent.VK_SPACE:
					terror.setVisible(false);
				break;
			case KeyEvent.VK_E:
				break;
			default:
				break;
			}
			repaint();
		}
	}

	public Board(Score score) {
		play();

	}

	private void drawSquare(Graphics g, Node n) {
		int y = n.getNodeRow() * squareHeight();
		int x = n.getNodeCol() * squareWidth();
		g.setColor(Color.GREEN);
		g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
		// g.setColor(color.brighter());
		g.drawLine(x, y + squareHeight() - 1, x, y);
		g.drawLine(x, y, x + squareWidth() - 1, y);
		// g.setColor(Color.GREEN.darker());
		g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y
				+ squareHeight() - 1);
		g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x
				+ squareWidth() - 1, y + 1);
	}

	private void drawHead(Graphics g, Node n) {
		int y = n.getNodeRow() * squareHeight();
		int x = n.getNodeCol() * squareWidth();
		g.setColor(Color.RED);
		g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
		// g.setColor(color.brighter());
		g.drawLine(x, y + squareHeight() - 1, x, y);
		g.drawLine(x, y, x + squareWidth() - 1, y);
		g.setColor(Color.RED.darker());
		g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y
				+ squareHeight() - 1);
		g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x
				+ squareWidth() - 1, y + 1);
	}

	public void drawFood(Graphics g, Food food) {
		int y = food.getFoodRow() * squareHeight();
		int x = food.getFoodCol() * squareWidth();

		if (food.isSpecial())
			g.setColor(Color.ORANGE.brighter());
		else
			g.setColor(Color.PINK.brighter());
		g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
		// g.setColor(color.brighter());
		g.drawLine(x, y + squareHeight() - 1, x, y);
		g.drawLine(x, y, x + squareWidth() - 1, y);
		g.setColor(Color.GREEN.darker());
		g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y
				+ squareHeight() - 1);
		g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x
				+ squareWidth() - 1, y + 1);
	}

	protected void drawSnake(Graphics g) {
		for (Node n : snake.getArray()) {
			drawSquare(g, n);
		}
		drawHead(g, snake.getArray().get(0));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawSnake(g);
		drawFood(g, food);
	}

	public void init() {
		keyAdapter = new MyKeyAdapter();
		addKeyListener(keyAdapter);
		terrorTime = (int) Math.random() * 10 + 1;
		timerBoard = new Timer(deltaTime, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (GOver) {
					gameOver();
				}

				snake.move(currentDir);
				if (snake.getArray().get(0).getNodeRow() == food.getFoodRow()
						&& snake.getArray().get(0).getNodeCol() == food
								.getFoodCol()) {
					if (food.isSpecial()) {
						come = true;
						initFood();
						SnakeMusic.eatSound();
						Game.scoreLabel.setText(Score.incrementSpecialScore());
						Game.lenght.setText(Snake.incrementLenght());
						countTerror++;
						
						  if (countTerror == 1){
							  terror();
						  }
						 
					} else {
						come = true;
						initFood();
						SnakeMusic.eatSound();
						Game.scoreLabel.setText(Score.incrementScore());
						Game.lenght.setText(Snake.incrementLenght());
						deltaTime = deltaTime - 5;
					}

				} else {
					come = false;
				}
				repaint();

			}

		});

	}

	public void initFood() {
		if (foodTimer!=null){
			foodTimer.stop();
		}
		food = new Food();
		if (food.isSpecial()){
			foodTimer = new Timer(6500, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					foodTimer.stop();
					initFood();
					
				}
			});
			foodTimer.start();
		}
		
	}

	private int squareHeight() {
		return this.getHeight() / ROWS;
	}

	private int squareWidth() {
		return this.getWidth() / COLS;
	}

	protected void gameOver() {
		timerBoard.stop();
		SnakeMusic.gameOverSound();
		Object[] options={"Yes, I wanna replay it","No, please, stop that shit"};
		int response = JOptionPane.showOptionDialog(Game.frame, "Game Over"
				+ "\nPuntucación " + Score.score + "\n" + "Length "
				+ Snake.lenght + "\n\n" + "Volver a jugar?","Game Over",
			    JOptionPane.YES_NO_CANCEL_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[1]);
		switch (response) {
		case 0:
			play();
			break;
		case 1:
			System.exit(1);
			break;
		}
	}

	protected void terror() {
		terror=new Terror();
		terror.setVisible(true);
		add(terror);
		terror.setFocusable(true);
		SnakeMusic.screamSound();
	}

	private void play() {
		SnakeMusic.music();
		come = false;
		GOver = false;
		snake = new Snake();
		currentDir = Direction.RIGHT;
		setFocusable(true);
		score = new Score();
		init();
		// drawFood(g,food);
		initFood();
		terror();
		timerBoard.start();
	}
}
