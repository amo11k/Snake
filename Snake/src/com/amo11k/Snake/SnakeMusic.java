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
							"src/com/amo11k/Music/lavanda.mp3");
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
							"src/com/amo11k/Music/come.mp3");
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
