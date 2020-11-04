package _10_dsa_list.exercise.bt_1;


import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapa();
        }
        for (int i = size - 1; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E remove(int index) {
        E temp = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return temp;
    }

    public int size() {
        return this.size;
    }

    public MyList<E> clone() {
        if (size == 0){
            throw new NullPointerException("List is null");
        }
        MyList<E> returnList = new MyList<>(this.size);
        returnList.elements = Arrays.copyOf(this.elements,this.size);
        returnList.size = this.size;
        return returnList;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size - 1; i++) {
            if (elements[i] == o) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E o) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = o;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + index);
        }
        return (E) elements[index];
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void displayList() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
    }
}
