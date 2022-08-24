package ss17_binary_file_serialization.exercise.copy_file_binary.model;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;

    public Student(int id) {
        this.id = id;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
