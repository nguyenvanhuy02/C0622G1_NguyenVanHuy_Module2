package mvc_demo.service.read_end_write;

import mvc_demo.model.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class wirteFileStudent {
    private static void writeFile(String path,String data) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void wirteFileStudent(String path, List<Student> students) throws IOException {
        String data = "";
        for (Student student1 : students){
            data +=student1.toString();
            data += "\n";
        }
        writeFile(path,data);
    }
}
