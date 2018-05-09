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
package battleship;

/**
 * 
 * @author christopher.eckles
 */
public class Ship {

    public static final String MISSED = "M";
    public static final String HIT = "X";

    private final ShipType shipType;

    private int shipId;
    private int shipDirection;
    private int shipSectionsLeft;

    //Constructor for new Ships
    public Ship(int id, ShipType shipType) {
        this.shipId = id;
        this.shipType = shipType;
        this.shipSectionsLeft = shipType.getSize();
    }
    
    public int getShipDirection() {
        return shipDirection;
    }
    
    public int getShipId() {
        return shipId;
    }

    public ShipType getShipType() {
        return this.shipType;
    }

    /**
     * this reduces the section number by 1
     * and determines if a players ship can be.
     * @return
     */
    public boolean decrementShipSectionsLeft() {
        if (shipSectionsLeft > 0) {
            shipSectionsLeft--;
            return true;
        }
        System.out.println("Unable to decrement.");
        return false;
    }
    public int getShipSectionsLeft() {
        return shipSectionsLeft;
    }

    public Boolean isSank() {
        return (shipSectionsLeft == 0);
    }

}
