package bai_tap.quan_ly_san_pham.view;

import bai_tap.quan_ly_san_pham.controller.SanPhamController;

public class MainView {
    public static void main(String[] args) {
        SanPhamController sanPhamController = new SanPhamController();
        sanPhamController.manuSanPham();
    }
}
