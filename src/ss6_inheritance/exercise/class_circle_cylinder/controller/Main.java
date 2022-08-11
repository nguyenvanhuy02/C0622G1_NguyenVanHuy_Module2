package ss6_inheritance.exercise.class_circle_cylinder.controller;

import ss6_inheritance.exercise.class_circle_cylinder.model.Circle;
import ss6_inheritance.exercise.class_circle_cylinder.model.Cylinder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(6,"green");
        System.out.println(circle.toString());
        System.out.printf("Diện tích hình tròn: [%.2f] \n", circle.getPerimeter());
        System.out.println();

        Cylinder cylinder = new Cylinder(5,"green",5);
        System.out.println(cylinder.toString());
        System.out.printf("Diện tích hình trụ:[%.2f]", cylinder.getPerimeterCylinder());


    }
}
