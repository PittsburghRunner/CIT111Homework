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
import java.util.Scanner;

/**
 *
 * @author christopher.eckles
 */
public class SimpleBattleShip {

    public static final int NUMBER_OF_PLAYERS = 2;

    private static final ArrayList<Player> players = new ArrayList();

    public static void main(String[] args) {

        for (int i = 1; i <= NUMBER_OF_PLAYERS; i++) {
            String n = getUserInput("Player " + i + "'s Name", 3, Board.BOARD_LATITUDE.length);
            players.add(new Player(n));
        }

        for (Player player : players) {
            int indexOf = players.indexOf(players);

            player.getPlayerBoard().printBoard(true);

            for (Ship fleet : player.getPlayerBoard().fleet) {
                System.out.println(fleet.getShipStartLocation() + " - size: " + fleet.getShipSize());
            }
        }

    }

    private static String getUserInput(String prompt, int min, int max) {
        String input = "";
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Please enter " + prompt + " (min:" + min + " max:" + max + "): ");

        while (true) {
            input = userInputScanner.nextLine();
            if (input.length() >= min && input.length() <= max) {
                return input;
            };
        }

    }
}
