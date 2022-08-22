package ss16_io_text_file.exercise.read_file_csv.util;

import ss16_io_text_file.exercise.read_file_csv.model.ListOfCountries;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadeListOfCountries {
   public static void readFile(String path) throws IOException {
       List<ListOfCountries> list = new ArrayList<>();

       File file = new File(path);
       FileReader fileReader = new FileReader(file);
       BufferedReader bufferedReader = new BufferedReader(fileReader);

       String line;
       while ((line = bufferedReader.readLine()) != null){
           String[] lists = line.split(",");
           list.add(new ListOfCountries(Integer.parseInt(lists[0]),lists[1],lists[2]));
       }
       bufferedReader.close();

       for (ListOfCountries listOfCountries : list){
           System.out.println(listOfCountries.toString());
       }
   }

}
