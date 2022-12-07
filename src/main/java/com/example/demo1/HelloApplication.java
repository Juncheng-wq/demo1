package com.example.demo1;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Person p;
    Person p2;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();

        Circle circle = new Circle();
        circle.setFill(Color.PINK);
        circle.setRadius(30);

        Circle circle2 = new Circle();
        circle2.setFill(Color.BLACK);
        circle2.setRadius(30);

        p = new Person(100, 100, circle);
        p2 = new Person(500, 500, circle2);

        root.getChildren().add(p.getShape());
        root.getChildren().add(p2.getShape());

        Scene scene = new Scene(root, 1042, 768);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.D) {
                p.moveRight(20);
            }
            if (e.getCode() == KeyCode.A) {
                p.moveLeft(20);
            }
            if (e.getCode() == KeyCode.W) {
                p.moveUp(20);
            }
            if (e.getCode() == KeyCode.S) {
                p.moveDown(20);
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (p.isOverlapped(p2)) stage.close();
                p2.moveDown(1);
            }
        };

        timer.start();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch();
    }
}