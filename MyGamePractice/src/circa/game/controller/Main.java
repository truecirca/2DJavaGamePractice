package circa.game.controller;

import javax.swing.JFrame;

import circa.game.model.GamePanel;

/**
 * The main class to run the program
 * @author Circa (Credit to RyiSnow this is a follow along)
 * @version 6/5/2026
 */
public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("My Game");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}
}
