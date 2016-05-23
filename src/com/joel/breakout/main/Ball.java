package com.joel.breakout.main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class Ball {

	
	private Circle circle;
	public int xdir, ydir, rad;
	public double x, y, speed = 1.5;
	
	public Ball(int xx, int yy, int rad){
		 circle = new Circle(xx,yy,rad,Color.AQUA);
		 x = xx;
		 y = yy;
		 xdir = 1;
		 ydir = 1;
		 this.rad = rad;
	}
	
	public void update(Game game, GameTime gameTime){
		
		x += (xdir * speed);
		y += (ydir * speed);
		
		circle.relocate(x, y);
		
		collision();
	}
	
	public boolean collision(){
		if(x <= 0 || x >= TestGame.window_width - rad*2) xdir *= -1;
		if(y <= 0 || y >= TestGame.window_height - rad*2) ydir *= -1;
		return false;
	}
	
	public Circle getBall(){
		return circle;
	}
	
	public void invertYDir(){
		ydir *= -1;
	}

	public void invertXDir() {
		xdir *= -1;
	}
	
}
