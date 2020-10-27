package _6_inheritance.exercise.bt_2;

import java.util.Arrays;

// superclass( baseclass) Point2D
public class Point2D {
    private float x;
    private float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        this.x = 0.0f;
        this.y = 0.0f;
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

    public float[] getXY() {
        float[] arr = new float[2];
        arr[0] = x;
        arr[1] = y;
        return arr;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                Arrays.toString(getXY()) +
                '}';
    }

    // subclass Point3D
    public static class Point3D extends Point2D {
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
}
