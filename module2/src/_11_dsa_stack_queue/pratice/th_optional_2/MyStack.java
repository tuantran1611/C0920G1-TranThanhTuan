package _11_dsa_stack_queue.pratice.th_optional_2;

public class MyStack {
    private int[] arrs;
    private int size;
    private int index = 0;

    public MyStack(int size) {
        this.size = size;
        this.arrs = new int[this.size];
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            arrs[index] = element;
            index++;
            System.out.println("Element " + element + " is pushed in stack");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        return arrs[--index];
    }

    public int size(){
        return index;
    }

    public boolean isEmpty(){
        if (index == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if (index  == size){
            return true;
        }
        return false;
    }
}

