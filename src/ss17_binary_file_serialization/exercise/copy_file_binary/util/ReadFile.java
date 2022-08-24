package ss17_binary_file_serialization.exercise.copy_file_binary.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadFile {
    public static List<Object> readFile (String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        List<Object> objectList;
        objectList= (List<Object>) objectInputStream.readObject();
        objectInputStream.close();
        return  objectList;
    }
}
