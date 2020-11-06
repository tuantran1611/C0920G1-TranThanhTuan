//package _11_dsa_stack_queue.exercise.bt_2;
//
//public class LinkListQueue {
//    static class Node {
//        private int data;
//        private Node link;
//
//    }
//
//    static class Queue {
//        private Node front;
//        private Node rear;
//    }
//
//    public void enQueue(Queue q, int value) {
//        Node temp = new Node();
//        temp.data = value;
//        if (q.front == null) {
//            q.front = temp;
//        } else {
//            q.rear.link = temp;
//        }
//        q.rear = temp;
//        q.rear.link = q.front;
//    }
//
//    public int deQueue(Queue q) {
//        if (q.front == null) {
//            System.out.println("Queue is empty");
//        }
//        int value;
//        if (q.front == q.rear) {
//            value = q.front.data;
//            q.front = null;
//            q.rear = null;
//        } else {
//            value = q.front.data;
//            q.front = q.front.link;
//            q.rear.link = q.front;
//        }
//        return value;
//    }
//
//    public void displayQueue(Queue q) {
//        Node temp = q.front;
//        while (temp.link != q.front) {
//            System.out.println(temp.data);
//            temp = temp.link;
//        }
//        System.out.println(temp.data);
//    }
//
//    public static void main(String[] args) {
//        LinkListQueue queue = new LinkListQueue();
//        queue.
//
//
//
//
//    }
//}
