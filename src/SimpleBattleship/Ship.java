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
private int shipSize = 0;
private int shipStartLocation = 0;
private Boolean isSank = false;
private static int shipStatus[];

public int getShipSize(){
    return this.shipSize;
}

public void setShipSize(int size){
    this.shipSize = size;
    this.shipStatus = new int[size];
}

public int getShipStartLocation(){
    return this.shipStartLocation;
}

public void setShipStartLocation(int size){
    this.shipStartLocation = size;
}

}
