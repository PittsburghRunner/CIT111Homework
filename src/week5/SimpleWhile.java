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
public class SimpleWhile {
    

  
       public static void main(String[] args) {
        // TODO code application logic here
        int a = 0;
        int numLoops = 0;
        Scanner userInputScanner = new Scanner(System.in);
        
        System.out.print("How many times do you want to loop? ");
        try {
            numLoops = userInputScanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error in integer entered. Not an integer");
        }
        
        while (a < numLoops ) {
            System.out.println("a is: " + a);
            a++ ;
            
            if ((a % 1000) == 0) {
                System.out.println("Still Working!");
            }
            
        } //end while
           System.out.println("I'm outside of the while loop!");
           System.out.println("a is: " + a );


    }    //end main

} //end class
