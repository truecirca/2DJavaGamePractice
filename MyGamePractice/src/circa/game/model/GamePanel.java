package circa.game.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import circa.game.controller.KeyHandler;
import circa.game.entity.Player;

/**
 * The GamePanel class to handle the display window for the game
 * @author Circa (Credit to RyiSnow this is a follow along)
 * @version 6/5/2026 
 */
public class GamePanel extends JPanel implements Runnable{
	
	private final int originalTileSize;
	private final int scale;
	public final int tileSize;
	private final int maxScreenCol;
	private final int maxScreenRow;
	private final int screenWidth;
	private final int screenHeight;
	
	private int playerX;
	private int playerY;
	private int playerSpeed;
	
	private int fps;
	
	private Player thePlayer;
	
	private Thread gameThread;
	
	private KeyHandler keyHandler;
	
	/**
	 * Default constructor for the GamePanel Class
	 * @precondition none
	 */
	public GamePanel() {
		
		this.originalTileSize = 16;
		this.scale = 3;
		this.tileSize = originalTileSize * scale; //48x48 tile
		this.maxScreenCol = 16;
		this.maxScreenRow = 12;
		this.screenWidth = tileSize * maxScreenCol; //768 pixels
		this.screenHeight = tileSize * maxScreenRow; //576 pixels
		
		this.playerX = 100;
		this.playerY = 100;
		this.playerSpeed = 4;
		
		this.fps = 60;
		
		this.keyHandler = new KeyHandler();
		
		this.thePlayer = new Player(this, this.keyHandler);
		
		this.addKeyListener(keyHandler);
		
		this.setFocusable(true);
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		}
	
	/**
	 * Class to start the games thread
	 * @precondition none
	 */
	public void startGameThread() {
		
		this.gameThread = new Thread(this);
		this.gameThread.start();
		
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000 / this.fps; // 0.0166666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while (this.gameThread != null) {
			
			this.update();
			
			this.repaint();
			
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void update() {
		
		this.thePlayer.update();
		
	}
	
	public void paintComponent(Graphics graphics) {
		
		super.paintComponent(graphics);
		
		Graphics2D graphics2D = (Graphics2D)graphics;
		
		this.thePlayer.draw(graphics2D);
		
		graphics2D.dispose(); //Saves memory (Seems like a way of clearing the cache or what have you)
		
	}
}
