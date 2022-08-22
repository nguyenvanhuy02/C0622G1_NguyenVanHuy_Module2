package mvc_demo.service.read_end_write;

import mvc_demo.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class readFileStudent {
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

    public static List<Student> readStudentFile(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Student> students = new ArrayList<>();

        String[] info;
        for (String line : strings){
            info=line.split(",");
            students.add(new Student(Integer.parseInt(info[0]),info[1],info[2],Double.parseDouble(info[3]),info[4]));
        }
        return students;
    }
}
