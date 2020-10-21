package _2_loop_in_java.exercise.bt_3;

public class DisplayPrime100 {
    public static void main(String[] args) {
        boolean check = false;
        int n = 2;
        while (n < 100) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.print(n + " ");
            }
            check = false;
            n++;
        }
    }
}
