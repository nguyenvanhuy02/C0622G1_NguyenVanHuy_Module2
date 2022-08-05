package ss4_class_object.fan;

public class Fan {

    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

//    public Fan() {
//        this.speed = SLOW;
//        this.on = false;
//        this.radius = 5;
//        this.color = "blue";
//    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;

    }


    public int getSpeed() {
        return speed;
    }

    public boolean getIsOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        if(this.getIsOn()) {
            return "Fan is on" +
                    "Fan{" +
                    ", speed=" + this.getSpeed() +
                    ", on=" + this.getIsOn() +
                    ", radius=" + this.getRadius() +
                    ", color='" + this.getColor() + '\'' +
                    '}';
        }else {
            return "Fan is of " +
                    "Fan{" +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
