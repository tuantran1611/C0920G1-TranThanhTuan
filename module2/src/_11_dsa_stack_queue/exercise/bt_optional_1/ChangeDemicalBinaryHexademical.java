package _11_dsa_stack_queue.exercise.bt_optional_1;

import java.util.Stack;

public class ChangeDemicalBinaryHexademical {
    public void changeDemicalToBinary(int num){
        Stack<Integer> stack = new Stack<>();
        int temp = num;
        while (num != 0){
            int d = num % 2;
            stack.push(d);
            num/=2;
        }
        System.out.print(temp + " Demical to Binary: ");
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public int ChangeBinaryToDemical(int num){
        int decimal = 0;
        int p = 0;
        while(true){
            if(num == 0){
                break;
            } else {
                int temp = num%10;
                decimal += temp*Math.pow(2, p);
                num = num/10;
                p++;
            }
        }
        return decimal;
    }

    public int ChangeHexaDemicalToDemical(String hexnum){
        String hstring = "0123456789ABCDEF";
        hexnum = hexnum.toUpperCase();
        int num = 0;
        for (int i = 0; i < hexnum.length(); i++)
        {
            char ch = hexnum.charAt(i);
            int n = hstring.indexOf(ch);
            num = 16*num + n;
        }
        return num;
    }

//    public int ChangeDemicalToHexaDemical(int num){
//
//    }
}
