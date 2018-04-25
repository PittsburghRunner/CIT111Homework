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
    public static void main(String[] args) {
            
       implemntSceneT();
       
       implementSceneP();
      
       

    }//close main
    
    public static void implemntSceneT(){
         //pointer variable
        Creature turtle = new Creature ();
        turtle.name = "Crush";
        turtle.species = "Sea Turle";
        turtle.setBiteSizeInPercent(10);
        turtle.setSizeLimit(60);
        turtle.setTimeToTakeBiteInSeconds(3);
        
        SizedDonut donutForTurtle = new SizedDonut();
        donutForTurtle.name = "Chocolate";
        donutForTurtle.sizeInmm = 50;
                
         while(donutForTurtle.isNotDevoured()){
           turtle.eatDonut(donutForTurtle);
           System.out.println("Percent of " + donutForTurtle.name + " Donut Left: " + donutForTurtle.getPercRamaining());
       }        
                System.out.println("Donut gone!");
    }
    
    public static void implementSceneP(){
         //pointer variable
       Creature penguin = new Creature();
       penguin.name = "Grant";
       penguin.species = "Blob Fish";
       penguin.setSizeLimit(10);
       penguin.setBiteSizeInPercent(5);
       penguin.setTimeToTakeBiteInSeconds(20);
       
       SizedDonut donutForPenguin = new SizedDonut();
       donutForPenguin.name = "Fred";
       donutForPenguin.sizeInmm = 32;
       
        while(donutForPenguin.isNotDevoured()){
           penguin.eatDonut(donutForPenguin);
           System.out.println("Donut Left: " + donutForPenguin.getPercRamaining());
       }
                System.out.println("Donut gone!");
    }
    
}
