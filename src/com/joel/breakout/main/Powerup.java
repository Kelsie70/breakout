package com.joel.breakout.main;

import javafx.scene.shape.Rectangle;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class Powerup {

	public int time = 900; // 900 updates = 15 seconds
	public int x = 0, y = 0;
	public boolean isFalling = false, isActive = false;
	public Rectangle powerup;
	public Rectangle block;
	
	
	public Powerup(int x, int y){
		
	}
	public void update(Game game, GameTime gameTime) {
	}
	public void activate() {
	}
	public boolean collision() {
		return false;
	}
		
}
