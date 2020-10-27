package _6_inheritance.exercise.bt_3;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(2,3,1,1);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());
    }
}
