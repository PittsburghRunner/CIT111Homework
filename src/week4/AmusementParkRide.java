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
public class AmusementParkRide {
private static final int MIN_HEIGH_CM = 80;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int userHeight = 0;
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("What is your heigh in CM? ");
        try {
            userHeight = userInputScanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error in answer. Not an Integer");
        }
        if (userHeight >= MIN_HEIGH_CM) {
            System.out.println("Your heigh of " + userHeight + "cm means you can ride!");
        } else {
            System.out.println("Sorry, you're too short to ride at this time. Maybe next year!");
        }
    }
    
}
