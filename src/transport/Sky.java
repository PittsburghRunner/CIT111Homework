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
package transport;

/**
 *
 * @author christopher.eckles
 */
public class Sky {

    public static void main(String[] args) {

        // creating flight1810
        Airplane flight1810 = new Airplane();

        //flying airplane 8000 miles.
        flight1810.flyAirplane(8000);

        //flying airplane 500 miles.
        flight1810.flyAirplane(500);

        //display total miles flown
        flight1810.displayTotalMilesFlown();
    }//close main
}//close class
