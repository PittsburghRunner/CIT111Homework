/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2maybe;

import java.util.Scanner;

/**
 *
 * @author christopher.eckles
 */
public class CheckValue {

    final static int GREAT_PLAYER = 50;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declare three int variables 
        int score = 0;
        Scanner keyScanner = new Scanner(System.in);
        System.out.println("What is the player's score? ");
        try {
            score = keyScanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error in answer. Not an Integer");
        }
        if (score >= GREAT_PLAYER) {
            System.out.println("Player is Great");
        } else {
            System.out.println("Player is not great. Try harder.");
        }

    } //close main method

} // close CheckValue Class
