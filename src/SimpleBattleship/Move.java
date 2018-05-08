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
public class Move {

    private final Player opponent;
    private final int x;
    private final int y;
    private final String onTarget;
    private final Move previousMove;

    public Move(Player opponent, int x, int y, String onTarget, Move previousMissle){
        this.opponent = opponent;
        this.x = x;
        this.y = y;
        this.onTarget = onTarget;
        this.previousMove = previousMissle;
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

    public Move getPreviousMove() {

        return previousMove;
    }

    public Boolean hasPreviousMove() {
        return previousMove != null;
    }
    
    @Override
    public String toString(){
       return opponent.getPlayerName() + ": " + Board.BOARD_X[x] + (y+1) +" - " + (hasPreviousMove()? "prev:" + previousMove.toString():"");
    }
    
    public Boolean isOpponent(Player opponent){
      return this.opponent == opponent;
    }
    
    public Boolean isInBounds(){
        return (x >= 0 && y >= 0 && x < Board.BOARD_X.length && y < Board.BOARD_Y );
}

}