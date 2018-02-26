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
public class CanWeBeFriends {

    final static int POINTVALUE = 25;
    final static int POINTSTOBEAT = 100;

    public static void main(String[] args) {
        // TODO code application logic here
        String[] questionsToAsk = {"Do you like to run?", "Do you have a bike?", "Do you like superhero movies?", "Do you like rock climbing?", "Do you like the Beach?"};

        Scanner userInputScanner = new Scanner(System.in);
        int totalPoints = 0;
        String answer;
        System.out.println("Enter Yes or No for each question to see if we can be friends ");
        System.out.println("");

        for (String question : questionsToAsk) {

            System.out.print(question + " ");
            try {
                answer = userInputScanner.next();

                if (answer.toLowerCase().equals("yes")) {
                    System.out.println("Thats great! Me too!");
                    totalPoints = totalPoints + POINTVALUE;
                } else {
                    System.out.println("Thats ok, not everyone does.");
                } //end if else
            } catch (Exception e) {
                System.out.println("Not a valid answer... next question...");
            } //end try catch
            System.out.println("Current Points " + totalPoints);

        } // end for

        System.out.println("You scored " + totalPoints);

        if (totalPoints >= POINTSTOBEAT) {
            System.out.println("You can be my friend!");
        } else {
            System.out.println("You cannot be my friend. I'm sure we have nothing in common.");
        }

    } //end main

} //end class
