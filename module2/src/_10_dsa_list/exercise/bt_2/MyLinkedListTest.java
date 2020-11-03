package _10_dsa_list.exercise.bt_2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> listLinked = new MyLinkedList<>(5);
        listLinked.addFirst(3);
        listLinked.addFirst(4);
        listLinked.addFirst(5);
        listLinked.addLast(6);
        listLinked.add(3,7);
        listLinked.add(4,8);
        listLinked.displayList();
        System.out.println();
        System.out.println(listLinked.removeFirst());
        listLinked.displayList();
        System.out.println();
        System.out.println(listLinked.removeLast());
        listLinked.displayList();
        System.out.println();
        System.out.println(listLinked.remove(2));
        System.out.println(listLinked.contains(8));
        System.out.println(listLinked.indexOf(8));
        System.out.println(listLinked.getFirst());
        System.out.println(listLinked.getLast());
        System.out.println(listLinked.get(1));
        listLinked.displayList();
        System.out.println();

        MyLinkedList<Integer> cloneLinkedList = listLinked.clone();
        cloneLinkedList.displayList();
    }
}
