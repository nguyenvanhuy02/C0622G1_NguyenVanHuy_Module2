package ss17_binary_file_serialization.exercise.product_management_of_files.service.write_read;

import ss17_binary_file_serialization.exercise.product_management_of_files.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadProduct {
    public static List<Product> readProduct(String path) {
        List<Product> products = new ArrayList<>();
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e ){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;

    }
}
