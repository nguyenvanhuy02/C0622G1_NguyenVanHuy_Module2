package ss2_loop.exercise;


public class ShowsPrime100 {
    public static void main(String[] args) {
        System.out.println("Hiển thị các số dưới 100");


        for (int i = 2; i < 100 ; i++) {
            int count=0;
            for (int j = 2; j <= i ; j++) {
                if (i%j == 0){
                    count++;
                }
            }
            if (count == 1){
                System.out.println(i+"");
            }

        }
    }
}
