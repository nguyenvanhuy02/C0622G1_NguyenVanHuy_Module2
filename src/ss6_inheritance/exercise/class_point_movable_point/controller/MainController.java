package ss6_inheritance.exercise.class_point_movable_point.controller;

import ss6_inheritance.exercise.class_point_movable_point.model.MovablePoint;

public class MainController {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(1,2,3,4);
        System.out.println(movablePoint.toString());
        System.out.println(movablePoint.move());
    }
}
