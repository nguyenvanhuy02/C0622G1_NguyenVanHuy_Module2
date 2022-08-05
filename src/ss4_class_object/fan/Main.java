package ss4_class_object.fan;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan(3,true,10,"Yellow");



//        fan.setSpeed(fan.FAST);
//        fan.setRadius(10);
//        fan.setOn(true);
//        fan.setColor("Yellow");



        Fan fan1 = new Fan(2,false,5,"Blue");


//        fan1.setSpeed(fan.MEDIUM);
//        fan1.setRadius(5);
//        fan1.setOn(false);
//        fan1.setColor("Blue");



        System.out.println("Fan 1: " + fan.toString());
        System.out.println("Fan 2: " + fan1.toString());
    }
}
