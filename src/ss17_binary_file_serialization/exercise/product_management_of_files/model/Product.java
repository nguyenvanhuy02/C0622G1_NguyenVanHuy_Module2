package ss17_binary_file_serialization.exercise.product_management_of_files.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String name;
    private String manufacturer;
    private String price;
    private String otherDescriptions;
    public Product() {
    }

    public Product(String code, String name, String manufacturer, String price, String otherDescriptions) {
        this.code = code;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.otherDescriptions = otherDescriptions;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOtherDescriptions() {
        return otherDescriptions;
    }

    public void setOtherDescriptions(String otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price='" + price + '\'' +
                ", otherDescriptions='" + otherDescriptions + '\'' +
                '}';
    }
}
