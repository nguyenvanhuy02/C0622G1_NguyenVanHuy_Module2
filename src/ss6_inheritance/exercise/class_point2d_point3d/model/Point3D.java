package ss6_inheritance.exercise.class_point2d_point3d.model;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x , float y , float z){
        this.z = z;
        super.setX(x);
        super.setY(y);
    }
    public float[] getXYZ(){
        float[] arrayXYZ = {super.getX(),super.getY(),z};
        return arrayXYZ;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getX()+
                "y=" + getY()+
                "z=" + z +
                '}'+ Arrays.toString(getXYZ())
                ;
    }
}
