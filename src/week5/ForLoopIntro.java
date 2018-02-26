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
public class ForLoopIntro {
    
       public static void main(String[] args) {
        // TODO code application logic here
        int loopControl = 0;
        Scanner userInputScanner = new Scanner(System.in);
        
        System.out.print("How many times do you want to loop? ");
        try {
            loopControl = userInputScanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error in integer entered. Not an integer");
        }
        
        for (int numLoops = 0; numLoops <= loopControl; numLoops++  ) {
            System.out.println("Value of numLoops: " + numLoops);
            
            if ((numLoops % 1000) == 0) {
                System.out.println("Still Working!");
            }
            
        } //end while
           System.out.println("I'm outside of the for loop!");
           System.out.println("Value of numLoops is not available outside of the for loop.");


    }    //end main

} //end class
