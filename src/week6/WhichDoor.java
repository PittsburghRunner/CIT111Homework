/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

import java.util.Scanner;

import static week5.MathProblem.askAQuestion;
import static week6.SimpleMethod.generateBigNumber;
import static week6.SimpleMethod.printStatement;

/**
 *
 * @author christopher.eckles
 */
public class WhichDoor {

    public static void main(String[] args) {
        //make a scanner object
        int choice = 0;
        System.out.println("Starting program");

        while (choice != 9) {
            //tell user the options
            System.out.println("Pick a door.");
            System.out.println(
"██████████  ████████████    ████████████ \n" +
"█    █╗     █  █  ██████╗    █    █  ██████╗   █\n" +
"█  ███║    █  █  ╚════██╗   █    █  ╚════██╗ █\n" +
"█  ╚██║    █  █   █████╔╝   █    █  █████╔╝   █\n" +
"█   ██║     █  █   ██╔═══╝   █    █   ╚═══██╗  █\n" +
"█   ██║     █  █  ███████╗  █    █ ██████╔╝   █\n" +
"█   ╚═╝     █  █   ╚══════╝ █    █  ╚═════╝   █\n" +
"██████████  ████████████    ████████████");                            

            System.out.print("Type your choice and press enter: ");
            //get integer from user
            try {
                Scanner inputScanner = new Scanner(System.in);
                choice = inputScanner.nextInt();
            } catch (Exception e) {
            }

            switch (choice) {
                case 1:
                    askAQuestion();
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
            //sleep for 2 seconds
            try {
            Thread.sleep(2000); }
            catch (InterruptedException e){
                System.out.println("Interuppted Exception: " + e);
            }
            System.out.println("\n\n\n");
        } //end while
        System.out.println("end of main");
    }//close main method
    
    public static void asciiArt(String art){
        for(int i=1; i <= 10000000; i++){
            System.out.print(art);
        }
    } ///close method

} // close class
