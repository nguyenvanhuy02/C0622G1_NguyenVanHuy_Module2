package bai_tap.quan_ly_san_pham.service;

import bai_tap.quan_ly_san_pham.model.SanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanPhamService implements ISanPhamService {
    Scanner scanner = new Scanner(System.in);
    List<SanPham> sanPhams = new ArrayList<>();

    @Override

    // Thêm sản phẩm !!!!
    public void themSanPham() {
        SanPham sanPham = new SanPham();
        sanPham.nhapSanPham();
        sanPhams.add(sanPham);
        System.out.println("Thêm sản phầm thành công!");
    }

    //Xuất hiện sản phẩm!!!
    @Override
    public void xuatSanPham() {
        for (SanPham sp : sanPhams) {
            sp.xuatSanPham();
            System.out.println("\n");
        }
    }

    @Override
    public void capNhatSanPham() {
        System.out.println("Nhập mã sản phẩm cần cập nhật thông tin: ");
        String ma = scanner.nextLine();
        SanPham spFound = null;

        for (SanPham sp : sanPhams){
            if (sp.getMaSP().equalsIgnoreCase(ma)){
                spFound = sp;
                break;
            }
        }
        if (spFound != null){
            spFound.nhapSanPham();
            System.out.println("Cập nhật sản phẩm thành công!");
        }else {
            System.out.println("Không tìm thấy sản phẩm cập nhât!");
        }
    }

    @Override
    public void timTenSanPham() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String ten = scanner.nextLine();

        for (SanPham sp : sanPhams){
            if (sp.getTenSP().equalsIgnoreCase(ten)){
                sp.xuatSanPham();
            }
        }
    }

    @Override
    public void xoaSanPham() {
        System.out.println("Nhập mã sản phẩm cần xoá: ");
        String ma = scanner.nextLine();
        SanPham spFound = null;

        for (SanPham sp : sanPhams){
            if (sp.getMaSP().equalsIgnoreCase(ma)){
                spFound = sp;
                break;
            }
        }
        if (spFound != null){
            sanPhams.remove(spFound);
            System.out.println("Xoá sản phẩm thành công!");
        }else {
            System.out.println("Không tìm thấy sản phẩm cập nhât!");
        }
    }

    @Override
    public void TBSanPham() {
        double tong =0;
        for (SanPham sp : sanPhams){
            tong += sp.getGiaSP();
        }
    }

}
