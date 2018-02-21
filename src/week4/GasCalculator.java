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
        double gallonstoNextServiceStation = 0.0;
        double milesLeftInTank = 0.0;
        double milesLeftToDrive = 0.0;
        double milesToNextServiceStation = 0.0;
        double milesPerGallon = 28;

        Scanner userInputScanner = new Scanner(System.in);

        try {  //prompt and get values from user
            System.out.print("How many many miles-per-gallon does your car get? ");
            milesPerGallon = userInputScanner.nextDouble();
            System.out.print("How many gallons remain in your tank? ");
            gallonsOfGasLeft = userInputScanner.nextDouble();
            System.out.print("How many miles until the next service station? ");
            milesToNextServiceStation = userInputScanner.nextDouble();
        } catch (Exception e) {  //if they put something bad in.
            System.out.println("Error in entry. Not a double");
        } //close try catch
        if (gallonsOfGasLeft < 0 || milesToNextServiceStation < 0 || milesPerGallon < 0) {
        } else {
            milesLeftInTank = gallonsOfGasLeft * milesPerGallon;  // calculate total miles this car can drive without fill-up.

            if (milesLeftInTank < milesToNextServiceStation) {
                milesLeftToDrive = milesToNextServiceStation - milesLeftInTank; //subtract to get miles remaining 
                gallonstoNextServiceStation = Math.ceil(milesLeftToDrive / milesPerGallon);   //calculate size of gas can

                System.out.println("You're not going to make it! Better put your walking shoes on!");
                System.out.println("You'll be walking " + milesLeftToDrive + " more miles. You better have a " + gallonstoNextServiceStation + " gallon gas can.");
            } else {
                System.out.println("You're going to make it!");
            }
        } //close if else

    }  // close main
} // close class
