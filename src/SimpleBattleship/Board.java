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
    public static final String DIRECTION[] = {"North to South", "East to West"};

    public static final String BOARD_X[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R"};
    public static final int BOARD_Y = 10;

    public static final int NO_SHIP = -1;
    public static final String LOCATION_EMPTY = "^";
    public static final String LOCATION_MISSED = "M";
    public static final String LOCATION_SHIP = "S";
    public static final String LOCATION_HIT = "X";
    public static final String LOCATION_SPACING = "~~";

    protected int shipsLeft = SHIP_SIZES.length;
    protected Ship[] fleet = new Ship[SHIP_SIZES.length];

    private Location board[][];
    private String boardName;
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
                System.out.println("direction: " + direction);
                int y_range;
                int x_range;
                if (direction == 1) {
                    x_range = BOARD_Y - 1;
                    y_range = BOARD_X.length - size - 2;
                } else {
                    x_range = BOARD_Y - size - 2;
                    y_range = BOARD_X.length - 1;
                }
                int y = RandomNumber.generateRandomLocation(y_range);
                int x = RandomNumber.generateRandomLocation(x_range);
                System.out.println("direction: " + direction);

                if (setShipLocation(id, x, y, direction, size)) {
                    set = true;
                    System.out.println("direction: " + direction);

                    ship = new Ship(id, x, y, direction, size);
                    System.out.println("Location of " + ship.getShipId() + " ship: " + ship.getShipStartLocation());
                    fleet[id] = ship;

                }

            }

        }
    }

    private void setBoardSize(int x, int y) {
        board = new Location[y][x];
        for (int yy = 0; yy < y; yy++) {
            for (int xx = 0; xx < x; xx++) {
                System.out.println("X:" + Board.BOARD_X[xx] + " - Y:" + yy);
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
        System.out.println("getLocation: y" + y + "x" + x);
        if (y <= BOARD_Y && x <= BOARD_X.length) {
            return board[y][x];
        }
        System.out.println("Out of bounds.");
        return new Location();
    }

    private Boolean setShipLocation(int id, int x, int y, int direction, int size) {
        if (direction == 1) {
            for (int i = y; i < y + size; i++) {
                if (getLocation(i, x).getStatus().equals(LOCATION_SHIP)) {
                    System.out.println("recaulate... ship already here");
                    return false;
                }
            }
            for (int yy = y; yy < y + size; yy++) {
                getLocation(yy, x).setOccupiedBy(id);
            }
            return true;
        } else {
            for (int xx = x; xx < x + size; xx++) {
                if (getLocation(y, xx).getStatus().equals(LOCATION_SHIP)) {
                    System.out.println("recaulate... ship already here");
                    return false;
                }
            }
            for (int xx = x; xx < x + size; xx++) {
                getLocation(y, xx).setOccupiedBy(id);
            }
            return true;
        }
    }//end setShipLocation

    public void printBoard(Boolean endGame) {
        String boardStatus = "";
        for (int yy = 0; yy < Board.BOARD_Y; yy++) {
            for (int xx = 0; xx < Board.BOARD_X.length; xx++) {
                if (!board[yy][xx].getStatus().equals(LOCATION_HIT) && !endGame) {
                    boardStatus = boardStatus + LOCATION_SPACING + LOCATION_EMPTY;
                } else {
                    boardStatus = boardStatus + LOCATION_SPACING + board[yy][xx].getStatus();
                }
            } //end x
            boardStatus = boardStatus + LOCATION_SPACING + LOCATION_SPACING + ((yy + 1)) + "\n";

        } //end y

        int borderLength = ((Double) Math.floor(((BOARD_X.length + (BOARD_X.length * LOCATION_SPACING.length())) - boardName.length()) / 2)).intValue();
        String border = "";
        for (int i = 0; i < borderLength; i++) {
            border = border + "*";
        }
        System.out.println(border + LOCATION_SPACING + boardName + LOCATION_SPACING + border);
        System.out.println(boardStatus);

        String boardFooter = "";
        for (String xLabels : BOARD_X) {
            boardFooter = boardFooter + LOCATION_SPACING + xLabels;
        }
        System.out.println(boardFooter);

    }//end printbaord

    public Boolean isBoardGameOver() {
        if (shipsLeft == 0) {
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
