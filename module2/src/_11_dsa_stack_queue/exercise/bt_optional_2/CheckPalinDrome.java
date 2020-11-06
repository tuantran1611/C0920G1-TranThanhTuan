package _11_dsa_stack_queue.exercise.bt_optional_2;

import java.util.*;

public class CheckPalinDrome {
    public void checkPalinDrome(String sentence) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        boolean check = false;
        for (int i = 0; i < sentence.length(); i++) {
            queue.add(sentence.charAt(i));
            stack.push(sentence.charAt(i));
        }

        for (int i = 0; i < sentence.length(); i++) {
            if (stack.pop() == queue.poll()) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        if (check){
            System.out.println("Đây là chuỗi Palindrome");
        } else {
            System.out.println("Đây không phải là chuỗi Palindrome");
        }
    }
}
