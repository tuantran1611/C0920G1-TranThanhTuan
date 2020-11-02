package _9_automated_testing_and_tdd.exercise.bt_1;


public class NextDayCalculator {
    public static String findNextDay(int day, int month, int year) {
        boolean isLeapYear = isLeapYear(year);
        switch (month) {
            case 2:
                if (!isLeapYear) {
                    if (day == 28) {
                        day = 1;
                        month += 1;
                    } else {
                        day += 1;
                    }
                } else {
                    if (day == 29) {
                        day = 1;
                        month += 1;
                    } else {
                        day += 1;
                    }
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 30) {
                    day = 1;
                    month += 1;
                }
                break;
            case 12:
                if (day == 31) {
                    day = 1;
                    month = 1;
                    year += 1;
                }
                break;
            default:
                if (day == 31) {
                    day = 1;
                    month += 1;
                } else {
                    day += 1;
                }
                break;
        }
        return "Ngày " + day + " tháng " + month + " năm " + year;
    }

    private static boolean isLeapYear(int year) {
        boolean isLeapYear = false;
        boolean isDiv4 = year % 4 == 0;
        if (isDiv4) {
            boolean isDiv100 = year % 100 == 0;
            if (isDiv100) {
                boolean isDiv400 = year % 400 == 0;
                if (isDiv400) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        return isLeapYear;
    }
}
