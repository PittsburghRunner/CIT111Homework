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
public class Airplane {

    private int totalMilesFlown = 0;
    private int totalPassengerMiles = 0;
    private int totalPassengers = 0;

    public void flyAirplane(int miles, int passengers) {
        //a plane cannot fly negative miles
        if (miles > 0) {
            System.out.println("Flying Airplane " + miles + " mile" + ((miles > 1) ? "s" : "") + " with " + passengers + " passenger" + ((passengers > 1) ? "s" : "") + " on board.");
            totalMilesFlown = totalMilesFlown + miles;
            totalPassengerMiles = totalPassengerMiles + (miles * passengers);
        } //close if
        else {
            System.out.println("Error: Distance cannot be negative.");
        }//close else

    }//close method

    public int displayTotalMilesFlown() {
        //print the total miles flown
        System.out.println("Total Miles Flown: " + totalMilesFlown);
        return totalMilesFlown;
    }//close method

    public int displayPassengerMiles() {
        //print the total passenger miles flown
        System.out.println("Total Passenger Miles Flown: " + totalPassengerMiles);
        return totalPassengerMiles;
    }//close method

    public void checkLegalRegion() {
        String region;
        //less than 10 million miles
        if (this.totalMilesFlown <= 10000000) {
            region = "North America";
            //less than 20 million miles
        } else if (this.totalMilesFlown <= 20000000) {
            region = "SouthEast Asia";
            //over 20 million miles
        } else {
            region = "Africa";
        }
        System.out.println("Legal region: " + region);
    }
}//close class
