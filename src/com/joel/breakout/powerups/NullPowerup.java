package com.joel.breakout.powerups;

import javafx.scene.paint.Color;

import com.joel.breakout.main.Powerup;
import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class NullPowerup extends Powerup {

	public NullPowerup(int x, int y, int width, int height){
		super(x, y, width, height);
	}
	
	@Override
	public void update(Game game, GameTime gameTime) {

	}

	@Override
	public void activate() {

	}

	@Override
	public boolean collision() {
		return false;
	}

	@Override
	public Color getColor(){
		color = Color.FLORALWHITE;
		return color;
	}
}
