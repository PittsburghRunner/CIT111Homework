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

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author christopher.eckles
 */
public class Board {

    public static final int NO_DIRECTION = -1;
    public static final int EAST_TO_WEST = 0;
    public static final int NORTH_TO_SOUTH = 1;
    public static final String DIRECTION[] = {"East to West", "North to South"};

    public static final String BOARD_X[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};//, "K", "L", "M", "N", "O", "P", "Q", "R"};
    public static final int BOARD_Y = 10;

    private static final String BOARD_HEADER = "Opponent's Board";
    public static final String TWO_SPACES = "~~";

    private int piecesLeft = ShipType.values().length;
    private String boardName;
    private Ship[] fleet = new Ship[ShipType.values().length];
    private Location board[][];
    //TODO: multidimentional array

    Board(Player player) {
        // build board 
        setBoardSize(BOARD_X.length, BOARD_Y);
        setBoardName(player.getPlayerName());
        // place ship(){
        int id = 0;
        for (ShipType shipType : ShipType.values()) {
            int size;
            size = shipType.getSize();
            Boolean set = false;
            int direction;
            int x = 0;
            int y = 0;
            Ship ship = new Ship(id, shipType);
            while (!set) {
                direction = NO_DIRECTION;
                if (player.getIsComputer()) {

                    direction = RandomNumber.generateRandomLocation(2);
                    if (SimpleBattleShip.DEBUG) {
                        System.out.println("direction: " + direction);
                    }
                    int y_range;
                    int x_range;
                    if (direction == EAST_TO_WEST) {
                        y_range = BOARD_Y;
                        x_range = BOARD_X.length - size;
                    } else {
                        y_range = BOARD_Y - size;
                        x_range = BOARD_X.length;
                    }
                    y = RandomNumber.generateRandomLocation(y_range);
                    x = RandomNumber.generateRandomLocation(x_range);
                    if (SimpleBattleShip.DEBUG) {
                        System.out.println("direction: " + direction);
                    }
                } else {
                    Boolean validInput = false;
                    Scanner scanner = new Scanner(System.in);
                    String stringDirection = "";
                    String stringX = "";
                    String stringY = "";
                    String locationInput = "";
                    while (validInput = false) {
                        try {
                            while (direction != 0 && direction != 1) {
                                System.out.println("Enter a Direction \n(0 for " + Board.DIRECTION[Board.NORTH_TO_SOUTH] + " and 0 for " + Board.DIRECTION[Board.EAST_TO_WEST] + "): ");
                                stringDirection = scanner.next();
                                direction = new Integer(stringDirection);
                            }
                            while (!locationInput.matches("[a-zA-Z][0-9]+")) {
                                System.out.print("Enter a Location \nRange: " + Board.BOARD_X[0] + "-" + Board.BOARD_X[-1] + " and 1-" + Board.BOARD_Y + "): ");
                                locationInput = scanner.next();
                                if (locationInput.matches("[a-zA-Z][0-9]+")) {
                                    stringX = locationInput.substring(0, 1).toUpperCase();
                                    stringY = locationInput.substring(1);
                                    x = Arrays.asList(Board.BOARD_X).indexOf(stringX);
                                    y = new Integer(stringY) - 1;
                                } else {
                                    System.out.println("Invalid Location, Please Try again.");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid Location, Try again!");
                        }
                    }
                }

                if (setShipLocation(id, x, y, direction, ship)) {

                    set = true;
                    if (SimpleBattleShip.DEBUG) {
                        System.out.println("Location of " + ship.getShipType().getModel() + " ship: " + Board.BOARD_X[x] + (y + 1) + " heading " + Board.DIRECTION[direction]);
                    }
                    fleet[id] = ship;
                }

            }
            id++;
        }
    }

    private void setBoardSize(int x, int y) {
        board = new Location[y][x];
        for (int yy = 0; yy < y; yy++) {
            for (int xx = 0; xx < x; xx++) {
                if (SimpleBattleShip.DEBUG) {
                    System.out.println("Y:" + (yy + 1) + "X:" + Board.BOARD_X[xx]);
                }
                board[yy][xx] = new Location();
            }
        }
    }

    private Boolean setBoardName(String boardName) {
        if (boardName.length() < 1) {
            return false;
        }
        this.boardName = boardName;
        return true;

    }

    public String getBoardName() {
        return this.boardName;
    }

    public Location getLocation(int x, int y) {
        if (SimpleBattleShip.DEBUG) {
            System.out.println("getLocation: " + BOARD_X[x] + (y + 1));
        }
        if (y < BOARD_Y && x < BOARD_X.length) {
            return board[y][x];
        }
        if (SimpleBattleShip.DEBUG) {
            System.out.println("Out of bounds.");
        }
        return new Location();
    }

    private Boolean setShipLocation(int id, int x, int y, int direction, Ship ship) {
        if (direction == EAST_TO_WEST) {
            for (int xx = x; xx < x + ship.getShipType().getSize(); xx++) {
                if (!getLocation(xx, y).getStatus().equals(Location.EMPTY)) {
                    if (SimpleBattleShip.DEBUG) {
                        System.out.println("recaulate... piece already here");
                    }
                    return false;
                }
            }
            for (int xx = x; xx < x + ship.getShipType().getSize(); xx++) {
                getLocation(xx, y).setOccupiedBy(ship);
            }
            return true;
        } else {
            for (int yy = y; yy < y + ship.getShipType().getSize(); yy++) {
                if (!getLocation(x, yy).getStatus().equals(Location.EMPTY)) {
                    if (SimpleBattleShip.DEBUG) {
                        System.out.println("recaulate... piece already here");
                    }
                    return false;
                }
            }
            for (int yy = y; yy < y + ship.getShipType().getSize(); yy++) {
                getLocation(x, yy).setOccupiedBy(ship);
            }
            return true;
        }
    }//end setShipLocation

    public int getPiecesLeft() {
        return piecesLeft;
    }

    public void decrementPiecesLeft() {
        this.piecesLeft--;
    }

    public Ship[] getFleet() {
        return fleet;
    }

    public void setFleet(Ship[] fleet) {
        this.fleet = fleet;
    }

    public void printBoard(Boolean isSelf) {
        String boardStatus = "";
        for (int yy = 0; yy < Board.BOARD_Y; yy++) {
            for (int xx = 0; xx < Board.BOARD_X.length; xx++) {
                if (!(board[yy][xx].getStatus().equals(Ship.HIT) || board[yy][xx].getStatus().equals(Ship.MISSED)) && !isSelf) {
                    boardStatus = boardStatus + TWO_SPACES + Location.EMPTY;
                } else if (board[yy][xx].getStatus().equals(Ship.HIT)  && board[yy][xx].getOccupiedBy().getShipSectionsLeft() == 0) {
                    boardStatus = boardStatus + TWO_SPACES + board[yy][xx].getOccupiedBy().getShipType().getIdentifier();
                } else {
                    boardStatus = boardStatus + TWO_SPACES + board[yy][xx].getStatus();
                }
            } //end x
            boardStatus = boardStatus + TWO_SPACES + TWO_SPACES + ((yy + 1)) + "\n";

        } //end y
        String boardFooter = "";
        for (String xLabels : BOARD_X) {
            boardFooter = boardFooter + TWO_SPACES + xLabels;
        }
        int borderLength = ((Double) Math.floor(((BOARD_X.length + (BOARD_X.length * TWO_SPACES.length())) - BOARD_HEADER.length()) / 2)).intValue();
        String border = "";
        for (int i = 0; i < borderLength; i++) {
            border = border + "*";
        }
        System.out.println(border + TWO_SPACES + BOARD_HEADER + TWO_SPACES + border);
        borderLength = ((Double) Math.floor(((BOARD_X.length + (BOARD_X.length * TWO_SPACES.length())) - boardName.length()) / 2)).intValue();
        border = "";
        for (int i = 0; i < borderLength; i++) {
            border = border + "*";
        }
        System.out.println(border + TWO_SPACES + boardName + TWO_SPACES + border);
        System.out.println(boardStatus);
        System.out.println(boardFooter);

    }//end printbaord

    public Boolean isBoardGameOver() {
        if (piecesLeft == 0) {
            return true;
        }
        return false;
    }

}
