package _11_dsa_stack_queue.exercise.bt_optional_3;

import java.util.Stack;

public class BracketUseStack {

    public boolean checkBracket(String str) {
        Stack<Character> bStack = new Stack<>();
        boolean check = false;
        char sym = 0;
        char left;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                sym = str.charAt(i);
                bStack.push(sym);
            } else if (str.charAt(i) == ')') {
                if (bStack.empty()) {
                    check = false;
                } else {
                    left = bStack.pop();
                }
                if (sym == left){
                    return false;
                }

            }
        }
        return check;
    }

}
