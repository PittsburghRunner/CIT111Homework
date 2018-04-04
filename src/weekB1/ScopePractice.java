/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekB1;

/**
 *
 * @author christopher.eckles
 */
public class ScopePractice {

    private static int numTimesMethodCalled = 0;

    public static void main(String[] args) {

        printStatement();
        printStatement();
        printStatement();
        printStatement();
        printStatement();
        System.out.println("Total Calls: " + numTimesMethodCalled);

    }

    public static void printStatement() {
        String actor = "Jack Nicholson";
        System.out.println("All work and no play makes Jack a dull boy.");
        numTimesMethodCalled++;
    }

}
