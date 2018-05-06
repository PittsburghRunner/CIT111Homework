/*
 * Copyright (C) 2018 christopher.eckles
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package SimpleBattleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author christopher.eckles
 */
public class SimpleBattleShip {

    public static final Boolean DEBUG = false;

    public static final int NUMBER_OF_PLAYERS = 2;

    public static ArrayList<Player> players = new ArrayList();

    public static void main(String[] args) {

        for (int i = 1; i <= NUMBER_OF_PLAYERS; i++) {
            String n = getUserInput("Player " + i + "'s Name", 3, Board.BOARD_X.length);
            //String n = "testname";
            players.add(new Player(n));
        }

        boolean endGame = false;
        while (!endGame) {
            int playerCount = 0;
            for (Player player : players) {
                int opponentCount = 0;
                for (Player opponent : players) {
                    if (playerCount != opponentCount) {
                        makeAGuess(player, opponent);
                    }
                    opponentCount++;
                    endGame = opponent.isGameOver();
                }
                playerCount++;
            }
        }
    }

    public static Boolean makeAGuess(Player player, Player opponent) {
        Boolean validGuess = false;
        String guess;
        String string_x;
        String string_y;
        Scanner guessInput = new Scanner(System.in);
        while (!validGuess) {
            opponent.getPlayerBoard().printBoard(false);
            System.out.print(player.getPlayerName() + "'s turn! Make Your Guess:  ");
            guess = guessInput.next();
            if (guess.matches("[a-zA-Z][0-9]+")) {
                string_x = guess.substring(0, 1).toUpperCase();
                string_y = guess.substring(1);
                int x = Arrays.asList(Board.BOARD_X).indexOf(string_x);
                int y = new Integer(string_y) - 1;
                try {
                    validGuess = opponent.getPlayerBoard().getLocation(x, y).guess();

                } catch (Exception e) {
                    System.out.println("Invalid Guess, Please Try again.");
                }
            } else {
                System.out.println("Invalid Guess, Please Try again.");
            }
            sleep(3);
        }
        return true;
    }

    private static String getUserInput(String prompt, int min, int max) {
        String input = "";
        Scanner userInputScanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter " + prompt + " (min:" + min + " max:" + max + "): ");
            input = userInputScanner.nextLine();
            if (input.length() >= min && input.length() <= max) {
                return input;
            } else {
                System.out.println("Input did not meet requirements. Please try again.");
            }
        }

    }
    public static void sleep(int timeInSeconds) {
        int timeInms = (timeInSeconds * 1000);
        try {
            Thread.sleep(timeInms);
        } catch (InterruptedException e) {
            System.out.println("Interuppted Exception: " + e);
        }

    }
}