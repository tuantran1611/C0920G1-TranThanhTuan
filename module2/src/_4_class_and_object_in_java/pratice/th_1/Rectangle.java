package _4_class_and_object_in_java.pratice.th_1;

import java.util.Scanner;

public class Rectangle {
    double width, height;

    public Rectangle(){
    }

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return this.width * this.height;
    }
    public double getPerimeter(){
        return 2*(this.width + this.height);
    }
    public String display(){
        return "Ractangle{" + "width = " + this.width + ", height = " + this.height + "}";
    }
}