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
        Airplane serialN947JB = new Airplane();

        //simulating flights until miles hits 21000000
        while (serialN947JB.displayTotalMilesFlown() <= 21000000) {
            //flying airplane 80000 miles.
            serialN947JB.flyAirplane(80000, 189);

            //flying airplane 5000 miles.
            serialN947JB.flyAirplane(50000, 300);

            //flying airplane 10000 miles.
            serialN947JB.flyAirplane(100000, 43);

            //flying airplane 500 miles.
            serialN947JB.flyAirplane(5000, 290);

            //check legal region.
            serialN947JB.checkLegalRegion();
        }//close while
        
        serialN947JB.displayPassengerMiles();
    }//close main
}//close class
