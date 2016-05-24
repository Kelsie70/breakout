package com.joel.breakout.main;

import java.util.ArrayList;
import java.util.Iterator;

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

	public static ArrayList<Ball> ball_array = new ArrayList<Ball>();
	public static ArrayList<Powerup> powerUps = new ArrayList<Powerup>();
	private Ball b1 = new Ball(20, 200, 7);
	// private Ball b2 = new Ball(50, 250, 7);
	public static Iterator<Ball> bi = ball_array.iterator();

	public static Paddle paddle = new Paddle(window_width / 2);
	public static InputManager im = new InputManager();
	public Level level;
	public int numLevel = 1;
	public Powerup powerUp;

	public TestGame(Stage stage) {
		super(stage, "TestGame", 60, window_width, window_height);
		getSceneNodes().getChildren().addAll(bg, text, paddle.getPaddle());
		ball_array.add(b1);
		// ball_array.add(b2);
		bi = ball_array.iterator();
		while (bi.hasNext()) {
			getSceneNodes().getChildren().addAll(bi.next().getBall());
		}
		level = new Level(15, 5);
		level.init();

		for (int i = 0; i < level.bricks.length; i++) {
			for (int k = 0; k < level.bricks[i].length; k++) {
				getSceneNodes().getChildren().addAll(level.bricks[i][k].getBlock());
			}
		}

	}

	@Override
	public void update(Game game, GameTime gameTime) {
		text.setText("Hello " + gameTime.getTotalGameTime() + " ... " + level.xScale);
		im.update(game, gameTime);
		bi = ball_array.iterator();
		while (bi.hasNext()) {
			bi.next().update(game, gameTime);
		}
		paddle.update(game, gameTime);

		for (int i = 0; i < level.bricks.length; i++) {
			for (int k = 0; k < level.bricks[i].length; k++) {
				if (!level.bricks[i][k].isDead) {
					if (level.bricks[i][k].update(game, gameTime)) {
						game.getSceneNodes().getChildren().remove(level.bricks[i][k].getBlock());
					}
					if (level.bricks[i][k].dropNeeded) {
						game.getSceneNodes().getChildren().addAll(level.bricks[i][k].pu.getPowerUp());
					}
				}
			}
		}

		Iterator<Powerup> pi = powerUps.iterator();
		while (pi.hasNext()) {
			pi.next().update(game, gameTime);
		}
	}

	public static ArrayList<Ball> getBall_array() {
		return ball_array;
	}

}
