package circa.game.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import circa.game.controller.KeyHandler;
import circa.game.model.GamePanel;

/**
 * The player class to handle player movement and updating the player sprite
 * @author Circa(credit to RyiSnow)
 * @version 6/6/2026
 */
public class Player extends Entity{
	
	private GamePanel panel;
	private KeyHandler handler;
	
	/**
	 * Constructor for the Player class
	 * @precondition none
	 * @param panel the game panel
	 * @param handler the handler for player input
	 */
	public Player(GamePanel panel, KeyHandler handler) {
		
		this.panel = panel;
		this.handler = handler;
		
		this.setDefaultValues();
		
	}
	
	/**
	 * A method to set the default values
	 * @precondition none
	 */
	public void setDefaultValues() {
		
		this.xValue = 100;
		this.yValue = 100;
		this.speed = 4;

		
	}
	
	/**
	 * A method to update the players position when a key is pressed
	 * @precondition none
	 */
	public void update() {
		
		if (this.handler.upPressed) {
			this.yValue -= this.speed;
		} else if (this.handler.downPressed) {
			this.yValue += this.speed;
		} else if (this.handler.leftPressed) {
			this.xValue -= this.speed;
		} else if (this.handler.rightPressed) {
			this.xValue += speed;
		}
	}
	
	/**
	 * A method to draw the player sprite at the new position when update is called
	 * @precondition none
	 * @param graphics2D the graphics2D collection
	 */
	public void draw (Graphics2D graphics2D)	{
		
	graphics2D.setColor(Color.white);
		
	graphics2D.fillRect(this.xValue, this.yValue, this.panel.tileSize, this.panel.tileSize);
		
	}
}
