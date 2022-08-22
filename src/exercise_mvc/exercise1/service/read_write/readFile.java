package exercise_mvc.exercise1.service.read_write;

import exercise_mvc.exercise1.model.Student1;
import exercise_mvc.exercise1.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class readFile {
    private static List<String> readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        List<String> strings = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null){
            strings.add(line);
        }
        bufferedReader.close();
        return strings;
    }

    public static List<Student1> readStudentFile(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Student1> student1s = new ArrayList<>();

        String[] info;
        for (String line : strings){
            info = line.split("-");
            student1s.add(new Student1(Integer.parseInt(info[0]),info[1],info[2],info[3],info[4],Double.parseDouble(info[5])));
        }
        return student1s;
    }

    public static List<Teacher> readTeacherFile(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Teacher> teachers = new ArrayList<>();

        String[] info;
        for (String line : strings){
            info = line.split("-");
            teachers.add(new Teacher(Integer.parseInt(info[0]),info[1],info[2],info[3],info[4]));
        }
        return teachers;
    }
}
