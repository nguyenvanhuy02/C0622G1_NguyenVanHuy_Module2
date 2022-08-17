package bai_tap.quan_ly_san_pham.controller;

import bai_tap.quan_ly_san_pham.service.ISanPhamService;
import bai_tap.quan_ly_san_pham.service.SanPhamService;

import java.util.Scanner;

public class SanPhamController {
    private Scanner scanner = new Scanner(System.in);
    private ISanPhamService sanPhamService = new SanPhamService();
    int luaChon = 0;
    public void manuSanPham() {
        do {
            System.out.println("----------------------");
            System.out.println("Quản lí sản phẩm \n" +
                    "1.Thêm sản phẩm \n" +
                    "2.Xuất sản phẩm \n" +
                    "3.Cập nhật sản phẩm \n" +
                    "4.Tìm tên sản phẩm\n" +
                    "5.Xoá sản phẩm\n" +
                    "0.Thoát");
            System.out.print("Nhập lựa của của 0-6: ");
            luaChon = Integer.parseInt(scanner.nextLine());

            if (luaChon == 1){
                sanPhamService.themSanPham();
            }else if (luaChon ==2 ){
                sanPhamService.xuatSanPham();
            }else if (luaChon==3){
                sanPhamService.capNhatSanPham();
            }else if (luaChon==4){
                sanPhamService.timTenSanPham();
            }else if (luaChon==5){
                sanPhamService.xoaSanPham();
            }else if (luaChon==6){
                sanPhamService.TBSanPham();
            }else {
                System.out.println("Vui lòng nhập lại lựa chọn của bạn");
            }
        }while (luaChon !=0 );
    }
}
