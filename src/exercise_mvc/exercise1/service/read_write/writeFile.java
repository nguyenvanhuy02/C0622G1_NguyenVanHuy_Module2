package exercise_mvc.exercise1.service.read_write;

import exercise_mvc.exercise1.model.Student1;
import exercise_mvc.exercise1.model.Teacher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class writeFile {
    public static void witeFile(String path,String data) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void wriStudentFile(String path, List<Student1> student1s) throws IOException {
        String data = "";
        for (Student1 student1 : student1s){
            data += student1.toString();
            data +="\n";
        }
        witeFile(path,data);
    }

    public static void wriTeachertFile(String path, List<Teacher> teachers) throws IOException {
        String data = "";
        for (Teacher teacher : teachers){
            data += teacher.toString();
            data +="\n";
        }
        witeFile(path,data);
    }
}
