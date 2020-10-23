package _4_class_and_object_in_java.exercise.bt_3;

public class TestFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        Fan fan2 = new Fan();
        fan2.setOn(false);
        fan2.setSpeed(1);
        fan2.setRadius(5);
        fan2.setColor("blue");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
