package bai_tap.tu_dien_map;

import java.util.Scanner;

public class MainTuDIen {
    public static void main(String[] args) {
        TuDien tuDien = new TuDien();
        int luaChon = 0;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("--------------");
            System.out.println("MENU");
            System.out.println("Tra từ điển Anh-Việt\n" +
                    "  1.Thêm từ (Từa khoá , ý nghĩa)\n" +
                    "  2.Xoá từ\n" +
                    "  3.Tìm ý nghĩa của từ khoá -> tra từ\n" +
                    "  4.In ra danh sách từ khoá\n" +
                    "  5.In ra số lượng từ\n" +
                    "  6.Xoá tất cả các từ khoá\n" +
                    "  0.Thoát khỏi chương trình\n"
            );
            System.out.print("Người dùng nhập lựa chọn: ");
            luaChon = Integer.parseInt(scanner.nextLine());
            if (luaChon==1){
                System.out.println("Nhập vào từ khoá ");
                String tuKhoa = scanner.nextLine();
                System.out.println("Nhập vào ý nghĩa");
                String yNghia = scanner.nextLine();

                tuDien.themTu(tuKhoa,yNghia);
            }else if (luaChon==2 || luaChon==3){
                System.out.println("Nhập vào từ khoá ");
                String tuKhoa = scanner.nextLine();
                if (luaChon==2){
                    tuDien.xoaTu(tuKhoa);
                }else {
                    System.out.println("Ý nghĩa là: " + tuDien.traTu(tuKhoa));
                }
            }else if (luaChon==4){
                tuDien.inTuKhoa();
            }else if (luaChon==5){
                System.out.println("Số lượng từ khoá là: " + tuDien.laySoluong());
            }else if (luaChon==6){
                tuDien.xoaTatCa();
            }else {
                System.out.println("Lựa chọn không phù hợp! vui lòng chọn lại");
            }
        }while (luaChon !=0);
    }
}
