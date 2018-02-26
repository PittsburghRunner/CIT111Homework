/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5;

import java.util.Scanner;

/**
 *
 * @author christopher.eckles
 */
public class RetirementAge {

    public static void main(String[] args) {
        // TODO code application logic here
        final double RETIREMENT_AGE = 65.5;
        double age = 0;
        Scanner userInputScanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your age to see if you can retire: ");
            try {
                age = userInputScanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Error in integer entered. Not a double");
            }

            if (age > RETIREMENT_AGE) {
                //if true
                System.out.println("You can retire!!");
                break;
            } else {
                System.out.println("Sorry Keep Working!");
            }

        }

    }    //end main

} //end class
