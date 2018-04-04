/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekB1.ls3_classStructure;

import java.util.Random;

/**
 *
 * @author christopher.eckles
 */
public class KennywoodRideTracker {

    private static final int THRILL_RIDE_MIN_HEIGHT = 52;
    private static final int THEME_RIDE_MIN_HEIGHT = 46;

    private static final int THRILL_RIDE_MAX_RIDERS = 40;
    private static final int THEME_RIDE_MAX_RIDERS = 80;

    private static final int MIN_RIDER_HEIGHT = 37;
    private static final int MAX_RIDER_HEIGHT = 80;

    private static final int RIDE_GROUPS = 20;

    private static int totalRiders = 0;
    private static int totalFailedRideAttempts = 0;
    private static int totalSickRiders = 0;

    public static void main(String[] args) {

        for (int numLoops = 0; numLoops <= RIDE_GROUPS; numLoops++) {
            rideBlackWidow(randomRiders(THRILL_RIDE_MAX_RIDERS), randomRiderHeight()); //max 40 riders
            rideMerryGoRound(randomRiders(THEME_RIDE_MAX_RIDERS), randomRiderHeight()); //max 80 riders 4 Rows, 72 animals (20 stationary, 50 jumpers, 1 lion, 1 tiger; 4 chariots as well)
            printRideStats();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interuppted Exception: " + e);
            }
        }

    }  //close main

    public static void rideBlackWidow(int riders, int avgHeight) {

        if (avgHeight >= THRILL_RIDE_MIN_HEIGHT) {
            System.out.println(riders + " riders are riding Black Widow...");
            totalRiders = totalRiders + riders;

            Random rand = new Random();
            int numSickRiders = rand.nextInt(riders);
            totalSickRiders = totalSickRiders + numSickRiders;

            if (numSickRiders == 1) {
                System.out.println("Ew! Someone threw up!");
            } else if (numSickRiders > 1) {
                System.out.println(numSickRiders + " riders got sick on the Black Widow!!");
            }
        } //close if
        else {
            System.out.println(riders + " riders are too short to ride Black Widow.");
            totalFailedRideAttempts = totalFailedRideAttempts + riders;

        } //close else
        System.out.println("");
    } //close rideBlackWidow

    public static void rideMerryGoRound(int riders, int avgHeight) {
        if (avgHeight >= THEME_RIDE_MIN_HEIGHT) {
            System.out.println(riders + " riders are riding Merry-Go-Round...");
            totalRiders = totalRiders + riders;

            Random rand = new Random();
            int numSickRiders = rand.nextInt(riders);
            totalSickRiders = totalSickRiders + numSickRiders;

            if (numSickRiders == 1) {
                System.out.println("Ew! Someone threw up!");
            } else if (numSickRiders > 1) {
                System.out.println(numSickRiders + " riders got sick on the Merry-Go-Round!!");
            }
        } //close if
        else {
            System.out.println(riders + " riders didn't have adults with them for the Merry-Go-Round.");
            totalFailedRideAttempts = totalFailedRideAttempts + riders;

        } //close else

        System.out.println("");

    } //close rideMerryGoRound

    public static void printRideStats() {
        System.out.println("*******RIDER STATS*******");
        System.out.println("Total Riders: " + totalRiders);
        System.out.println("Total Failed Ride Attempts: " + totalFailedRideAttempts);
        System.out.println("Total Sick Riders: " + totalSickRiders);
        System.out.println("*************************\n");

    } //close printRideStats

    private static int randomRiderHeight() {
        Random rand = new Random();
        int randomRiderHeight = rand.nextInt(MAX_RIDER_HEIGHT - MIN_RIDER_HEIGHT + 1) + MIN_RIDER_HEIGHT;
        return randomRiderHeight;
    } //close randomRiderHeight

    private static int randomRiders(int maxRiders) {
        Random rand = new Random();
        int randomRiders = rand.nextInt(maxRiders - 10) + 10;
        return randomRiders;
    } //close randomRiderHeight

} //close class
