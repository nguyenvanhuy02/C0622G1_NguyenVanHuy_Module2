package ss16_io_text_file.exercise.read_file_csv.controller;


import ss16_io_text_file.exercise.read_file_csv.util.ReadeListOfCountries;

import java.io.IOException;


public class FileCSVController {
    public static void main(String[] args) throws IOException {
     ReadeListOfCountries.readFile("src\\ss16_io_text_file\\exercise\\read_file_csv\\data\\ListOfCountries.csv");
}
}

