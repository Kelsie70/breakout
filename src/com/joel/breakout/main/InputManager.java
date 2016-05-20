package com.joel.breakout.main;

import javafx.scene.input.KeyCode;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class InputManager {

	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	
	public double m_x;
	public double m_y;
	
	
	public void update(Game game, GameTime gameTime){
        up = game.getKeyManager().isKeyPressed(KeyCode.UP);
        down = game.getKeyManager().isKeyPressed(KeyCode.DOWN);
        left = game.getKeyManager().isKeyPressed(KeyCode.LEFT);
        right = game.getKeyManager().isKeyPressed(KeyCode.RIGHT);
	}
}
