/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects2_creatures;

import static objects2_creatures.CreatureLand.imDone;

/**
 *
 * @author christopher.eckles
 */
public class Creature {

    public String name;
    public String species;

    private int biteSizeInPercent = 0;
    private int numBitesTaken = 0;
    private int sizeLimit;
    private int timeToTakeBiteInSeconds = 0;

    public boolean isWinner = false;

    public int getTimeToTakeBiteInSeconds() {
        return timeToTakeBiteInSeconds;
    }

    public void setTimeToTakeBiteInSeconds(int timeToTakeBiteInSeconds) {
        if (timeToTakeBiteInSeconds <= 0) {
            System.out.println("Cannot set bite size negative");
            return;
        }
        //check biteSize
        this.timeToTakeBiteInSeconds = timeToTakeBiteInSeconds;

        this.timeToTakeBiteInSeconds = timeToTakeBiteInSeconds;
    }

    //Method to simulate eating a donut
    public int eatDonut(SizedDonut donutToEat) {
        System.out.println(name + " is eating a  " + donutToEat.name + " donut.");

        while (donutToEat.isNotDevoured()) {
            donutToEat.simulateEating(biteSizeInPercent);
            System.out.println(name + " took a bite of the " + donutToEat.name + " donut.");
            chew(timeToTakeBiteInSeconds);
            System.out.println("Percent of " + donutToEat.name + "(" + donutToEat.donutId + ")" + " Donut Left: " + donutToEat.getPercRamaining());
            numBitesTaken++;
            System.out.println(name + " swallowed a bite donut.");

        }
        System.out.println("Donut gone!");
        isWinner = imDone(name);
        return numBitesTaken;
    }

    //'getter' method for private member variable sizeLimit
    public int getSizeLimit() {

        return sizeLimit;
    }

    //'setter' method for private member variable sizeLimit
    public void setSizeLimit(int sizeLimit) {
        //check for resonable size limit
        this.sizeLimit = sizeLimit;
    }

    //'getter' method for numBitesTaken
    public int getNumBitesTaken() {
        return numBitesTaken;
    }

    //'getter' method for biteSizeInPercent
    public int getBiteSizeInPercent() {
        return biteSizeInPercent;
    }

    //'setter' method for biteSizeInPercent
    public void setBiteSizeInPercent(int biteSizeInPercent) {
        //check biteSize
        if (biteSizeInPercent <= 0) {
            System.out.println("Cannot set bite size negative");
            return;
        } else {
            this.biteSizeInPercent = biteSizeInPercent;
        }

    }

    public static void chew(int timeInSeconds) {
        int timeInms = (timeInSeconds * 1000);
        try {
            Thread.sleep(timeInms);
        } catch (InterruptedException e) {
            System.out.println("Interuppted Exception: " + e);
        }
    }

}//close class
