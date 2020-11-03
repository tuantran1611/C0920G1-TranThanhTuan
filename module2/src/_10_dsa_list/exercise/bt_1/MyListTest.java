package _10_dsa_list.exercise.bt_1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>(10);
        listInteger.add(2);
        listInteger.add(4);
        listInteger.add(5);
        listInteger.add(6);
        listInteger.add(3);
        listInteger.add(8);
        listInteger.add(9);
        listInteger.add(10);
        listInteger.add(11);
        listInteger.add(12);
        System.out.println("Danh sách mảng ban đầu: ");
        listInteger.displayList();
        System.out.println();
        System.out.println("Giá trị phần tử xóa ra khỏi mảng: ");
        System.out.println(listInteger.remove(4));
        listInteger.add(6,14);
        System.out.println("Mảng sau khi thêm phần tử: ");
        listInteger.displayList();
        System.out.println();
        System.out.println("Kiểm tra size của mảng: ");
        System.out.println(listInteger.size());
        System.out.println("Kiểm tra số 15 có trong mảng không: ");
        System.out.println(listInteger.contains(15));
        System.out.println("Kiểm tra vị trí của số 11: ");
        System.out.println(listInteger.indexOf(11));
        System.out.println("Lấy ra giá trị của vị trí thứ 5 trong mảng: ");
        System.out.println(listInteger.get(5));
    }
}
