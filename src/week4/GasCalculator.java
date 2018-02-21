/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import java.util.Scanner;

/**
 *
 * @author christopher.eckles
 */
public class GasCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double gallonsOfGasLeft = 0.0;
        double milesLeft = 0.0;
        double milesToNextServiceStation = 0.0;
        double milesPerGallon = 28;

        Scanner userInputScanner = new Scanner(System.in);

        try {
            System.out.print("How many many miles-per-gallon does your car get? ");
            milesPerGallon = userInputScanner.nextDouble();
            System.out.print("How many gallons remain in your tank? ");
            gallonsOfGasLeft = userInputScanner.nextDouble();
            System.out.print("How many miles until the nest service station? ");
            milesToNextServiceStation = userInputScanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Error in entry. Not a double");
        } //close try catch
        if (gallonsOfGasLeft < 0 || milesToNextServiceStation < 0 || milesPerGallon < 0) {
        } else {
            milesLeft = gallonsOfGasLeft * milesPerGallon;

            if (milesLeft < milesToNextServiceStation) {
                System.out.println("You're not going to make it! Better put your walking shoes on!");
            } else {
                System.out.println("You're going to make it!");
            }
        } //close if else

    }  // close main
} // close class
