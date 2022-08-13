package exercise_mvc.exercise1.model;

public class Student1 extends Person {
    private String nameClass;
    private double point;

    public Student1() {
    }

    public Student1(String nameClass, double point) {
        this.nameClass = nameClass;
        this.point = point;
    }

    public Student1(int id, String name, String dateOfBirth, String gender, String nameClass, double point) {
        super(id, name, dateOfBirth, gender);
        this.nameClass = nameClass;
        this.point = point;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameClass='" + nameClass + '\'' +
                ", point=" + point +
                '}' + super.toString();
    }
}
