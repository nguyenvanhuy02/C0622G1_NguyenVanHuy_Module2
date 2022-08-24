package ss17_binary_file_serialization.exercise.copy_file_binary.view;

import ss17_binary_file_serialization.exercise.copy_file_binary.model.Student;
import ss17_binary_file_serialization.exercise.copy_file_binary.util.ReadFile;
import ss17_binary_file_serialization.exercise.copy_file_binary.util.WriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainFile {
    private static final String FILE  = "src/ss17_binary_file_serialization/exercise/copy_file_binary/data/sourcefile.dat";
    private static final String FILE1  = "src/ss17_binary_file_serialization/exercise/copy_file_binary/data/sourcefile1.dat";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Object> objects = new ArrayList<>();
        objects.add(new Student(1));
        objects.add(new Student(2));
        objects.add(new Student(3));
        WriteFile.writeFile(FILE,objects);


        List<Object> objectList = ReadFile.readFile(FILE);
        WriteFile.writeFile(FILE1,objectList);
    }
}
