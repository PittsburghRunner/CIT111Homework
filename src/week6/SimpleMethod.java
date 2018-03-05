/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author christopher.eckles
 */
public class SimpleMethod {

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
                    printStatement();
                    break;
                case 2:
                    generateBigNumber();
                    break;
                case 3:
                    printStatement();
                    generateBigNumber();
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

//method prints out a prompt phrase to console 
    public static void printStatement() {
        System.out.println("*******Inside printStatement********");
        System.out.println("Where There's a will There's a way.");
    } //close printStatement method

// generate a random big number
    public static BigInteger generateBigNumber() {
        System.out.println("*******Inside generateBigNumber*******");
        // create a random number
        Random r = new Random();
        //create a BigInteger object to do math with huge numbers
        BigInteger bigInt = new BigInteger(1000, r);
        //print the value
        System.out.println(bigInt);

        return bigInt;

    }

} //close class

