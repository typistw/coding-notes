package com.effective.chapterVI;

/*
 * @author：jinsheng
 * @date：2022/09/04 16:25
 */
public enum  Planet {

    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.054e6),
    EARTH(5.302e+23, 2.439e6),
    MARS(6.302e+23, 2.439e6),
    JUPITER(7.302e+23, 2.439e6),
    SATURN(8.302e+23, 2.439e6),
    URANUS(9.302e+23, 2.439e6),
    NEPTUNE(3.302e+23, 2.439e6),
    ;

    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    private static  final double G = 6.673003E-11;

    Planet(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass /(radius * radius);
    }

    public double mass(){
        return  mass;
    }

    public double radius(){
        return radius;
    }

    public double surfaceGravity(){
        return surfaceGravity;
    }

    public double surfaceWeight(double mass){
        return  mass * surfaceGravity;
    }
}
