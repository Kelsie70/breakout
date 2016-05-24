package com.joel.breakout.main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class Powerup {

	public int time = 900; // 900 updates = 15 seconds
	public int x = 0, y = 0;
	public boolean isFalling = false, isActive = false;
	public Rectangle powerup;
	public Rectangle block;
	public Color color = Color.RED;
	
	public Powerup(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		powerup = new Rectangle(x+(width/2), y+(height/2), 10, 10){{
			setFill(getColor());
			}};
	}
	public void update(Game game, GameTime gameTime) {
	}
	public void activate() {
	}
	public boolean collision() {
		if (TestGame.paddle.getPaddle().getBoundsInParent().intersects(powerup.getBoundsInParent())) 
			return true;
		else
			return false;
	}
	public Color getColor(){
		return color;
	}
	
	public Rectangle getPowerUp(){
		return powerup;
	}
		
}
