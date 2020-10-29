package _6_inheritance.exercise.bt_2;

import java.util.Arrays;

public class Point3D extends Point2D{
    private float z;
    private float[] arr = new float[3];

    public Point3D() {
        this.z = 0.0f;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(float z) {
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ(){
        arr[0]= super.getXY()[0];
        arr[1]= super.getXY()[1];
        arr[2] = z;
        return arr;
    }

    public void setXYZ(float x, float y, float z){
        super.setXY(x , y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                Arrays.toString(getXYZ()) +
                '}';
    }
}
