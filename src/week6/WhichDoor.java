/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

import java.util.*;

import static week5.MathProblem.askAQuestion;
import static week6.SimpleMethod.generateBigNumber;

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
                    "           .----------------.         .----------------.          .----------------. \n"
                    + "          | .--------------. |       | .--------------. |        | .--------------. |\n"
                    + "          | |     __       | |       | |    _____     | |        | |    ______    | |\n"
                    + "          | |    /  |      | |       | |   / ___ `.   | |        | |   / ____ `.  | |\n"
                    + "          | |    `| |      | |       | |  |_/___) |   | |        | |   `'  __) |  | |\n"
                    + "          | |     | |      | |       | |   .'____.'   | |        | |   _  |__ '.  | |\n"
                    + "          | |    _| |_     | |       | |  / /____     | |        | |  | \\____) |  | |\n"
                    + "          | |   |_____|    | |       | |  |_______|   | |        | |   \\______.'  | |\n"
                    + "          | |              | |       | |              | |        | |              | |\n"
                    + "          | '--------------' |       | '--------------' |        | '--------------' |\n"
                    + "           '----------------'         '----------------'          '----------------'");

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
                    generateAsciiArt();
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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interuppted Exception: " + e);
            }
            System.out.println("\n\n\n");
        } //end while
        System.out.println("Thanks for playing!");
    }//close main method

    public static void generateAsciiArt() {
        String art = "*&^%$defaultArt%^&*";
        System.out.print("Enter any string of letters, numbers, and characters: ");
        try {
            Scanner inputScanner = new Scanner(System.in);
            art = inputScanner.next();
        } catch (Exception e) {
        }
        System.out.print("Enter your first name: ");
        try {
            Scanner inputScanner = new Scanner(System.in);
            art = art + inputScanner.next() + getReversedString(art);
        } catch (Exception e) {
        }

        for (int i = 1; i <= 10000000; i++) {
            System.out.print(art);
        }
    } ///close method

    /**
     * used from geeks for geeks site
     * https://www.geeksforgeeks.org/reverse-a-string-in-java-5-different-ways/
     * @param input accepts a string input to be reversed
     * @return
     */
    public static String getReversedString(String input) {
        String reversedString = "";
        char[] charArray = input.toCharArray();
        List<Character> inputArray = new ArrayList<>();

        for (char c : charArray) {
            inputArray.add(c);

        }

        Collections.reverse(inputArray);
        ListIterator listIterator = inputArray.listIterator();
        while (listIterator.hasNext()) {
            reversedString = reversedString + listIterator.next();
        }
        return reversedString;
    }

} // close class
