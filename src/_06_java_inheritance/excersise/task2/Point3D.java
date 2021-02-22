package _06_java_inheritance.excersise.task2;

import java.util.*;

public class Point3D extends Point2D {
    private float z = 0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setXYZ(float x, float y, float z) {
        setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
//        float[] result = Arrays.copyOf(getXY(), getXY().length + 1);
//        result[2] = z;
        return new float[]{getX(), getY(), z};
    }

    @Override
    public String toString() {
        return super.toString()
                + "[z="
                + z
                + "]";
    }
}
