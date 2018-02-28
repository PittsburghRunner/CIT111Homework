/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5;

import java.util.Scanner;
import java.util.Random;

public class MathProblem {

    private static final int MAX_VALUE = 10;
    private static final int MAX_TRYS = 2;
    private static final int QUESTIONS_TO_ASK = 3;
    private static final int SCORE_TO_BEAT = 3;

    private static int score = 0;

    private static int currentQuestion = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to math quiz!");
        while (currentQuestion <= QUESTIONS_TO_ASK) {
            askAQuestion(); //call the method below to ask a question
            currentQuestion++; //incriment the question
        }
        /*
        find out if the student passed.
         */
        if (score > (QUESTIONS_TO_ASK * SCORE_TO_BEAT)) {
            System.out.println("Great Job! You scored: " + score + "out of " + (QUESTIONS_TO_ASK * (SCORE_TO_BEAT + 1)) + "points!");
        } else {
            System.out.println("Sorry! Try the quiz again after you've studied.");
        }

    } //close method
/*
    ask a math addition question
     */
    private static void askAQuestion() {
        Random aRand = new Random();
        Random bRand = new Random();

        int a = aRand.nextInt(MAX_VALUE) + 1;
        int b = bRand.nextInt(MAX_VALUE) + 1;

        int answerInput;
        int answerAttempts = 0;

        int questionScore = MAX_TRYS + 1;

        Scanner userInputScanner = new Scanner(System.in);

        while (answerAttempts < MAX_TRYS) {

            System.out.print(currentQuestion + ". What is " + a + " + " + b + "? ");
            try {
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
                answerAttempts++;
                System.out.println("You have " + (MAX_TRYS - answerAttempts) + " more trys.");
            } //close if else
            if (answerAttempts == MAX_TRYS) {
                System.out.println("Sorry you've reached your max tries!");
            }

        }//close for
        score = score + questionScore;
    } // close askQuestion method
} //close class
