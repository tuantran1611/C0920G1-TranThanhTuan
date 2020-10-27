package _6_inheritance.pratice.th_1;

public class TestRectangle {
    public static void main(String[] args) {
        Shape.Rectangle rectangle = new Shape.Rectangle();
        System.out.println(rectangle);

        rectangle = new Shape.Rectangle(2.3 , 5.8);
        System.out.println(rectangle);

        rectangle = new Shape.Rectangle("orange",false, 2.5,3.8);
        System.out.println(rectangle);
    }
}
