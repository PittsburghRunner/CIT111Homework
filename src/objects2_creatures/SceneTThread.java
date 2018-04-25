/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects2_creatures;

import static objects2_creatures.CreatureLand.implemntSceneT;

/**
 *
 * @author christopher.eckles
 */
public class SceneTThread extends Thread {

    public void run() {
        System.out.println("Scene T running");
        implemntSceneT();
        System.out.println("Scene T end");

    }
}
