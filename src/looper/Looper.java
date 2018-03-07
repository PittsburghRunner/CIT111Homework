/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package looper;

import java.util.Scanner;
import static week6.SimpleMethod.generateBigNumber;

/**
 *
 * @author christopher.eckles
 */
public class Looper {
   public static void main(String[] args) {
        //make a scanner object
        int choice = 0;
        System.out.println("Starting program");

        while (choice == 0) {
            Scanner inputScanner = new Scanner(System.in);

            //tell user the options
            System.out.println("Choose a Method to run");
            System.out.println("1 - get a special phrase");
            System.out.println("2 - Get a random big number");
            System.out.println("3 - Run both");
            System.out.println("9 - To Exit");

            System.out.print("Type your choice and press enter: ");
            //get integer from user
            try {
                choice = inputScanner.nextInt();
            } catch (Exception e) {
            }

            switch (choice) {
                case 1:

                    break;
                case 2:
                    generateBigNumber();
                    break;
                case 3:

                    break;
                case 9:
                    System.out.println("exiting...");
                    break;
                default:
                    System.out.println("No valid input..");
                    choice = 0;
            }
        }
        System.out.println("end of main");
    }//close main method
    
}
