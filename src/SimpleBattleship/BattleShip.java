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

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ceckles
 */
public class BattleShip {

    public final ArrayList<Player> players = new ArrayList();

    public BattleShip(Player[] gamePlayers) {
        this.players.addAll(Arrays.asList(gamePlayers));
        
        //build the boards
        for (Player player : players) {
            int indexOf = players.indexOf(player);
            if (SimpleBattleShip.DEBUG)System.out.println("indexOf" + indexOf);
            player.getPlayerBoard().printBoard(true);
        }
        //play the game
//        while(false)
//            //everyone take a turn
//            for (Player player : players) {
//            if (!player.getIsGameOver(this)){
//                
//            }
//            
//        }
//        }
//        System.out.println("That was fun, lets play again!");
//
    }
}
