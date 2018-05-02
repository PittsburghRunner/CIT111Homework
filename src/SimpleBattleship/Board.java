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

    private static int board[];
    //TODO: multidimentional array

    public void setBoardSize(int size) {
        board = new int[size];
    }

    public int getLocationStatus(int location) {
        int status = 0;
        if (board.length + 1 < location) {
            status = board[location - 1];
        }
        return status;
    }

    public Boolean setLocationStatus(int location, int status) {
        if (board[location] == 0) {
            board[location] = status;
            return true;
        }
        return false;
    }

    public Boolean setShipLocation(int location, int size) {
        for (int i = location - 1; i < location - 1 + size; i++) {
            if (getLocationStatus(location) != 0) {
                return false;
            }
        }
        for (int i = location - 1; i < location - 1 + size; i++) {
            setLocationStatus(i, 2);
        }
        return true;
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
