package com.joel.breakout.powerups;

import javafx.scene.paint.Color;

import com.joel.breakout.main.Powerup;
import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class SlowBall extends Powerup {

	public SlowBall(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Game game, GameTime gameTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean collision() {
		return false;
		// TODO Auto-generated method stub

	}
	
	@Override
	public Color getColor(){
		color = Color.PINK;
		return color;
	}

}
