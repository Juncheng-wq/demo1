package com.example.demo1;

import javafx.scene.shape.Shape;

public abstract class Person {
    private final Shape shape;

    public Person(int x, int y, Shape shape) {
        this.shape = shape;
        shape.setLayoutX(x);
        shape.setLayoutY(y);
    }

    public Shape getShape() {
        return shape;
    }

    public double getX() {
        return shape.getLayoutX();
    }

    public double getY() {
        return shape.getLayoutY();
    }

    public void moveLeft(double speed) {
        
        shape.setLayoutX(shape.getLayoutX() - speed);
    }

    public void moveRight(double speed) {
        
        shape.setLayoutX(shape.getLayoutX() + speed);
    }

    public void moveUp(double speed) {
        shape.setLayoutY(shape.getLayoutY() - speed);
    }

    public void moveDown(double speed) {
        shape.setLayoutY(shape.getLayoutY() + speed);
    }

    public boolean isOverlapped(Person p) {
        return p.getX() == shape.getLayoutX() && p.getY() == shape.getLayoutY();
    }
}
