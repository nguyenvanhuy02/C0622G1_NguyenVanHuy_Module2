package bai_tap.quan_ly_san_pham.model;

import java.util.Scanner;

public class SanPham {
    private String tenSP;
    private double giaSP;
    private String maSP;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP,double giaSP) {
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.maSP = maSP;
    }


    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }


    public void nhapSanPham() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm");
        maSP = scanner.nextLine();
        System.out.println("Nhâp tên Sản phẩm: ");
        tenSP = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        giaSP = scanner.nextDouble();
    }

    public void xuatSanPham(){
        System.out.print(maSP + "-" + tenSP + "-" + giaSP);
    }
}
