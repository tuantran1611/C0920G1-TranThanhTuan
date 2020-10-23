package _1_introduction_to_java.exercise.bt_2;

import java.util.Scanner;

public class SpellNumber2 {


    public static String read1To9(int number) {

        String result = "";
        switch (number) {
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
                result = "four";
                break;
            case 5:
                result = "five";
                break;
            case 6:
                result = "six";
                break;
            case 7:
                result = "seven";
                break;
            case 8:
                result = "eight";
                break;
            case 9:
                result = "nine";
                break;
        }

        return result;
    }

    public static String read10To19(int number) {
        String result = "";

        switch (number) {
            case 10:
                result = "ten";
                break;
            case 11:
                result = "eleven";
                break;
            case 12:
                result = "twelve";
                break;
            case 13:
                result = "thirteen";
                break;
            case 15:
                result = "fifteen";
                break;
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
                int remain = number % 10;
                result = read1To9(remain) + "teen";
                break;
        }

        return result;
    }

    public static String readTy(int number) {
        String result = "";

        switch (number) {
            case 20:
                result = "twenty";
                break;
            case 30:
                result = "thirty";
                break;
            case 40:
                result = "forty";
                break;
            case 50:
                result = "fifty";
                break;
            case 60:
            case 70:
            case 80:
            case 90:
                int first = number / 10;
                result = read1To9(first) + "ty";
                break;
        }

        return result;
    }

    public static String read21To99(int number) {

        int first = number / 10;
        first *= 10;
        int remain = number % 10;

        return readTy(first) + " " + read1To9(remain);
    }

    public static String read1To99(int number) {

        if (number < 10) {
            return read1To9(number);
        } else if (number >= 10 && number <= 19) {
            return read10To19(number);
        } else {
            return read21To99(number);
        }
    }

    public static String readHundred(int number) {
        return read1To9(number) + " hundred";
    }

    public static String read101To999(int number) {
        // 123
        int first = number / 100;
        int remain = number % 100;

        if (remain == 0) {
            return readHundred(first);
        } else {
            return readHundred(first) + " and " + read1To99(remain);
        }
    }

    public static void main(String[] args) {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập số bạn muốn đọc");
            int number = scanner.nextInt();
            System.out.println(read101To999(number));
        } while (true);

    }
}