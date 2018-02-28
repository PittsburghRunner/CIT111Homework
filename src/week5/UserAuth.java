/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5;

import java.util.Scanner;

public class UserAuth {

    private static final String USER_NAME = "myusername";
    private static final String PASSWORD = "mypassword";
    private static final int MAX_PASSOWRD_TRYS = 3;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String userNameInput;
        String passwordInput;
        int passwordAttempts = 0 ;
        Scanner userInputScanner = new Scanner(System.in);

        while (passwordAttempts < MAX_PASSOWRD_TRYS) {

            System.out.print("What is your username? ");
            userNameInput = userInputScanner.next();

            System.out.print("What is your password? ");
            passwordInput = userInputScanner.next();

            if (USER_NAME.equals(userNameInput) && PASSWORD.equals(passwordInput)) {
                System.out.println("You're logged in!");
                System.out.println("Secret stuff here!");
                break;
            } else {
                System.out.println("Invalid username/password combination.");
                passwordAttempts++;
                System.out.println("You have " + (MAX_PASSOWRD_TRYS-passwordAttempts) + " more trys.");
            } //close if else
        if (passwordAttempts == MAX_PASSOWRD_TRYS) {
            System.out.println("You've been locked out.");
        }

        }//close for

    } //close method
} //close class
