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
public class CreatureLand {

    public static boolean winnerExists = false;

    public static void main(String[] args) {

        SceneTThread sceneT = new SceneTThread();
        sceneT.start();

        ScenePThread sceneP = new ScenePThread();
        sceneP.start();
        
        SceneOThread sceneO = new SceneOThread();
        sceneO.start();

    }//close main

    public static void implemntSceneT() {
        //pointer variable
        Creature turtle = new Creature();
        turtle.name = "Crush";
        turtle.species = "Sea Turle";
        turtle.setBiteSizeInPercent(20);
        turtle.setSizeLimit(60);
        turtle.setTimeToTakeBiteInSeconds(1);

        SizedDonut donutForTurtle = new SizedDonut();
        donutForTurtle.donutId = 123;
        donutForTurtle.name = "Chocolate";
        donutForTurtle.sizeInmm = 50;

        turtle.eatDonut(donutForTurtle);

    }

    public static void implementSceneP() {
        //pointer variable
        Creature penguin = new Creature();
        penguin.name = "Grant";
        penguin.species = "Blob Fish";
        penguin.setSizeLimit(20);
        penguin.setBiteSizeInPercent(20);
        penguin.setTimeToTakeBiteInSeconds(1);

        SizedDonut donutForPenguin = new SizedDonut();
        donutForPenguin.donutId = 456;
        donutForPenguin.name = "Fred";
        donutForPenguin.sizeInmm = 32;

        penguin.eatDonut(donutForPenguin);
  
       
    }

        public static void implementSceneO() {
        //pointer variable
        Creature owl = new Creature();
        owl.name = "Mr Owl";
        owl.species = "Northern Whiteface";
        owl.setSizeLimit(20);
        owl.setBiteSizeInPercent(25);
        owl.setTimeToTakeBiteInSeconds(3);

        SizedDonut donutForOwl = new SizedDonut();
        donutForOwl.donutId = 789;
        donutForOwl.name = "Jelly";
        donutForOwl.sizeInmm = 32;

        owl.eatDonut(donutForOwl);
    }
        
    public static boolean getWinnerExists() {
        return winnerExists;
    }

    public static boolean imDone(String creature) {
        if (!winnerExists) {
            winnerExists = true;
            System.out.println(creature + " is a winner!!!!");
            System.out.println("********WINNER**********");
            return true;
        } else {
            System.out.println(creature + " is not a winner :(");
            return false;
        }

    }

}
