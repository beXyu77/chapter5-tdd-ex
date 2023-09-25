package se233.chapter5_tdd.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import se233.chapter5_tdd.model.Food;
import se233.chapter5_tdd.model.Snake;

public class Platform extends Pane {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    public static final int TILE_SIZE = 10;
    private Canvas canvas;
    private KeyCode key;

    public Platform(){
        this.setHeight(TILE_SIZE * HEIGHT);
        this.setWidth(TILE_SIZE * WIDTH);
        canvas = new Canvas(TILE_SIZE * WIDTH , TILE_SIZE * HEIGHT);
        this.getChildren().add(canvas);

    }
    public void render(Snake snake, Food food1, Food food2) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        gc.setFill(Color.BLUE);

        // Render snake body
        snake.getBody().forEach(p -> {
            gc.fillRect(p.getX() * TILE_SIZE, p.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        });

        // Render the first piece of food
        if (food1.getColor() == Color.RED) {
            gc.setFill(Color.RED);
        } else if (food1.getColor() == Color.GREEN) {
            gc.setFill(Color.GREEN);
        }
        gc.fillRect(food1.getPosition().getX() * TILE_SIZE, food1.getPosition().getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Render the second piece of food
        if (food2.getColor() == Color.RED) {
            gc.setFill(Color.RED);
        } else if (food2.getColor() == Color.GREEN) {
            gc.setFill(Color.GREEN);
        }
        gc.fillRect(food2.getPosition().getX() * TILE_SIZE, food2.getPosition().getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }


    public KeyCode getKey() {
        return key;
    }

    public void setKey(KeyCode key) {
        this.key = key;
    }
}
/*
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import se233.chapter5_tdd.model.Food;
import se233.chapter5_tdd.model.Snake;

public class Platform extends Pane {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    public static final int TILE_SIZE = 10;
    private Canvas canvas;
    private KeyCode key;

    public Platform() {
        this.setHeight(TILE_SIZE * HEIGHT);
        this.setWidth(TILE_SIZE * WIDTH);
        canvas = new Canvas(TILE_SIZE * WIDTH, TILE_SIZE * HEIGHT);
        this.getChildren().add(canvas);
    }
    public void render(Snake snake, Food food) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,WIDTH*TILE_SIZE,HEIGHT*TILE_SIZE);
        gc.setFill(Color.BLUE);
        snake.getBody().forEach(p -> {
            gc.fillRect(p.getX() * TILE_SIZE, p.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        });
        gc.setFill(Color.RED);
        gc.fillRect(food.getPosition().getX() * TILE_SIZE, food.getPosition().getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }
    public KeyCode getKey() { return key; }
    public void setKey(KeyCode key) { this.key = key; }
}
*/