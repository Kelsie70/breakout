package com.joel.breakout.main;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

import javafx.scene.shape.*;
import javafx.scene.paint.Color;

public class Paddle {

	Rectangle rekt;
	int x;
	int speed = 3;
	
	public Paddle(int x){
		rekt = new Rectangle(x, TestGame.window_height - 50, 150, 10){{
			setFill(Color.RED);
		}};
		this.x = x;
	}
	
	Rectangle getPaddle(){
		return rekt;
	}
	
	public void collision(Ball ball){
		if(rekt.getBoundsInParent().intersects(ball.getBall().getBoundsInParent())){
			ball.invertYDir();
		}
	}
	
	public void update(Game game, GameTime gameTime){
		int dx = 0;
		
		if(TestGame.im.left){
			dx--;
		}
		if(TestGame.im.right){
			dx++;
		}
		
		x += dx * speed;
		
		rekt.relocate(x, TestGame.window_height - 50);
		
		collision(TestGame.getBall());
		
	}
	
	
}
