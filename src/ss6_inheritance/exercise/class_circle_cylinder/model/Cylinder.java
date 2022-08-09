package ss6_inheritance.exercise.class_circle_cylinder.model;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPerimeterCylinder(){
        return Math.PI * (this.getRadius()*this.getRadius()) * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                "radius=" + getRadius()+
                "color=" + getColor() +
                '}';
    }
}
