package _9_automated_testing_and_tdd.exercise.bt_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void testFindNextDay1Month1Year2018() {
        int day = 1;
        int month = 1;
        int year = 2018;

        String expected = "Ngày " + 2 + " tháng " + 1 + " năm " + 2018;
        String result = NextDayCalculator.findNextDay(day, month, year);

        assertEquals(expected, result);
    }

    @Test
    void testFindNextDay31Month1Year2018() {
        int day = 31;
        int month = 1;
        int year = 2018;

        String expected = "Ngày " + 1 + " tháng " + 2 + " năm " + 2018;
        String result = NextDayCalculator.findNextDay(day, month, year);

        assertEquals(expected, result);
    }


    @Test
    void testFindNextDay30Month4Year2018() {
        int day = 30;
        int month = 4;
        int year = 2018;

        String expected = "Ngày " + 1 + " tháng " + 5 + " năm " + 2018;
        String result = NextDayCalculator.findNextDay(day, month, year);

        assertEquals(expected, result);
    }

    @Test
    void testFindNextDay28Month2Year2018() {
        int day = 28;
        int month = 2;
        int year = 2018;

        String expected = "Ngày " + 1 + " tháng " + 3 + " năm " + 2018;
        String result = NextDayCalculator.findNextDay(day, month, year);

        assertEquals(expected, result);
    }

    @Test
    void testFindNextDay29Month2Year2020() {
        int day = 29;
        int month = 2;
        int year = 2020;

        String expected = "Ngày " + 1 + " tháng " + 3 + " năm " + 2020;
        String result = NextDayCalculator.findNextDay(day, month, year);

        assertEquals(expected, result);
    }

    @Test
    void testFindNextDay31Month12Year2018() {
        int day = 31;
        int month = 12;
        int year = 2018;

        String expected = "Ngày " + 1 + " tháng " + 1 + " năm " + 2019;
        String result = NextDayCalculator.findNextDay(day, month, year);

        assertEquals(expected, result);
    }
}