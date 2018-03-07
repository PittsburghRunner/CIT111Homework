/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

import java.util.Scanner;


/**
 *
 * @author christopher.eckles
 */
public class PurchaseCalculator {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        double itemPrice;
        double discount;
        
        itemPrice = askUserForDouble("Enter item's price: $");
        discount = askUserForDouble("Enter Discount amount: %");

        itemPrice = calculateDiscount(discount, itemPrice);
        calculateTotalWithTax(itemPrice);
                
    }// close main
    
/**
 * This method calculates the total with tax and prints it out to the consol.
 * @param price total price before sales tax. 
 */
    public static void calculateTotalWithTax(double price) {
        final double TAX_RATE = 0.07;
        double totalPrice = price * (1 + TAX_RATE);

        System.out.println("The price with tax is: $" + totalPrice);

    }

 /**
 * This method calculates the total with tax and prints it out to the consol.
 * @param price total price before sales tax. 
 */
    public static double calculateDiscount(double discount, double price) {
        double totalPrice = price * (1 - discount);

        System.out.println("The price with discount is: $" + totalPrice);
    return totalPrice;
    }   
    
    public static double askUserForDouble(String prompt){
        Scanner inputScanner = new Scanner(System.in);
        double enteredDouble;
        System.out.print(prompt);
        enteredDouble = inputScanner.nextDouble();
        return enteredDouble;
    }
}// close class
