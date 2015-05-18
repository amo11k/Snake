package com.amo11k.Snake;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;

public class Terror extends JLabel {

	//private JPanel contentPane;
	JLabel exor;
	


	/**
	 * Create the frame.
	 */
	public Terror() {
		/*setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menuText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
		
		exor = new JLabel("");
		exor.setHorizontalAlignment(SwingConstants.CENTER);
		exor.setBackground(SystemColor.desktop);
		exor.setBounds(100, 100, 500, 500);
		exor.setIcon(new ImageIcon(Terror.class.getResource("/com/amo11k/res/exorcista.gif")));
		setVisible(true);
		//contentPane.add(exor, BorderLayout.CENTER);
	}
	
	/*class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				frame.dispose();
				break;
			default:
				break;
			}
			repaint();
		}
	}*/

}
