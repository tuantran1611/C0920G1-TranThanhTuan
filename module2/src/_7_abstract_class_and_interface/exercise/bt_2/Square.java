package _7_abstract_class_and_interface.exercise.bt_2;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public String toString() {
        return "Square has area is: " +
                this.getArea();
    }

    @Override
    public void howToColor() {
        System.out.println(">>>Color all four sides");
    }
}

