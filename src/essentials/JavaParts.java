/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essentials;

/**
 *
 * @author christopher.eckles
 */
public class JavaParts {
    final static int MULTIPLIER = 3;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declare three int variables 
        int macUsers, pcUsers, linuxUsers;
       
       // assign values
       linuxUsers = 98343 ;
       macUsers = linuxUsers * MULTIPLIER;
       pcUsers = macUsers * MULTIPLIER;
       
       // display the output with println
        System.out.println("We've got " + linuxUsers + " Linux Users");
        System.out.println("Therefore, we've also got " + macUsers + " Mac Users");
        System.out.println("And should have " + pcUsers + " PC Users");
               
    } //close main method
    
} // close JavaParts Class
