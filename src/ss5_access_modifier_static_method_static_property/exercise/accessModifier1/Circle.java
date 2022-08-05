package ss5_access_modifier_static_method_static_property.exercise.accessModifier1;



public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(){
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public String getColor(){
        return color;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius,2);
    }
}
