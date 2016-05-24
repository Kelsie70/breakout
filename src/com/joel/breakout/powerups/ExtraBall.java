package com.joel.breakout.powerups;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import com.joel.breakout.main.Ball;
import com.joel.breakout.main.Powerup;
import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class ExtraBall extends Powerup {

	Ball b1;
	
	public ExtraBall(int x, int y, int width, int height){
		super(x, y, width, height);
		powerup = new Rectangle(x, y, 20, 20);
	}
	
	@Override
	public void update(Game game, GameTime gameTime) {
		if(isFalling){
			y++;
		}
		
		if(collision()){
			isActive = true;
			game.getSceneNodes().getChildren().addAll(b1.getBall());
			game.getSceneNodes().getChildren().remove(powerup);
		}
		
		if(isActive){
			time--;
		}
	}

	@Override
	public void activate() {
		isFalling = true;
	}

	@Override
	public boolean collision() {
		b1 = new Ball(20, 200, 7);
		return false;
	}
	
	@Override
	public Color getColor(){
		color = Color.BLUE;
		return color;
	}

}
