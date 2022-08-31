package casestudy.service.read_write;

import casestudy.model.facility.FacilityFurama;
import casestudy.model.facility.House;
import casestudy.model.facility.Room;
import casestudy.model.facility.Villa;
import casestudy.model.person.Customer;
import casestudy.model.person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadFile {
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

    public static List<Employee> readEmployeeFile(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Employee> employees = new ArrayList<>();

        String[] info;
        for (String line : strings){
            info = line.split(",");
            employees.add(new Employee(info[0],info[1],(info[2]),info[3],info[4],info[5],info[6],info[7],info[8],Double.parseDouble(info[9])));
        }
        return employees;
    }

    public static List<Customer> readCustomerFile(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Customer> customers = new ArrayList<>();

        String[] info;
        for (String line : strings){
            info = line.split(",");
            customers.add(new Customer(info[0],info[1],(info[2]),info[3],info[4],info[5],info[6],info[7],info[8]));
        }
        return customers;
    }

    public static Map<FacilityFurama,Integer> readFacilityFile(String path) throws IOException {
        List<String> strings = readFile(path);
        Map<FacilityFurama,Integer> facilityFuramaIntegerMap = new LinkedHashMap<>();

        String[] info;
        for (String line : strings){
            info = line.split(",");
            if (info[0].contains("SVVL")){
                facilityFuramaIntegerMap.put(new Villa(info[0],info[1],Double.parseDouble(info[2]),Double.parseDouble(info[3]),Integer.parseInt(info[4]),info[5],info[6],Double.parseDouble(info[7]),Integer.parseInt(info[8])),Integer.parseInt(info[9]));
            }else if (info[0].contains("SVHO")){
                facilityFuramaIntegerMap.put(new House(info[0],info[1],Double.parseDouble(info[2]),Double.parseDouble(info[3]),Integer.parseInt(info[4]),info[5],info[6],Integer.parseInt(info[7])),Integer.parseInt(info[8]));
            }else if (info[0].contains("SVRO")){
                facilityFuramaIntegerMap.put(new Room(info[0],info[1],Double.parseDouble(info[2]),Double.parseDouble(info[3]),Integer.parseInt(info[4]),info[5],info[6]),Integer.parseInt(info[7]));
            }
        }
        return facilityFuramaIntegerMap;
    }
}
