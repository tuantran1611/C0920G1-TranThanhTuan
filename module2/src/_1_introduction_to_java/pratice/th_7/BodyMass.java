package introduction_to_java.pratice.th_7;

import java.util.Scanner;

public class BodyMass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight, height;
        System.out.println("Nhập vào trọng lượng cơ thể: ");
        weight = sc.nextDouble();
        System.out.println("Nhập vào chiều cao cơ thể: ");
        height = sc.nextDouble();
        double bmi = weight / Math.pow(height,2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}
