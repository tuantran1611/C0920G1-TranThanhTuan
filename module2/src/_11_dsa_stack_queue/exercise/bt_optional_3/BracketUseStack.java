package _11_dsa_stack_queue.exercise.bt_optional_3;

import java.util.Stack;

public class BracketUseStack {

    public boolean checkBracket(String str) {
        Stack<Character> bStack = new Stack<>();
        boolean check = false;
        char sym = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                sym = str.charAt(i);
                bStack.push(sym);
            } else if (str.charAt(i) == ')') {
                if (bStack.empty()) {
                    check = false;
                    break;
                } else {
                    char left = bStack.pop();
                    if (left == sym){
                        check = true;
                    } else {
                        check = false;
                    }
                }
            }
        }
        return check;
    }

    public static void main(String[] args) {
        BracketUseStack bracketUseStack = new BracketUseStack();
        System.out.println(bracketUseStack.checkBracket("s * (s – a) * (s – b * (s – c)"));
        System.out.println(bracketUseStack.checkBracket("s * (s – a) * s – b) * (s – c)"));
        System.out.println(bracketUseStack.checkBracket("(– b + (b^2 – 4*a*c)^(0.5/ 2*a))"));
        System.out.println(bracketUseStack.checkBracket("(– b + (b2 – 4*a*c)^0.5) / 2*a"));
    }
}
