package com.amo11k.Snake;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SnakeMusic {

	private static String ruta;
	private static File file;

	public static void music() {
		file = new File(".");
		ruta = file.getAbsolutePath();
		Thread hilo = new Thread() {
			@Override
			public void run() {
				FileInputStream fis;
				Player player;
				try {
					fis = new FileInputStream(
							"src/com/amo11k/res/lavanda.mp3");
					BufferedInputStream bis = new BufferedInputStream(fis);
					player = new Player(bis);
					player.play();
				} catch (FileNotFoundException | JavaLayerException e) {
					System.out.println("jodido");
				}
			}
		};
		hilo.start();

	}
	
	public static void eatSound() {
		file = new File(".");
		ruta = file.getAbsolutePath();
		Thread hilo = new Thread() {
			@Override
			public void run() {
				FileInputStream fis;
				Player player;
				try {
					fis = new FileInputStream(
							"src/com/amo11k/res/come.mp3");
					BufferedInputStream bis = new BufferedInputStream(fis);
					player = new Player(bis);
					player.play();
				} catch (FileNotFoundException | JavaLayerException e) {
					System.out.println("jodido");
				}
			}
		};
		hilo.start();

	}
	
	public static void screamSound() {
		file = new File(".");
		ruta = file.getAbsolutePath();
		Thread hilo = new Thread() {
			@Override
			public void run() {
				FileInputStream fis;
				Player player;
				try {
					fis = new FileInputStream(
							"src/com/amo11k/res/scream.mp3");
					BufferedInputStream bis = new BufferedInputStream(fis);
					player = new Player(bis);
					player.play();
				} catch (FileNotFoundException | JavaLayerException e) {
					System.out.println("jodido");
				}
			}
		};
		hilo.start();

	}
	
	public static void gameOverSound() {
		file = new File(".");
		ruta = file.getAbsolutePath();
		Thread hilo = new Thread() {
			@Override
			public void run() {
				FileInputStream fis;
				Player player;
				try {
					fis = new FileInputStream(
							"src/com/amo11k/res/gameOver.mp3");
					BufferedInputStream bis = new BufferedInputStream(fis);
					player = new Player(bis);
					player.play();
				} catch (FileNotFoundException | JavaLayerException e) {
					System.out.println("jodido");
				}
			}
		};
		hilo.start();

	}

}
