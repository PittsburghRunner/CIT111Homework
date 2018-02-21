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
public class SpeedEnforcement {
private static final int MAX_SPEED_LIMIT = 55;
private static final int MIN_SPEED_LIMIT = 40;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int carSpeed = 0;
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("What is the car's speed? ");
        try {
            carSpeed = userInputScanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error in speed. Not an Integer");
        }
        
        if (carSpeed == 0 ) {
            System.out.println("Car is not moving. You better be on the side of the road.");
        }
        else if (carSpeed > MAX_SPEED_LIMIT) {
            System.out.println("Car is traveling over the limit!");
        } else {
            if (carSpeed < MIN_SPEED_LIMIT) {
             System.out.println("Car is moving too slow! Increase your speed to at least 40mph, or move over to the far right lane and put your flashers on.") ;   
            } else {
                System.out.println("Car is within appropriate speed range.");
            }
        }
    }    
}
