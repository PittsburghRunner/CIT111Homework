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

    public static final Boolean DEBUG = true;

    public static final int NUMBER_OF_PLAYERS = 2;
    public static final int SLEEP_BETWEEN_MOVES = 2;

    public static ArrayList<Player> players = new ArrayList();

    public static boolean endGame = false;

    public static void main(String[] args) {

        for (int i = 1; i <= NUMBER_OF_PLAYERS; i++) {
            String n = getUserInput("Player " + i + "'s Name. \nType 'Computer' to play against it.", 3, Board.BOARD_X.length * 2);
            //String n = "Computer " + i;
            players.add(new Player(n));
        }

        while (!endGame) {
            int playerCount = 0;
            for (Player player : players) {
                for (Player opponent : players) {
                    if (!opponent.equals(player) && !opponent.isGameOver() && !endGame) {
                        makeAGuess(player, opponent);
                    }
                    if (opponent.isGameOver()) {
                        //System.out.println("End Of Game");
                        sleep(2);
                        endGame = true;
                        
                    };
                }
                playerCount++;
            }
        }
        for (Player player : players) {
            System.out.println("Player Stats:");
            player.printStats();
        }
    }

    public static Boolean makeAGuess(Player player, Player opponent) {
        Boolean validGuess = false;
        String guess;
        String string_x;
        String string_y;
        int x = 0;
        int y = 0;
        Move previousMissle = null;

        while (!validGuess) {
            opponent.getPlayerBoard().printBoard(false);

            Boolean goodGuess = false;
            if (player.isComputer()) {
                System.out.println(player.getPlayerName() + " is making a guess...");
                while (!goodGuess) {
                    x = RandomNumber.generateRandomLocation(Board.BOARD_X.length);
                    y = RandomNumber.generateRandomLocation(Board.BOARD_X.length);
                    goodGuess = (!opponent.getPlayerBoard().getLocation(x, y).getStatus().equals(Ship.HIT) && !opponent.getPlayerBoard().getLocation(x, y).getStatus().equals(Ship.MISSED));
                }
                sleep(SLEEP_BETWEEN_MOVES);
                System.out.println(player.getPlayerName() + " guesses: " + Board.BOARD_X[x] + (y + 1));
            } else {
                Scanner guessInput = new Scanner(System.in);
                System.out.print(player.getPlayerName() + "'s turn! Make Your Guess:  ");
                guess = guessInput.next();

                if (guess.matches("[a-zA-Z][0-9]+")) {
                    string_x = guess.substring(0, 1).toUpperCase();
                    string_y = guess.substring(1);
                    x = Arrays.asList(Board.BOARD_X).indexOf(string_x);
                    y = new Integer(string_y) - 1;
                } else {
                    System.out.println("Invalid Guess, Please Try again.");
                }
            }

            try {
                Location guessedLocation = opponent.getPlayerBoard().getLocation(x, y);
                switch (guessedLocation.getStatus()) {
                    case Ship.MISSED:
                    case Ship.HIT:
                        System.out.println("You already guessed this location, try again.");
                        break;
                    case Location.EMPTY:
                        guessedLocation.setStatus(Ship.MISSED);
                        System.out.println("Sorry, You missed.");
                        player.addMove(opponent,x,y,Ship.MISSED,previousMissle);
                        validGuess = true;
                        player.incrementNumberOfMisses();
                        break;
                    default:
                        guessedLocation.setStatus(Ship.HIT);
                        System.out.println(opponent.getPlayerName() + " is hit!");
                        player.addMove(opponent,x,y,Ship.HIT,previousMissle);
                        validGuess = true;
                        player.incrementNumberOfHits();
                        guessedLocation.getOccupiedBy().decrementShipSectionsLeft();
                        if (guessedLocation.getOccupiedBy().isSank()) {
                            System.out.println(player.getPlayerName() + " sank " + opponent.getPlayerName() + "'s " + guessedLocation.getOccupiedBy().getShipType().getModel() + "!");
                            opponent.getPlayerBoard().decrementPiecesLeft();
                            if (opponent.getPlayerBoard().isBoardGameOver()) {
                                System.out.println(opponent.getPlayerName() + " has lost. They have no ships left!");
                            }
                        }
                }
            } catch (Exception e) {
                System.out.println("Invalid Guess, Please Try again.");
            }

            sleep(SLEEP_BETWEEN_MOVES);
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
