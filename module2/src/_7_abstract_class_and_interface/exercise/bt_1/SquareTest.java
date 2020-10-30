package _7_abstract_class_and_interface.exercise.bt_1;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(4);
        System.out.println(square);

        square = new Square("yellow", true, 4.8);
        System.out.println(square);
    }
}
