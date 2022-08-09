package ss7_abstract_class_interface.exercise.interface_colorable.controller;


import ss7_abstract_class_interface.exercise.interface_colorable.model.*;

public class MainColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(4, 5);
        shapes[2] = new Square(2);

        for (Shape shape : shapes) {
            if (shape instanceof Colorable){
                Colorable colorable = (Colorable) shape;
                System.out.println(colorable.howToColor());
            }
        }
    }
}
