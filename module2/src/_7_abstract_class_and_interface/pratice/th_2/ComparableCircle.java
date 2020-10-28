package _7_abstract_class_and_interface.pratice.th_2;
import _6_inheritance.pratice.th_1.*;

public class ComparableCircle extends Circle
        implements Comparable<ComparableCircle>{
    public ComparableCircle() {
    }

    public ComparableCircle(double radius){
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()){
            return 1;
        } else if (getRadius() < o.getRadius()){
            return -1;
        } else {
            return 1;
        }
    }
}
