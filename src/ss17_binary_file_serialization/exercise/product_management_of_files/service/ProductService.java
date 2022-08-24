package ss17_binary_file_serialization.exercise.product_management_of_files.service;

import ss17_binary_file_serialization.exercise.product_management_of_files.model.Product;
import ss17_binary_file_serialization.exercise.product_management_of_files.service.write_read.ReadProduct;
import ss17_binary_file_serialization.exercise.product_management_of_files.service.write_read.WriteProduct;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    Scanner scanner = new Scanner(System.in);
    private List<Product> products;
    private static final String PATH_FILE = "src/ss17_binary_file_serialization/product_management_of_files/exercise/data/product.txt";

    @Override
    public void addProductService() throws IOException, ClassNotFoundException {
        products = ReadProduct.readProduct(PATH_FILE);
        Product product = this.addProduct();
        products.add(product);
        System.out.println("Bạn đã thêm sản phẩm thành công!");
        WriteProduct.writeToFile(PATH_FILE,products);
    }

    @Override
    public void disPlayProductService() throws IOException, ClassNotFoundException {
        products = ReadProduct.readProduct(PATH_FILE);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void searchProductService() throws IOException, ClassNotFoundException {
        products = ReadProduct.readProduct(PATH_FILE);
        Product product = this.codeProduct();
        if (product == null){
            System.out.println("Không tìm thấy sản phẩm!");
        }else {
            System.out.println("Thông tin sản phẩm bạn cần tìm là:");
            System.out.println(product);
        }
    }

    public Product codeProduct() {
        System.out.print("Mời bạn nhập mã sản phẩm cần tìm kiếm: ");
        String code = scanner.nextLine();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().equals(code)) {
                return products.get(i);
            }
        }
        return null;
    }

    public Product addProduct() {
        System.out.print("Mời bạn nhập mã sản phẩm: ");
        String code = scanner.nextLine();
        System.out.print("Mời bạn nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập hãng sản phẩm: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Mời bạn nhập giá sản phẩm: ");
        String price = scanner.nextLine();
        System.out.print("Mời bạn nhập các mô tả khác: ");
        String otherDescriptions = scanner.nextLine();

        return new Product(code, name, manufacturer, price, otherDescriptions);
    }
}
