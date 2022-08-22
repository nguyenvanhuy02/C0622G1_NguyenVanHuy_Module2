package ss16_io_text_file.exercise.copy_file.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String path) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File (path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader =new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null){
            if (line.isEmpty()){
                continue;
            }
            list.add(line);
        }
        bufferedReader.close();
        return list;
    }
    public static void wirtFile (String path,String line) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(line);
        bufferedWriter.newLine();
        bufferedWriter.close();

    }
}
