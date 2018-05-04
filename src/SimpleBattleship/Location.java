/*
 * Copyright (C) 2018 ceckles
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
 * @author ceckles
 */
public class Location {

    private String status;
    private int occupiedBy;

    //constructor
    public Location() {
        this.status = Board.LOCATION_EMPTY;
        this.occupiedBy = Board.NO_SHIP;
    }

    public String getStatus() {
        return status;
    }

    public Boolean setStatus(String status) {
        if (this.status.equals(Board.LOCATION_EMPTY) && (status.equals(Board.LOCATION_MISSED) || status.equals(Board.LOCATION_SHIP))) {
            this.status = status;
            return true;
        } else if (this.status.equals(Board.LOCATION_SHIP) && status.equals(Board.LOCATION_HIT)) {
            this.status = status;
            return true;
        } else {
            System.out.println("Invalid Status Change: " + this.status + " to " + status);
            return false;
        }
    }

    public int getOccupiedBy() {
        return occupiedBy;
    }

    public void setOccupiedBy(int occupiedBy) {
        this.status = Board.LOCATION_SHIP;
        this.occupiedBy = occupiedBy;
    }

}
