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

    // Class Cylinder

    public static class Cylinder extends Circle{
        private double height;

        public Cylinder(){
        }

        public Cylinder(double radius, double height){
            super(radius);
            this.height = height;
        }

        public Cylinder(double radius, String color, double height) {
            super(radius, color);
            this.height = height;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getVolume(){
            return  getArea()* height;
        }

        @Override
        public String toString() {
            return "Cylinder{" +
                    "height= " + getHeight() +
                    ", volume = " + getVolume() +
                    ", which is a subclass of " + super.toString() +
                    '}';
        }
    }
}


