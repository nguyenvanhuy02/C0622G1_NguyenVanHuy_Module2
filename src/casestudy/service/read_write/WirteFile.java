package casestudy.service.read_write;

import casestudy.model.facility.FacilityFurama;
import casestudy.model.person.Customer;
import casestudy.model.person.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WirteFile {
    public static void witeFile(String path,String data) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new  BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writeEmployee(String path, List<Employee> employees) throws IOException {
        String data = "";
        for (Employee employee : employees){
            data += employee.toString();
            data +="\n";
        }
        witeFile(path,data);
    }

    public static void writeCustomer(String path, List<Customer>customers) throws IOException {
        String data = "";
        for (Customer customer : customers){
            data += customer.toString();
            data +="\n";
        }
        witeFile(path,data);
    }

    public static void writeFacility(String path , Map<FacilityFurama,Integer> furamaIntegerMap) throws IOException {
        String data = "";
        for (FacilityFurama facilityFurama : furamaIntegerMap.keySet()){
            data += facilityFurama.toString()+","+furamaIntegerMap.get(facilityFurama);
            data +="\n";
        }
        witeFile(path,data);
    }
}
