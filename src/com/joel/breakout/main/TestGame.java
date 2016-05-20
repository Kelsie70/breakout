package com.joel.breakout.main;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

public class TestGame extends Game {

	    private Rectangle bg = new Rectangle(0, 0, 640, 480) {{ 
	         setFill(Color.BLACK); 
	    }};

	    private Text text = new Text() {{
	         setTranslateX(10);
	         setTranslateY(20);
	         setFill(Color.YELLOWGREEN);
	    }};

	    public TestGame(Stage stage) {
	        super(stage, "TestGame", 60, 640, 480);
	        getSceneNodes().getChildren().addAll(bg, text);
	    } // TestGame

	    @Override
	    public void update(Game game, GameTime gameTime) {
	        text.setText("Hello " + gameTime.getTotalGameTime());
	        if (game.getKeyManager().isKeyPressed(KeyCode.UP)) text.setTranslateY(text.getTranslateY() - 4);
	        if (game.getKeyManager().isKeyPressed(KeyCode.DOWN)) text.setTranslateY(text.getTranslateY() + 4);
	        if (game.getKeyManager().isKeyPressed(KeyCode.LEFT)) text.setTranslateX(text.getTranslateX() - 4);
	        if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT)) text.setTranslateX(text.getTranslateX() + 4);
	    } // update

	} // TestGame

