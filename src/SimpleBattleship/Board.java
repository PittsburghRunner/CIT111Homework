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
    public static final int BOARD_LONGITUTDE = 20;
    public static final String BOARD_LATITUDE[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R"};
    public static final String LOCATION_EMPTY = "^";
    public static final String LOCATION_MISSED = "M";
    public static final String LOCATION_SHIP = "S";
    public static final String LOCATION_HIT = "X";
    public static final String LOCATION_SPACING = "  ";

    protected int shipsLeft = SHIP_SIZES.length;
    protected Ship[] fleet = new Ship[SHIP_SIZES.length];
    protected int boardSize = BOARD_LONGITUTDE * BOARD_LATITUDE.length;

    private String board[];
    private String boardName;
    //TODO: multidimentional array

    Board(Player player) {
        // build board 
        setBoardSize(boardSize);
        setBoardName(player.getPlayerName());
        // place ship(){
        for (int i = 0; i < SHIP_SIZES.length; i++) {
            Ship ship = new Ship();
            ship.setShipSize(SHIP_SIZES[i]);
            Boolean set = false;
            int location = 0;
            setShipLocation(90, 10);

            while (!set) {
                int random = RandomNumber.generateRandomLocation(boardSize - ship.getShipSize() - 1);
                if (setShipLocation(random, ship.getShipSize())) {
                    set = true;
                    location = random;
                }
            }
            System.out.println("Location of " + (i) + " ship: " + location + " - " + (location + SHIP_SIZES[i] - 1));
            ship.setShipStartLocation(location);
            fleet[i] = ship;
        }
    }

    private void setBoardSize(int size) {
        board = new String[size];
        for (int i = 0; i < size; i++) {
            board[i] = LOCATION_EMPTY;
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

    public String getLocationStatus(int location) {
        String status = LOCATION_EMPTY;
        if (location <= board.length) {
            status = board[location];
        }
        return status;
    }

    public Boolean setLocationStatus(int location, String status) {
        if (board[location].equals(LOCATION_EMPTY)) {
            board[location] = status;
            return true;
        }
        return false;
    }

    private Boolean setShipLocation(int location, int size) {
        for (int i = location; i < location + size; i++) {

            if (getLocationStatus(i).equals(LOCATION_SHIP)) {
                System.out.println("recaulate... ship already here");
                return false;
            }
        }
        for (int i = location; i < location + size; i++) {
            setLocationStatus(i, LOCATION_SHIP);
        }
        return true;
    }

    public void printBoard(Boolean endGame) {
        String boardStatus = "";
        for (int i = 0; i < board.length; i++) {
            if (!board[i].equals(LOCATION_HIT) && !endGame) {
                boardStatus = boardStatus + LOCATION_SPACING + LOCATION_EMPTY;
            } else {
                boardStatus = boardStatus + LOCATION_SPACING + board[i];
            }
            if ((i + 1) % BOARD_LATITUDE.length == 0) {
                boardStatus = boardStatus + LOCATION_SPACING + LOCATION_SPACING + ((i / BOARD_LATITUDE.length)) + "\n";
            }
        }
        int borderLength = ((Double) Math.floor(((BOARD_LATITUDE.length + (BOARD_LATITUDE.length * LOCATION_SPACING.length())) - boardName.length()) / 2)).intValue()+2;
        System.out.println("Border Length" + borderLength);
        String border = "";
        for (int i = 0; i < borderLength; i++) {
            border = border + "*";
        }
        System.out.println(border + boardName + border);
        System.out.println(boardStatus);

        String boardFooter = "";
        for (int i = 0; i < BOARD_LATITUDE.length; i++) {
            boardFooter = boardFooter + LOCATION_SPACING + BOARD_LATITUDE[i];
        }
        System.out.println(boardFooter);

    }

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
