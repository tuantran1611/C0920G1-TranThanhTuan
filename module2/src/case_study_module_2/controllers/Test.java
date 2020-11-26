package case_study_module_2.controllers;

import case_study_module_2.commons.ValidateData;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        int i = 000;
////        Scanner scanner = new Scanner(System.in);
////        boolean check = false;
////        do {
////            System.out.println("Nhập giới tính: ");
////            String gender = scanner.nextLine();
////            if (ValidateData.validateGenderCustomer(gender)){
////                String[] str = (gender.toLowerCase()).split("");
////                System.out.println(str[0]);
////                StringBuilder genderNew = new StringBuilder(str[0].toUpperCase());
////                System.out.println(genderNew);
////                for ( int i = 1; i < str.length; i++){
////                    genderNew.append(str[i]);
////                }
////                System.out.println(genderNew);
////                check = true;
////            }
////
////        } while (!check);
//        System.out.println(i+1);

        int[] a = {5, 6, 7, 8};

        for (int i = 0; i < a.length; i++) {

            if (a[i] % 2 == 0) {

                continue;

            }
            System.out.println(i);
            ;
        }
    }
}
