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

    private static final String OPPONENT_HEADER = "Opponent's Board";
    public static final String ONE_SPACE = " ";
    public static final String TWO_SPACES = "~~";
    public static final String THREE_SPACES = "_|_";
    public static final String BORDER = "*";



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
                if (player.isComputer()) {
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
                    printBoard(true);
                    Scanner scanner = new Scanner(System.in);
                    String directionInput = "";
                    String stringX = "";
                    String stringY = "";
                    String locationInput = "";
                    while (!set) {
                        System.out.print("Place your " + shipType.getModel() + "\nEnter a Direction \n(" + Board.NORTH_TO_SOUTH + " for " + Board.DIRECTION[Board.NORTH_TO_SOUTH] + " and " + Board.EAST_TO_WEST + " for " + Board.DIRECTION[Board.EAST_TO_WEST] + "): ");
                        try {
                            directionInput = scanner.next();

                            direction = new Integer(directionInput);
                            set = (direction == Board.NORTH_TO_SOUTH || direction == Board.EAST_TO_WEST);
                        } catch (Exception e) {
                            System.out.println("Exception Caught");
                        }
                    }
                    set = false;
                    while (!set) {
                        System.out.print("Enter a Location \n(Range: " + Board.BOARD_X[0] + "-" + Board.BOARD_X[Board.BOARD_X.length - 1] + " and 1-" + Board.BOARD_Y + "): ");
                        //System.out.println("Enter a location:");
                        locationInput = scanner.next();
                        if (locationInput.matches("[a-zA-Z][0-9]+")) {
                            stringX = locationInput.substring(0, 1).toUpperCase();
                            stringY = locationInput.substring(1);
                            x = Arrays.asList(Board.BOARD_X).indexOf(stringX);
                            y = new Integer(stringY) - 1;
                            set = true;
                        } else {
                            System.out.println("Invalid Location, Please Try again.");
                        }
                    }
                }
                set = (setShipLocation(id, x, y, direction, ship));
                if (set && SimpleBattleShip.DEBUG) {
                    System.out.println("Location of " + ship.getShipType().getModel() + " ship: " + Board.BOARD_X[x] + (y + 1) + " heading " + Board.DIRECTION[direction]);
                }
                fleet[id] = ship;

            }//close While

            id++;
        }//close for ships
    }//close constrtuctor

    private void setBoardSize(int x, int y) {
        board = new Location[y][x];
        for (int yy = 0; yy < y; yy++) {
            for (int xx = 0; xx < x; xx++) {
                if (SimpleBattleShip.DEBUG) {
                    System.out.println("Setting: " + Board.BOARD_X[xx] + (yy+1));
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
        if (isInBounds(x, y)) {
            return board[y][x];
        }
        if (SimpleBattleShip.DEBUG) {
            System.out.println("Out of bounds.");
        }
        return null;
    }

    private Boolean setShipLocation(int id, int x, int y, int direction, Ship ship) {
        if (direction == EAST_TO_WEST) {
            for (int xx = x; xx < x + ship.getShipType().getSize(); xx++) {
                if (!isInBounds(xx, y)) {
                    System.out.println("Location is Off the Grid!");
                    return false;
                }
                Location location = getLocation(xx, y);
                if (location.getOccupiedBy() != null) {
                    System.out.println(location.getOccupiedBy().getShipType().getModel() + " already here, try a new location");
                    return false;
                }
            }
            for (int xx = x; xx < x + ship.getShipType().getSize(); xx++) {
                getLocation(xx, y).setOccupiedBy(ship);
            }
            return true;
        } else {
            for (int yy = y; yy < y + ship.getShipType().getSize(); yy++) {
                if (!isInBounds(x, yy)) {
                    System.out.println("Location is Off the Grid!");
                    return false;
                }
                Location location = getLocation(x, yy);
                if (location.getOccupiedBy() != null) {
                    System.out.println(location.getOccupiedBy().getShipType().getModel() + " already here, try a new location");
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
        String currentRowStatus = "";
        int maxRowDigits = String.valueOf(BOARD_Y).length();
        String maxRowOffset = "";
        for (int i =0; i < maxRowDigits; i++){
                maxRowOffset = maxRowOffset+BORDER;
            }
        for (int yy = 0; yy < Board.BOARD_Y; yy++) {
            currentRowStatus = "";
            String rowOffset = "";
            String rowNumber = String.valueOf(yy+1);
            int yyDigits = String.valueOf(rowNumber).length();
            for (int i =0; i < maxRowDigits - yyDigits; i++){
                rowOffset = rowOffset+BORDER;
            }
            currentRowStatus = rowOffset + rowNumber;
            for (int xx = 0; xx < Board.BOARD_X.length; xx++) {
                if (!(board[yy][xx].getStatus().equals(Ship.HIT) || board[yy][xx].getStatus().equals(Ship.MISSED)) && !isSelf) {
                    currentRowStatus = currentRowStatus + TWO_SPACES + Location.EMPTY;
                } else if (board[yy][xx].getStatus().equals(Ship.HIT) && board[yy][xx].getOccupiedBy().getShipSectionsLeft() == 0) {
                    currentRowStatus = currentRowStatus + TWO_SPACES + board[yy][xx].getOccupiedBy().getShipType().getIdentifier();
                } else {
                    currentRowStatus = currentRowStatus + TWO_SPACES + board[yy][xx].getStatus();
                }
            } //end x
            
      
            boardStatus = boardStatus + currentRowStatus  + TWO_SPACES  + "\n";

        } //end y
        String xHeader = maxRowOffset;
        for (String xLabels : BOARD_X) {
            xHeader = xHeader + TWO_SPACES + xLabels;
        }
        int borderLength;
        String border = "";
        if (!isSelf) {
            borderLength = ((Double) Math.floor(((BOARD_X.length + (BOARD_X.length * TWO_SPACES.length())) - OPPONENT_HEADER.length()) / 2)).intValue();
            for (int i = 0; i < borderLength; i++) {
                border = border + BORDER;
            }
            System.out.println(border + TWO_SPACES + OPPONENT_HEADER + TWO_SPACES + border);
        }
        borderLength = ((Double) Math.floor(((BOARD_X.length + (BOARD_X.length * TWO_SPACES.length())) - boardName.length()) / 2)).intValue();
        border = "";
        for (int i = 0; i < borderLength; i++) {
            border = border + "*";
        }
        System.out.println(maxRowOffset + border + ONE_SPACE + boardName + ONE_SPACE + border);
        System.out.println(xHeader);
        System.out.println(boardStatus);

    }//end printbaord

    public Boolean isBoardGameOver() {
        if (piecesLeft == 0) {
            return true;
        }
        return false;
    }

    public Boolean isInBounds(int x, int y) {
        return (x >= 0 && y >= 0 && x < Board.BOARD_X.length && y < Board.BOARD_Y);
    }

}
