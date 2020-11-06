package _11_dsa_stack_queue.exercise.bt_1;

import java.util.Stack;

public class ReverseElementString {
    public static void main(String[] args) {
        Stack<String> wStack = new Stack<>();
        String s1 = "welcome to java world";
        String[] mWord = s1.split("\\s");
        for (String w : mWord){
            wStack.push(w);
        }
        for (int i = 0 ; i < mWord.length; i++){
            System.out.println(wStack.pop());
        }
    }
}
