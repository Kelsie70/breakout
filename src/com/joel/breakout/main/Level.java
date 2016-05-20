package com.joel.breakout.main;

import javafx.scene.paint.Color;


public class Level {
	Brick[][] bricks;
	int rows;
	int cols;

	int xScale = 60, yScale = 30;
	
	public static int XOffset = 15;
	public static int YOffset = 15;
	
	public Level (int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;
		bricks = new Brick[rows][cols];
	}
	
	public void init(){
		scale();
		for(int i = 0; i < bricks.length; i++){
			for(int k = 0; k < bricks[i].length; k++){
				bricks[i][k] = new Brick(1, Color.BISQUE, new Powerup(), i, k, xScale, yScale);
			}
		}
		
	}
	
	private void scale(){
		xScale = ((TestGame.window_width / cols) - 50) / 3 * 2;
		yScale = TestGame.window_height / rows / 2;

	}
}
