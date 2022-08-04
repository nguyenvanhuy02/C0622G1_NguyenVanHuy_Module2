package ss4_class_object.exercise.class_quadratic_equation;


public class ClassQuadraticEquation {
    double a;
    double b;
    double c;

    public ClassQuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

//    public double getA() {
//        return a;
//    }
//
//    public double getB() {
//        return b;
//    }
//
//    public double getC() {
//        return c;
//    }

    public double getDiscriminant() {
        return this.b * 2 - (4 * this.a * this.c);
    }

    public double getRoot1() {
        return (-this.b + Math.sqrt(this.b * this.b - (4 * this.a * this.c))) / 2 * this.a;
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt(this.b * this.b - (4 * this.a * this.c))) / 2 * this.a;
    }

    public double getDoubleSolution() {
        return  (-this.b) / 2 * this.a;
    }

}
