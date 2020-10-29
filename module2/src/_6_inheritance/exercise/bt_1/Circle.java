package _6_inheritance.exercise.bt_1;

public class Circle {
    private double radius;
    private String color;

    public Circle(){
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color){
        this.color = color;
        this.radius = radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius = " + getRadius() +
                ", color = " + getColor() +
                ", area = " + getArea() +
                "}";
    }
}


