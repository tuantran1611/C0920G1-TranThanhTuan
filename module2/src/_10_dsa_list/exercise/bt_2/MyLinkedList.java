package _10_dsa_list.exercise.bt_2;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public MyLinkedList() {
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
        this.numNodes++;
    }

    public void addFirst(E element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        this.numNodes++;
    }

    public void addLast(E element) {
        Node newNode = new Node(element);
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        temp.next = newNode;
        this.numNodes++;
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index >= numNodes) {
            addLast(element);
        } else {
            Node temp = head;
            Node holder;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            this.numNodes++;
        }
    }

    public E removeFirst() {
        if (numNodes == 0) {
            return null;
        } else {
            Node temp = head;
            head = head.next;
            numNodes--;
            return (E) temp.data;
        }
    }

    public E removeLast() {
        if (numNodes == 0) {
            return null;
        } else if (numNodes == 1) {
            Node temp = head;
            head = null;
            numNodes--;
            return (E) temp.data;
        } else {
            Node temp = head;
            for (int i = 0; i < numNodes - 2; i++) {
                temp = temp.next;
            }
            Node holder = temp.next;
            temp.next = null;
            numNodes--;
            return (E) holder.data;
        }
    }

    public E remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Errow " + index);
        } else if (index == 0) {
            return removeFirst();
        } else if (index == numNodes - 1) {
            return removeLast();
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node holder = temp.next;
            temp.next = temp.next.next;
            numNodes--;
            return (E) holder.data;
        }
    }

    public boolean remove(Object element) {
        if (head.data.equals(element)){
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null){
                if (temp.next.data.equals(element)){
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data == o) {
                return true;
            } else {
                temp = temp.next;
                if (temp == o) {
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        int holder = 0;
        if (temp.data == o) {
            holder = 0;
        } else {
            for (int i = 1; i < numNodes; i++) {
                temp = temp.next;
                if (temp.data == o) {
                    holder = i;
                }
            }
        }
        return holder;
    }

    public E getFirst() {
        return (E) head.data;
    }

    public E getLast() {
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E get(int index) {
        Node temp = head;
        if (index < 0 || index > numNodes) {
            return null;
        } else if (index == 0) {
            return getFirst();
        } else {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return (E) temp.data;
        }
    }

    public MyLinkedList<E> clone(){
        if (numNodes == 0){
            throw new NullPointerException("LinkedList is null");
        }
        MyLinkedList<E> returnLinkedList = new MyLinkedList<>();
        Node temp = head;
        returnLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null){
            returnLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    public void clear() {

    }

    public void displayList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
