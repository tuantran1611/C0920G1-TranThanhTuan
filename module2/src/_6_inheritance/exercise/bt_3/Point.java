package _6_inheritance.exercise.bt_3;

import java.util.Arrays;

public class Point {
    private float x;
    private float y;
    private float[] arr = new float[2];

    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY(){
        arr[0] = x;
        arr[1] = y;
        return arr;
    }

    public void setXY(float x, float y){
        arr[0] = x;
        arr[1] = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", arr=" + Arrays.toString(getXY()) +
                '}';
    }
}
