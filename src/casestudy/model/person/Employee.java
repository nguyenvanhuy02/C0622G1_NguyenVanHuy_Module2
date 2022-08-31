package casestudy.model.person;

import java.time.LocalDate;

public class Employee extends Person{
    private String level;   // trình độ
    private String location;//Vị trí
    private Double wage;    //Lương

    public Employee() {
    }

    public Employee(String level, String location, Double wage) {
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String code, String name, String dateOfBirth, String gender, String citizenship, String phoneNumber, String email, String level, String location, Double wage) {
        super(code, name, dateOfBirth, gender, citizenship, phoneNumber, email);
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",super.toString(),level,location,wage);
    }
}
