package com.joel.breakout.main;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;

import com.joel.breakout.objects.Ball;
import com.joel.breakout.objects.Brick;
import com.joel.breakout.objects.Paddle;

public class Game implements Runnable {

	private static Ball ball;
	private static Brick[] level;
	private static Paddle paddle;

	Game(int width, int height){
		ball = new Ball();
		paddle = new Paddle();
		
		setupWindow(width, height);
	}
	
	private void setupWindow(int width, int height){
		JFrame frame = new JFrame("Breakout!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIgnoreRepaint(true);
		
		Canvas canvas = new Canvas();
		canvas.setIgnoreRepaint(true);
		canvas.setSize(width, height);
		
		frame.add(canvas);
		canvas.setBackground(Color.green);
		
		// Display the window
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void run() {

	}

}
