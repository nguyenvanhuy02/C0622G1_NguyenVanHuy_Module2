package exercise_mvc.exercise1.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class Person {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String gender;

    public Person() {
    }

    public Person(int id, String name, Date dateOfBirth, String gender) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getDateOfBirth() {
        return (Data) dateOfBirth;
    }

    public void setDateOfBirth(Data dateOfBirth) {
        this.dateOfBirth = (Date) dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ID: " + id + "-" +
                "Học Và tên: " + name + "-" +
                "Ngày Tháng Năm: " + dateOfBirth ;
    }
}
