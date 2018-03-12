/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5;

import java.util.Scanner;
import java.util.Random;

public class MathProblem {

    private static final int MAX_VALUE = 30;
    private static final int MAX_TRIES = 2;
    private static final int QUESTIONS_TO_ASK = 10;

    private static int score = 0;
    private static double scorePercent = 0.0;
    private static int currentQuestion = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to math quiz!");
        System.out.println("There are " + QUESTIONS_TO_ASK + " questions in this quiz.");
        while (currentQuestion <= QUESTIONS_TO_ASK) {
            askAQuestion(); //call the method below to ask a question
            currentQuestion++; //incriment the question
        }
        /*
        find out if the student passed.
         */
        scorePercent = ((double)score/(double)(QUESTIONS_TO_ASK*(MAX_TRIES))*100);
        
        if (scorePercent == 100) {
            System.out.println("Great Job! Perfect Score! You scored: " + score + " out of " + (QUESTIONS_TO_ASK * (MAX_TRIES)) + " points!");
        } else if (scorePercent >= 90) {
            System.out.println("Good Job! You scored: " + score + " out of " + (QUESTIONS_TO_ASK * (MAX_TRIES)) + " points!");
        }
        System.out.println("You scored " + scorePercent + "%!");

    } //close method
/*
    ask a math addition question
     */
    public static void askAQuestion() {
        Random aRand = new Random();
        Random bRand = new Random();

        int a = aRand.nextInt(MAX_VALUE) + 1; //get a randdom value of a
        int b = bRand.nextInt(MAX_VALUE) + 1; //get a random value of b

        int answerInput;
        int questionScore = MAX_TRIES;


        while (questionScore != 0) {

            System.out.print(currentQuestion + ". What is " + a + " + " + b + "? ");
            try {
                Scanner userInputScanner = new Scanner(System.in);
                answerInput = userInputScanner.nextInt();
            } catch (Exception e) {
                answerInput = 0;
            }
            if ((a + b) == answerInput) {
                System.out.println("You're Correct! " + questionScore + " points!");
                break;
            } else {
                System.out.println("Wrong Answer.");
                questionScore--;
                System.out.println("You have " + questionScore + " more try(s).");
            } //close if else
            if (questionScore == 0) {
                System.out.println("Sorry you've reached your max tries!");
            }

        }//close for
        score = score + questionScore;
    } // close askQuestion method
} //close class
