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
public class SimpleBattleShip {

    public static final int BOARD_SIZE = 100;
    public static final int SHIP_SIZES[] = {2, 3, 3, 4, 5};

    public static int shipsLeft = SHIP_SIZES.length;
    public Ship[] fleet = new Ship[SHIP_SIZES.length];
    public Board board;

    public Boolean buildBoard() {
        // build board 
        board.setBoardSize(BOARD_SIZE);

        // place ship(){
        for (int i = 0; i < SHIP_SIZES.length; i++) {
            Ship ship = new Ship();
            ship.setShipSize(SHIP_SIZES[i]);
//TODO: set location 
            fleet[i] = ship;
        }
        return true;
    }

    public Boolean isGameOver() {
        if (SHIP_SIZES.length + 1 == shipsLeft) {
            return true;
        }
        return false;
    }
}
