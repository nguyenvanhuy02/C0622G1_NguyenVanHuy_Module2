package ss6_inheritance.practice.geometryObjectSystem.controller;

import ss6_inheritance.practice.geometryObjectSystem.model.Shape;

public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red",false);
        System.out.println(shape);
    }
}
