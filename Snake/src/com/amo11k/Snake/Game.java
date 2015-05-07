package com.amo11k.Snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

/**
 * @author prueba
 *
 */
public class Game extends JFrame {
	private Board board;
	public static JFrame frame;
	private JPanel contentPane;
	static JLabel scoreLabel;
	private JLabel lblLenght;
	protected static JLabel lenght;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Game();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws JavaLayerException 
	 * @throws FileNotFoundException 
	 */
	public Game(){
		setFont(new Font("Candara", Font.BOLD, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Snake Terror Edition - by Amo11k");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Score score = new Score();
		score.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(102, 153,
				102), null, null, null));
		score.setForeground(Color.ORANGE);
		score.setBackground(new Color(51, 51, 255));
		contentPane.add(score, BorderLayout.SOUTH);
		score.setBounds(100, 100, 100, 100);
		score.setVisible(true);

		JLabel puntuacion = new JLabel("Score:");
		puntuacion.setForeground(Color.ORANGE);
		score.add(puntuacion);

		scoreLabel = new JLabel("0");
		scoreLabel.setForeground(Color.ORANGE);
		score.add(scoreLabel);

		lblLenght = new JLabel("Lenght:");
		lblLenght.setForeground(Color.ORANGE);
		score.add(lblLenght);

		lenght = new JLabel("0");
		lenght.setForeground(Color.ORANGE);
		score.add(lenght);

		Color fondo = new Color(172, 168, 168);
		Color borde = new Color(9, 55, 109);
		board = new Board(score);
		board.setBackground(new Color(0, 0, 0));
		contentPane.add(board, BorderLayout.CENTER);
		contentPane.setBackground(new Color(169, 169, 169));

		// contentPane.addKeyListener(this);
	}
}
