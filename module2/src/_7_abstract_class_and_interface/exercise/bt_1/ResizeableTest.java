package _7_abstract_class_and_interface.exercise.bt_1;

import java.util.Arrays;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1);
        shapes[1] = new Rectangle(2,3);
        shapes[2] = new Square(3);

        for (Shape shape : shapes){
            shape.resize(100);
        }

        System.out.println(Arrays.toString(shapes));
    }
}
