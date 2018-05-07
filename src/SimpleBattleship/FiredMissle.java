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
public class FiredMissle {

    private final Player opponent;
    private final int x;
    private final int y;
    private final String onTarget;
    private final FiredMissle previousMissle;

    public FiredMissle(Player opponent, int x, int y, String onTarget, FiredMissle previousMissle){
        this.opponent = opponent;
        this.x = x;
        this.y = y;
        this.onTarget = onTarget;
        this.previousMissle = previousMissle;
    }

    public Player getOpponent() {
        return opponent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getOnTarget() {
        return onTarget;
    }

    public FiredMissle getPreviousMissle() {

        return previousMissle;
    }

    public Boolean hasPreviousMissle() {
        return previousMissle != null;
    }
    
    @Override
    public String toString(){
       return opponent.getPlayerName() + ": " + Board.BOARD_X[x] + (y+1) +" - " + (hasPreviousMissle()? "prev:" + previousMissle.toString():"");
    }

}
