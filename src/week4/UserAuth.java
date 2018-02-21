/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import java.util.Scanner;

public class UserAuth {

    private static final String USER_NAME = "javaghost";
    private static final String PASSWORD = "ic0d3";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String userNameInput;
        String passwordInput;
        Scanner userInputScanner = new Scanner(System.in);

        for (int passwordTrys = 3; passwordTrys > 0; passwordTrys--) {

            System.out.print("What is your username? ");
            userNameInput = userInputScanner.next();

            System.out.print("What is your password? ");
            passwordInput = userInputScanner.next();

            if (USER_NAME.equals(userNameInput) && PASSWORD.equals(passwordInput)) {
                System.out.println("You're logged in!");
                break;
            } else {
                System.out.println("Invalid username/password combination.");
                System.out.println("You have " + (passwordTrys - 1) + " more trys.");
            } //close if else
        }//close for

    } //close method
} //close class
