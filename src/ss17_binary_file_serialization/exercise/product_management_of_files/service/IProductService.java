package ss17_binary_file_serialization.exercise.product_management_of_files.service;

import java.io.IOException;

public interface IProductService {
    void addProductService() throws IOException, ClassNotFoundException;

    void disPlayProductService() throws IOException, ClassNotFoundException;

    void searchProductService() throws IOException, ClassNotFoundException;
}
