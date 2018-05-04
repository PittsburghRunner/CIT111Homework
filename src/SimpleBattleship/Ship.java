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
public class Ship {

    private int shipId;

    private int shipSize;
    private int shipStartX;
    private int shipStartY;
    private int shipDirection;

    public int getShipDirection() {
        return shipDirection;
    }

    private String shipStatus[];

    public Ship(int id, int x, int y, int direction, int size) {
        setShipId(id);
        setShipStartLocation(x, y, direction);
        setShipSize(size);
    }

    public int getShipId() {
        return shipId;
    }

    private void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public int getShipSize() {
        return this.shipSize;
    }

    private void setShipSize(int size) {
        this.shipSize = size;
        this.shipStatus = new String[size];
        for (int i = 0; i < shipStatus.length; i++) {
            shipStatus[i] = Board.LOCATION_SHIP;
        }

    }

    public String getShipStartLocation() {
        return Board.BOARD_X[this.shipStartX] + (this.shipStartY + 1) + " heading " + Board.DIRECTION[shipDirection];
    }

    private void setShipStartLocation(int x, int y, int direction) {
        this.shipStartX = x;
        this.shipStartY = y;
        this.shipDirection = direction;
    }

    public Boolean hit(int section) {

        for (String status : shipStatus) {

            if (shipStatus[section].equals(Board.LOCATION_SHIP)) {
                shipStatus[section] = Board.LOCATION_HIT;
                System.out.println("I'm hit!");
                this.isSank();
                return true;
            }
        }
        System.out.println("Hit");
        return false;
    }

    public Boolean isSank() {
        for (String status : shipStatus) {
            if (status.equals(Board.LOCATION_SHIP)) {
                return false;
            }
        }
        System.out.println("You Sank My Battle Ship!");
        return true;

    }

}
