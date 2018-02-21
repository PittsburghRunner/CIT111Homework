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
public class IfControl {
    
    public final static double PURCHASE_LIMIT = 200.00;
    
       public static void main(String[] args) {
        // TODO code application logic here
        
        double purchaseAmount = 0;
        double difference = 0;

        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("What is the amount you can afford?  $");
        try {
            purchaseAmount = userInputScanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Error in amount entered. Not a double");
        }
        difference = PURCHASE_LIMIT - purchaseAmount;
        if (difference > 0 ) {
            System.out.println("You can afford this! and you'll have $" + difference + " left");
        }
        else if (difference == 0 ) {
            System.out.println("You can afford this! but you'll have nothing left in your pocket");
        }
        else {
             System.out.println("You can't afford that save up $" + Math.abs(difference) + " more!");
        }
    }    
}
