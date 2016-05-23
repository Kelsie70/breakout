package com.joel.breakout.main;

import java.util.ArrayList;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick {

	int health = 1;
	int height, width;
	
	Color color = Color.BISQUE;
	Rectangle block;
	Powerup pu;

	int x, y;

	boolean isDead = false;

	public Brick(int health, Color color, Powerup pu, int xx, int yy, int xscale, int yscale) {
		this.health = health;
		this.color = color;
		this.pu = pu;

		x = (xx * xscale) + Level.XOffset;
		y = (yy * yscale) + Level.YOffset;
		
		height = yscale -5;
		width = xscale - 5;

		block = new Rectangle(x, y, width, height) {
			{
				setFill(color);
			}
		};
	}

	public Rectangle getBlock() {
		return block;
	}

	public boolean collision(ArrayList<Ball> balls) {
		if(isDead) return false;
		for (int i = 0; i < balls.size(); i++) {
			Ball b = balls.get(i);
			if(b.getBall().getBoundsInParent().intersects(block.getBoundsInParent())){
				health--;
				if(b.y < y || b.y > y + height){
					b.invertYDir();
				}
				if(b.x < x && b.x > x + width){
					b.invertXDir();
				}
			}
			
			if(health == 0){
				isDead = true;
			}
		}
		return isDead;
	}

	public boolean update(Game game, GameTime gameTime) {
		return collision(TestGame.ball_array);
	}
}
