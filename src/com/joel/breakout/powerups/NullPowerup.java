package com.joel.breakout.powerups;

import com.joel.breakout.main.Powerup;
import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class NullPowerup extends Powerup {

	public NullPowerup(int x, int y){
		super(x, y);
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

}
