package _6_inheritance.pratice.th_1;

public class Circle extends Shape {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double Area() {
        return Math.PI * radius * radius;
    }

    public double Perimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle {" +
                "with radius = " + getRadius() +
                ", which is a subclass of " + super.toString() +
                '}';
    }
}
