package com.joel.breakout.main;

import java.util.Vector;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick {

	int health = 1;
	Color color = Color.BISQUE;
	Rectangle block;
	Powerup pu;
	
	int x, y;
	
	public Brick(int health, Color color, Powerup pu, int xx, int yy, int xscale, int yscale){
		this.health = health;
		this.color = color;
		this.pu = pu;
		
		x = (xx * xscale) + Level.XOffset;
		y = (yy * yscale) + Level.YOffset;
		
		block = new Rectangle(x, y, xscale - 5, yscale - 5) {{
			setFill(color);
		}};
	}

	public Rectangle getBlock(){
		return block;
	}
}
