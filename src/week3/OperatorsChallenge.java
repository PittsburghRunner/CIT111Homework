/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;

/**
 *
 * @author christopher.eckles
 */
public class OperatorsChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 100;
        int b = 2000;
        double d = 10.5;
        String line1 = "Go Ask Alice";
        String line2 = "I think she'll know";
        
        
        
        int r = b / a; //divide
        System.out.println("b divided by a is (r): " + r); //print divide
        
        int mod = b % a; //calculate mod
        System.out.println("b modulus a is (mod): " + mod); //print mod
        
        double rd = mod * d; // calculate multiplacation
        System.out.println("mod times d is (rd): " + rd); //print multiplication
        
        System.out.println(line2 + " " + line1); // print line2 then 1
        
        System.out.println(line1 + " " + line2); //print line1 then 2
        
        

    } //close main

} //close class
