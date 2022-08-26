package casestudy.model.person;

public class Employee extends Person{
    private String level;   // trình độ
    private String location;//Vị trí
    private String wage;    //Lương

    public Employee() {
    }

    public Employee(String level, String location, String wage) {
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String code, String name, String dateOfBirth, String gender, int citizenship, int phoneNumber, String email, String level, String location, String wage) {
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

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return String.format("%s,Trình độ: %s,Vị trí: %s,Lương: %s",super.toString(),level,location,wage);
    }
}
