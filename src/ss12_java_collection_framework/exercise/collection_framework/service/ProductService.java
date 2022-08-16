package ss12_java_collection_framework.exercise.collection_framework.service;

import ss12_java_collection_framework.exercise.collection_framework.model.Product;

import java.util.*;

public class ProductService implements IProductSrvice {
    private Scanner scanner = new Scanner(System.in);
    private List<Product> products = new ArrayList<>();
    @Override
    public void addProductSrvice() {
        Product product = this.addProduct();
        products.add(product);
        System.out.println("Thêm sản phẩn thành công!");
    }
    public Product addProduct(){
        System.out.print("Nhập tên id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product product = new Product(id,name,price);
        return product;
    }

    @Override
    public void fixProductSrvice() {
        Product product = this.idPriduct();
        if (product == null){
            System.out.println("Không tìm thấy sản phẩm!");
        }else {
            int findProduct = products.indexOf(product);
            Product fixProduct = addProduct();
            System.out.print("Nhập sản phẩm mới: ");
            products.get(findProduct).setId(fixProduct.getId());
            products.get(findProduct).setName(fixProduct.getName());
            products.get(findProduct).setPrice(fixProduct.getPrice());
            System.out.println("Cập nhật sản phẩm thành công!");
        }
    }

    @Override
    public void dellProductSrvice() {
        Product product = this.idPriduct();
        if (product == null){
            System.out.println("Không tìm thấy sản phẩm!");
        }else {
            System.out.print("bạn có chắc chắn muốn xoá " + product.getId() + " Không?");
            System.out.println("1.Có");
            System.out.println("2.Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice==1){
                products.remove(product);
                System.out.println("Bạn đã xoá thành công!");
            }if (choice==2){
                System.out.println("Hãy suy nghĩ kĩ lại nha!");
            }else {
                System.out.println("Lựa chọn của bạn không hợp lệ!");
            }
        }
    }

    @Override
    public void disPlayProductSrvice() {
        for (Product product : products){
            System.out.println(product);
        }
    }

    @Override
    public void searchProductSrvice() {
        if (products.size() <=0){
            System.out.println("Sản phẩm hiện tại không có");
            return;
        }
        System.out.print("Nhập tên cần tìm kiếm: ");
        String name = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < products.size() ; i++) {
            if (products.get(i).getName().equals(name)){
                System.out.println("Thông tin sản phẩm tìm kiếm là: " + products.get(i));
                count++;
            }
        }
        if (count == 0){
            System.out.println("Sản phầm tìm kiếm không tồn tại!");
        }
    }

    @Override
    public void sortProductSrvice() {
        products.sort((sp1, sp2) -> (int) (sp1.getPrice() - sp2.getPrice()));
        System.out.println("Đã sắp xếp thành công!");
    }

    public Product idPriduct(){
        System.out.print("Nhập id cần chọn: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < products.size() ; i++) {
            if (products.get(i).getId() == id ){
                return products.get(i);
            }
        }
        return null;
    }
}
