package _6_inheritance.pratice.th_1;

public class TestSquare {
    public static void main(String[] args) {
        Shape.Square square = new Shape.Square();
        System.out.println(square);

        square = new Shape.Square(4);
        System.out.println(square);

        square = new Shape.Square("yellow", true, 4.8);
        System.out.println(square);
    }
}
