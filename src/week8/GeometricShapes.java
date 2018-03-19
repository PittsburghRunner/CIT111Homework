/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8;

import java.util.Scanner;

/**
 *
 * @author christopher.eckles
 */
public class GeometricShapes {

    private final static double PI = 3.1416;

    public static void main(String[] args) {
        //caculate cube volume
        System.out.println("First, we'll caclulate the volume of a cube.");
        Double cubeSide = askForDouble("length of this cubes side");
        System.out.println("The volume of a cube with the side length of " + cubeSide + " is: " + calculateVolumeOfCube(cubeSide));

        System.out.println("");
        System.out.println("");

        //calculate cylinder volume
        System.out.println("Next, we'll calculate the volume of a Cylinder");
        Double radiusCylinder = askForDouble("radius of cylinder");
        Double heightCylinder = askForDouble("height of cylinder");
        System.out.println("The volume of this cylinder is: " + calculateVolumeOfCylinder(radiusCylinder, heightCylinder));

        System.out.println("");
        System.out.println("");
        
        //calculate trapezoid
        System.out.println("Finally, we'll calculate the area of a Trapezoid");
        Double b1OfTrapezoid = askForDouble("width of the top of the trapezoid");
        Double b2OfTrapezoid = askForDouble("width of the bottom of the trapezoid");
        Double heightOfTrapezoid = askForDouble("height of the trapezoid");
        System.out.println("The area of this trapezoid is: " + calculateAreaOfTrapezoid(b1OfTrapezoid, b2OfTrapezoid, heightOfTrapezoid));

        System.out.println("");
        System.out.println("");
    } //end main

    private static double calculateVolumeOfCube(double sideLength) {
        double cube = sideLength * sideLength * sideLength;
        return cube;

    } //end calulateVolumeOfCube

    private static double calculateVolumeOfCylinder(double radius, double height) {
        double cylinderVolume = PI * (radius * radius) * height;
        return cylinderVolume;
    } //end calculateVolumeOfCylinder

    private static double calculateAreaOfTrapezoid(double b1, double b2, double height) {
        double trapezoidVolume = (0.5) * (b1 + b2) * height;
        return trapezoidVolume;
    } //end calculateVolumeOfTrapezoid

    private static double askForDouble(String nameOfDouble) {
        // call next to gather a String and store the result
        // instring type variable
        Scanner inputScanner = new Scanner(System.in);
        // call next to gather a String and store the result
        // instring type variable
        System.out.print("Enter the " + nameOfDouble + ": ");
        return inputScanner.nextDouble();
    } // end askForDouble

} //end class

