package ss1_introduction_to_jave.exercise;

import java.util.Scanner;

public class ReadTheNumberIntoWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số bạn cần đọc : ");
        int number = scanner.nextInt();
        int unitsNumber = number % 10;
        int dozensNumber = number % 100 - unitsNumber;
        int hundredNumber = number % 1000 - dozensNumber - unitsNumber;
        String result = "";

        if (number > 0 && number < 1000) {
            switch (hundredNumber) {
                case 0:
                    result += "";
                    break;
                case 100:
                    result += "Một trăm ";
                    break;
                case 200:
                    result += "Hai trăm ";
                    break;
                case 300:
                    result += "Ba trăm ";
                    break;
                case 400:
                    result += "Bốn trăm ";
                    break;
                case 500:
                    result += "Năm trăm ";
                    break;
                case 600:
                    result += "Sáu trăm ";
                    break;
                case 700:
                    result += "Bảy trăm ";
                    break;
                case 800:
                    result += "Tám trăm ";
                    break;
                case 900:
                    result += "Chín trăm ";
                    break;
            }
            switch (dozensNumber){
                case 0:
                    if (hundredNumber == 0){
                        result +="";
                    }else if (unitsNumber==0){
                        result +="";
                    }else {
                        result +="lẻ ";
                    }
                    break;
                case 10:
                    result += "mười ";
                    break;
                case 20:
                    result += "hai mươi ";
                    break;
                case 30:
                    result += "ba mươi ";
                    break;
                case 40:
                    result += "bốn mươi ";
                    break;
                case 50:
                    result += "năm mươi ";
                    break;
                case 60:
                    result += "sáu mươi ";
                    break;
                case 70:
                    result += "bảy mươi ";
                    break;
                case 80:
                    result += "tám mươi ";
                    break;
                case 90:
                    result += "chín mươi ";
                    break;
            }
            switch (unitsNumber){
                case 0:
                    result += "";
                    break;
                case 1:
                    if (dozensNumber==10){
                        result += "một ";
                    }else {
                        result +="mốt ";
                    }
                    break;
                case 2:
                    result += "hai ";
                    break;
                case 3:
                    result += "ba ";
                    break;
                case 4:
                    result += "bốn ";
                    break;
                case 5:
                    result += "năm ";
                    break;
                case 6:
                    result += "sáu ";
                    break;
                case 7:
                    result += "bảy ";
                    break;
                case 8:
                    result += "tám ";
                    break;
                case 9:
                    result += "chín ";
                    break;
            }
            System.out.println(result);
        }else{
            if (number==0){
                System.out.println("Không");
            }else {
                System.out.println("Vui lòng nhập lại số ");
            }
        }

    }
}
