package introduction_to_java.exercise.bt_2;

import java.util.Scanner;

public class SpellNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("Nhập số cần đọc lớn hơn 0");
            num = sc.nextInt();
        } while (num < 0);
        if (num < 10) {
            switch (num) {
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                default:
                    System.out.println("nine");
            }
        } else if (num < 20) {
            int ch = num % 10;
            switch (ch) {
                case 0:
                    System.out.println("ten");
                    break;
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("fourteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                case 6:
                    System.out.println("sixteen");
                    break;
                case 7:
                    System.out.println("seventeen");
                    break;
                case 8:
                    System.out.println("eighteen");
                    break;
                default:
                    System.out.println("nineteen");
                    break;
            }
        } else if (num < 100) {
            int ch = num / 10;
            int dv = num % 10;
            switch (ch) {
                case 2:
                    System.out.print("twenty");
                    break;
                case 3:
                    System.out.print("Thirty");
                    break;
                case 4:
                    System.out.print("Forty");
                    break;
                case 5:
                    System.out.print("Fifty");
                    break;
                case 6:
                    System.out.print("Sixty");
                    break;
                case 7:
                    System.out.print("Seventy");
                    break;
                case 8:
                    System.out.print("Eighty");
                    break;
                case 9:
                    System.out.print("Ninety");
                    break;
            }
            switch (dv) {
                case 0:
                    System.out.println(" ");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
            }
        } else if (num < 1000) {
            int tr = num / 100;
            int ch = (num % 100) / 10;
            int dv = num % 10;
            switch (tr) {
                case 1:
                    System.out.print("One hundred and ");
                    break;
                case 2:
                    System.out.print("Two hundred and ");
                    break;
                case 3:
                    System.out.print("Three hundred and ");
                    break;
                case 4:
                    System.out.print("Four hundred and ");
                    break;
                case 5:
                    System.out.print("Five hundred and ");
                    break;
                case 6:
                    System.out.print("Six hundred and ");
                    break;
                case 7:
                    System.out.print("Seven hundred and ");
                    break;
                case 8:
                    System.out.print("Eight hundred and ");
                    break;
                case 9:
                    System.out.print("Nine hundred and ");
                    break;
            }
            switch (ch) {
                case 0:
                    System.out.print(" ");
                    break;
                case 1:
                    if (dv == 0) {
                        System.out.print("ten");
                        break;
                    } else if (dv == 1) {
                        System.out.print("eleven");
                        break;
                    } else if (dv == 2) {
                        System.out.print("twevle");
                        break;
                    } else if (dv == 3) {
                        System.out.print("thirteen");
                        break;
                    } else if (dv == 4) {
                        System.out.print("fourteen");
                        break;
                    } else if (dv == 5) {
                        System.out.print("fifteen");
                        break;
                    } else if (dv == 6) {
                        System.out.print("sixteen");
                        break;
                    } else if (dv == 7) {
                        System.out.print("seventeen");
                        break;
                    } else if (dv == 8) {
                        System.out.print("eighteen");
                        break;
                    } else {
                        System.out.print("nineteen");
                        break;
                    }
                case 2:
                    System.out.print("twenty");
                    break;
                case 3:
                    System.out.print("thirty");
                    break;
                case 4:
                    System.out.print("forty");
                    break;
                case 5:
                    System.out.print("fifty");
                    break;
                case 6:
                    System.out.print("sixty");
                    break;
                case 7:
                    System.out.print("seventy");
                    break;
                case 8:
                    System.out.print("eighty");
                    break;
                case 9:
                    System.out.print("ninety");
                    break;
            }
            if (ch != 1) {
                switch (dv) {
                    case 0:
                        System.out.println(" ");
                        break;
                    case 1:
                        System.out.println("one");
                        break;
                    case 2:
                        System.out.println("two");
                        break;
                    case 3:
                        System.out.println("three");
                        break;
                    case 4:
                        System.out.println("four");
                        break;
                    case 5:
                        System.out.println("five");
                        break;
                    case 6:
                        System.out.println("six");
                        break;
                    case 7:
                        System.out.println("seven");
                        break;
                    case 8:
                        System.out.println("eight");
                        break;
                    case 9:
                        System.out.println("nine");
                        break;
                }
            } else {
                System.out.println(" ");
            }
        }
    }
}