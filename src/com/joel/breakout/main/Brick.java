package com.joel.breakout.main;

import java.util.ArrayList;

import com.joel.breakout.powerups.ExtraBall;
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
	boolean dropNeeded = false;

	public Brick(int health, Color color, int xx, int yy, int xscale, int yscale) {
		this.health = health;
		this.color = color;

		x = (xx * xscale) + Level.XOffset;
		y = (yy * yscale) + Level.YOffset;
		
		height = yscale -5;
		width = xscale - 5;

		block = new Rectangle(x, y, width, height) {
			{
				setFill(color);
			}
		};
		
		pu = new ExtraBall(x, y, width, height);
		//percent chance to have a power up
		//generate powerup here and pass x and y coords
		//10% chance of power up, 90% to be NULL
		//if power up -> choose which powerup
	}

	public Rectangle getBlock() {
		return block;
	}

	public boolean collision(ArrayList<Ball> balls) {
		if(isDead) {
			dropNeeded = false;
			return false;
		}
		for (int i = 0; i < balls.size(); i++) {
			Ball b = balls.get(i);
			if(b.getBall().getBoundsInParent().intersects(block.getBoundsInParent())){
				if(b.x <= x && b.x >= x + width){
					b.invertXDir();
				} else 
				if(b.y >= y || b.y <= y + height){
					b.invertYDir();
				}
				
				health--;
			}
			
			if(health == 0){
				isDead = true;
				dropNeeded = true;
				pu.activate();
				TestGame.powerUps.add(pu);
			}
		}
		return isDead;
	}

	public boolean update(Game game, GameTime gameTime) {
		return collision(TestGame.ball_array);
	}
}
