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

/**
 *
 * @author christopher.eckles
 */
public class Board {

    public static final int SHIP_SIZES[] = {5, 4, 3, 3, 2};
    public static final int EAST_TO_WEST = 0;
    public static final int NORTH_TO_SOUTH = 1;
    public static final String DIRECTION[] = {"East to West", "North to South"};
    public static final String BOARD_X[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R"};
    public static final int BOARD_Y = 20;

    public static final String TWO_SPACES = "~~";

    private int piecesLeft = SHIP_SIZES.length;
    private String boardName;
    private Ship[] fleet = new Ship[SHIP_SIZES.length];
    private Location board[][];
    //TODO: multidimentional array

    Board(Player player) {
        // build board 
        setBoardSize(BOARD_X.length, BOARD_Y);
        setBoardName(player.getPlayerName());
        // place ship(){
        for (int id = 0; id < SHIP_SIZES.length; id++) {
            int size = SHIP_SIZES[id];
            Boolean set = false;
            int direction = -1;
            Ship ship;
            while (!set) {
                direction = RandomNumber.generateRandomLocation(2);
                if (SimpleBattleShip.DEBUG) {
                    System.out.println("direction: " + direction);
                }
                int y_range;
                int x_range;
                if (direction == EAST_TO_WEST) {
                    y_range = BOARD_Y - 1;
                    x_range = BOARD_X.length - size - 1;
                } else {
                    y_range = BOARD_Y - size - 1;
                    x_range = BOARD_X.length - 1;
                }
                int y = RandomNumber.generateRandomLocation(y_range);
                int x = RandomNumber.generateRandomLocation(x_range);
                if (SimpleBattleShip.DEBUG) {
                    System.out.println("direction: " + direction);
                }

                if (setShipLocation(id, x, y, direction, size)) {
                    set = true;
                    if (SimpleBattleShip.DEBUG) {
                        System.out.println("direction: " + direction);
                    }

                    ship = new Ship(id, x, y, direction, size);
                    if (SimpleBattleShip.DEBUG) {
                        System.out.println("Location of " + ship.getShipId() + " ship: " + ship.getShipStartLocation());
                    }
                    fleet[id] = ship;

                }

            }

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
            System.out.println("getLocation: X" + BOARD_X[x] + "Y" + y);
        }
        if (y < BOARD_Y && x < BOARD_X.length) {
            return board[y][x];
        }
        if (SimpleBattleShip.DEBUG) {
            System.out.println("Out of bounds.");
        }
        return new Location();
    }

    private Boolean setShipLocation(int id, int x, int y, int direction, int size) {
        if (direction == EAST_TO_WEST) {
            for (int xx = x; xx < x + size; xx++) {
                if (getLocation(xx, y).getStatus().equals(Ship.SHIP)) {
                    if (SimpleBattleShip.DEBUG) {
                        System.out.println("recaulate... piece already here");
                    }
                    return false;
                }
            }
            for (int xx = x; xx < x + size; xx++) {
                getLocation(xx, y).setOccupiedBy(id);
            }
            return true;
        } else {
            for (int yy = y; yy < y + size; yy++) {
                if (getLocation(x, yy).getStatus().equals(Ship.SHIP)) {
                    if (SimpleBattleShip.DEBUG) {
                        System.out.println("recaulate... ship already here");
                    }
                    return false;
                }
            }
            for (int yy = y; yy < y + size; yy++) {
                getLocation(x, yy).setOccupiedBy(id);
            }
            return true;
        }
    }//end setShipLocation

    public int getPiecesLeft() {
        return piecesLeft;
    }

    public void setPiecesLeft(int piecesLeft) {
        this.piecesLeft = piecesLeft;
    }

    public Ship[] getFleet() {
        return fleet;
    }

    public void setFleet(Ship[] fleet) {
        this.fleet = fleet;
    }

    public void printBoard(Boolean endGame) {
        String boardStatus = "";
        for (int yy = 0; yy < Board.BOARD_Y; yy++) {
            for (int xx = 0; xx < Board.BOARD_X.length; xx++) {
                if (!board[yy][xx].getStatus().equals(Ship.HIT) && !endGame) {
                    boardStatus = boardStatus + TWO_SPACES + Location.EMPTY;
                } else {
                    boardStatus = boardStatus + TWO_SPACES + board[yy][xx].getStatus();
                }
            } //end x
            boardStatus = boardStatus + TWO_SPACES + TWO_SPACES + ((yy + 1)) + "\n";

        } //end y

        int borderLength = ((Double) Math.floor(((BOARD_X.length + (BOARD_X.length * TWO_SPACES.length())) - boardName.length()) / 2)).intValue();
        String border = "";
        for (int i = 0; i < borderLength; i++) {
            border = border + "*";
        }
        System.out.println(border + TWO_SPACES + boardName + TWO_SPACES + border);
        System.out.println(boardStatus);

        String boardFooter = "";
        for (String xLabels : BOARD_X) {
            boardFooter = boardFooter + TWO_SPACES + xLabels;
        }
        System.out.println(boardFooter);

    }//end printbaord

    public Boolean isBoardGameOver() {
        if (piecesLeft == 0) {
            return true;
        }
        return false;
    }

}
/**
 * Board FINAL BOARD_SIZE FINAL NUMBER_OF_SHIPS FINAL Array Int[] SHIP_SIZES
 * {2,3,3,4,5}	//grant googled this for me
 *
 * Array Ships Int shipsSank Array board Int[]	//0 empty,1 guessed, 2 ship, 3
 * ship hit
 *
 * printBoard
 */
