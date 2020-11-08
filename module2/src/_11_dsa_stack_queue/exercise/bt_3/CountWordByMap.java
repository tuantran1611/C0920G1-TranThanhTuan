package _11_dsa_stack_queue.exercise.bt_3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWordByMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập một chuỗi cần kiểm tra: ");
        String str = sc.nextLine().toLowerCase();
        String[] mWord = str.split("\\s");
        Map<String, Integer> treeMap = new TreeMap<>();
        int count = 1;
        for (String word : mWord) {
            if (treeMap.containsKey(word)) {
                treeMap.replace(word, treeMap.get(word) + 1);
            } else {
                treeMap.put(word, count);
            }
        }
        treeMap.forEach((key, value) -> System.out.println("Chữ : " + key + ", có " + value + " chữ"));
    }
}
