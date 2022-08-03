package ss1_introduction_to_jave.lab;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count =0 ;
        String chuoi;
        System.out.print("Nhập chuỗi ");
        chuoi = scanner.nextLine();


        System.out.print("Nhập kí tự muốn kiểm tra: ");
        char kiemtra = scanner.nextLine().charAt(0);

        for (int i = 0; i < chuoi.length() ; i++) {
            if (chuoi.charAt(i) == kiemtra){
                count++;
            }
        }
        System.out.println("Số lượng: " + count);
    }
}







