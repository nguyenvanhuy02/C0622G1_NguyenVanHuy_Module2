package ss8_clean_code_refactoring.practice.refactoring_variable;

public class ádasd {
    public static void main(String[] args) {
        int [] n = {1,2,3,3};
        int kt=1;

        for (int i = 0; i < n.length / 2; i++) {
            if (n[i] != n[n.length - i - 1]) {
                kt = 0;
                break;
            }
        }

        if (kt == 0) {
            System.out.println("Mảng một chiều vừa nhập không là mảng đối xứng");
        } else {
            System.out.println("Mảng một chiều vừa nhập là mảng đối xứng");
        }
    }
}
