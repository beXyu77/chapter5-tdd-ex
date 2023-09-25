package se233.chapter5_tdd;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import se233.chapter5_tdd.controller.GameLoop;
import se233.chapter5_tdd.model.Food;
import se233.chapter5_tdd.model.Snake;
import se233.chapter5_tdd.view.Platform;

public class Launcher extends Application {

    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Platform platform = new Platform();
        Snake snake = new Snake(new Point2D(platform.WIDTH / 2, platform.HEIGHT / 2));
        Food food1 = new Food(Color.RED);
        Food food2 = new Food(Color.GREEN);


        GameLoop gameLoop = new GameLoop(platform, snake, food1,food2);
        Scene scene = new Scene(platform, platform.WIDTH * platform.TILE_SIZE, platform.HEIGHT * platform.TILE_SIZE);
        scene.setOnKeyPressed(event -> platform.setKey(event.getCode()));

        scene.setOnKeyReleased(event -> platform.setKey(null));
        this.stage.setTitle("Snake");
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.show();
        (new Thread(gameLoop)).start();
    }
}
