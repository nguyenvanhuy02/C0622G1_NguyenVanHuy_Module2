package exercise_mvc.exercise1.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class Teacher extends Person {
    private String specialize;

    public Teacher() {
    }

    public Teacher(String specialize) {
        this.specialize = specialize;
    }

    public Teacher(int id, String name, Data dateOfBirth, String gender, String specialize) {
        super(id, name, (Date) dateOfBirth, gender);
        this.specialize = specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return super.toString() + "-" +
                "Chuyên Môn: " + specialize;
    }

}
