package com.joel.breakout.main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class TestGame extends Game {

	public static int window_width = 640;
	public static int window_height = 480;
	private Rectangle bg = new Rectangle(0, 0, window_width, window_height) {
		{
			setFill(Color.BLACK);
		}
	};

	private Text text = new Text() {
		{
			setTranslateX(10);
			setTranslateY(20);
			setFill(Color.YELLOWGREEN);
		}
	};

	public static Ball ball = new Ball(20, 30, 7);
	public Paddle paddle = new Paddle(window_width /2);
	public static InputManager im = new InputManager();

	public TestGame(Stage stage) {
		super(stage, "TestGame", 60, window_width, window_height);
		getSceneNodes().getChildren().addAll(bg, text, ball.getBall(), paddle.getPaddle());

	}

	@Override
	public void update(Game game, GameTime gameTime) {
		text.setText("Hello " + gameTime.getTotalGameTime() + " || " + ball.getBall().getTranslateX() + ", " + ball.getBall().getTranslateY());
		im.update(game, gameTime);
		ball.update(game, gameTime);
		paddle.update(game, gameTime);
	}

	
	public static Ball getBall(){
		return ball;
	}
}
