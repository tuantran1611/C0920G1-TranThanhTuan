package _6_inheritance.pratice.th_1;

public class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this.color = "green";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }


    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public boolean isFilled() {

        return filled;
    }

    public void setFilled(boolean filled) {

        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }

    // Class Circle
    public static class Circle extends Shape {
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

    // Class Rectangle
    public static class Rectangle extends Shape {
        private double width;
        private double length;

        public Rectangle() {
            width = 1.0;
            length = 1.0;
        }

        public Rectangle(double width, double length) {
            this.width = width;
            this.length = length;
        }

        public Rectangle(String color, boolean filled, double width, double length) {
            super(color, filled);
            this.width = width;
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getArea() {
            return width * length;
        }

        public double getPerimeter() {
            return 2 * (width + length);
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "width=" + width +
                    ", length=" + length +
                    ", which is a subclass of " + super.toString() +
                    '}';
        }
    }

    // Class Square
    public static class Square extends Rectangle {
        public Square() {
        }

        public Square(double side) {
            super(side, side);
        }

        public Square(String color, boolean filled, double side) {
            super(color, filled, side, side);
        }

        public double getSide(){
            return getWidth();
        }
        public void setSide(double side){
            setWidth(side);
            setLength(side);
        }

        @Override
        public String toString() {
            return "Square{" +
                    "side = " + getSide() +
                    ", which is a subclass of " + super.toString() +
                    '}';
        }
    }
}

