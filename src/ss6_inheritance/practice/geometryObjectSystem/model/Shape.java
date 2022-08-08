package ss6_inheritance.practice.geometryObjectSystem.model;

public class Shape {
    private String color;
    private boolean filled;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = "green";
        this.filled = true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A shape with color of " +
                getColor() +
                "and" + (isFilled() ? "filled" : "not filled");
    }
}
