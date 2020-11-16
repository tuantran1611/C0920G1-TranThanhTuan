package _17_io_binary_file.exercise.bt_2_optional;

import java.io.File;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("Nhập đường link file nguồn: ");
        File sourPath = new File(new Scanner(System.in).nextLine());
        System.out.println("Nhập đường link file đích đến: ");
        File destPath = new File(new Scanner(System.in).nextLine());
        new CopyFileBinary().copyFileBinary(sourPath,destPath);
    }
}
