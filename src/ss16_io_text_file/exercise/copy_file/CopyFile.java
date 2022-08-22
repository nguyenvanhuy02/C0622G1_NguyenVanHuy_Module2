package ss16_io_text_file.exercise.copy_file;

import ss16_io_text_file.exercise.copy_file.data.ReadFile;

import java.io.IOException;
import java.util.List;

public class CopyFile {
    private static final String PATH_FILE = "src\\ss16_io_text_file\\exercise\\copy_file\\data\\sourcefile.txt";
    private static final String PATH_FILE1 = "src\\ss16_io_text_file\\exercise\\copy_file\\data\\targetfile.txt";
    public static void main(String[] args) throws IOException {

        List<String> copy = ReadFile.readFile(PATH_FILE);

        for (String line : copy){
            ReadFile.wirtFile(PATH_FILE1,line);
        }

    }


}
