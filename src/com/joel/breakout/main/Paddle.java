package com.joel.breakout.main;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class Paddle {

	Rectangle rekt;
	int x;
	int speed = 3;

	public Paddle(int x) {
		rekt = new Rectangle(x, TestGame.window_height - 50, 150, 10) {
			{
				setFill(Color.RED);
			}
		};
		this.x = x;
	}

	Rectangle getPaddle() {
		return rekt;
	}

	public void collision(ArrayList<Ball> ball_array) {
		Iterator<Ball> bi = ball_array.iterator();
		while (bi.hasNext()) {
			Ball b = bi.next();
			if (rekt.getBoundsInParent().intersects(
					b.getBall().getBoundsInParent())) {
				b.invertYDir();
			}
			
		}
	}

	public void update(Game game, GameTime gameTime) {
		int dx = 0;

		if (TestGame.im.left) {
			dx--;
		}
		if (TestGame.im.right) {
			dx++;
		}
		
		x += dx * speed;
		
		if(x <= 0){
			x = 0;
		}
		if(x >= TestGame.window_width - 150){
			x = TestGame.window_width - 150;
		}

		

		rekt.relocate(x, TestGame.window_height - 50);

		collision(TestGame.getBall_array());

	}

}
