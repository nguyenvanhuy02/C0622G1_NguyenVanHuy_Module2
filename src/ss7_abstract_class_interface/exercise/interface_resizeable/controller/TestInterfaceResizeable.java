package ss7_abstract_class_interface.exercise.interface_resizeable.controller;

import ss7_abstract_class_interface.exercise.interface_resizeable.model.Circle;
import ss7_abstract_class_interface.exercise.interface_resizeable.model.Rectangle;
import ss7_abstract_class_interface.exercise.interface_resizeable.model.Shape;

public class TestInterfaceResizeable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(2);
        shapes[1] = new Rectangle(2,3);
        for (Shape shape : shapes){
            shape.resize(Math.floor(Math.random()*100));
        }
        for(Shape shape : shapes){
            System.out.println(shape);
            System.out.println();
        }
    }

}
