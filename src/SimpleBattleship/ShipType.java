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
public enum ShipType {
    CARRIER(5, "Carrier", "C"), BATTLESHIP(4, "Battleship", "B"), SUBMARINE(
            3, "Submarine", "S"), CRUISER(3, "Cruiser", "c"), DESTROYER(2,
            "Destroyer", "d");

    private final int SIZE;
    private final String MODEL;
    private final String IDENTIFIER;

    ShipType(int length, String name, String identifier) {
        this.SIZE = length;
        this.MODEL = name;
        this.IDENTIFIER = identifier;
    }

    public int getSize() {
        return SIZE;
    }

    public String getModel() {
        return MODEL;
    }
    
    public String getIdentifier() {
        return IDENTIFIER;
    }



}
