package mvc_demo.service;

import java.io.IOException;

public interface IStudentService {
    void addStudent() throws IOException;

    void disPlayAllStudent() throws IOException;

    void removeStudent();

    void editStudent();

    void idStudent();

    void nameStudent();

    void sortNameStudent();
}
