/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects2_creatures;

/**
 *
 * @author christopher.eckles
 */
public class SizedDonut {
    //member variables

    public String name;
    public int sizeInmm;
    public int donutId;

    private int percRemaining = 100;

    public void simulateEating(int percentEaten) {
        if (percRemaining - percentEaten >= 0) {
            percRemaining = percRemaining - percentEaten;
        } else {
            percRemaining = 0;
        }

    }//close method

    public int getPercRamaining() {
        return percRemaining;
    }//close method;

    public boolean isNotDevoured() {
        if (percRemaining == 0) {
            return false;
        }
        return true;
    }
}
