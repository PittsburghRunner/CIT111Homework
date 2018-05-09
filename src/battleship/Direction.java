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
package battleship;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ceckles
 */
public enum Direction {
    NORTH("North", 0, 1), SOUTH("South", 0, -1), EAST("East", 1, 0), WEST("West", -1, 0);

    private final String HEADING;
    private final int X_OFFSET;
    private final int Y_OFFSET;

    private Direction(String movePieces, int xOffset, int yOffset) {
        this.HEADING = movePieces;
        this.X_OFFSET = xOffset;
        this.Y_OFFSET = yOffset;
    }

    public String getHEADING() {
        return HEADING;
    }

    public int getX_OFFSET() {
        return X_OFFSET;
    }

    public int getY_OFFSET() {
        return Y_OFFSET;
    }

    public static Direction getNORTH() {
        return NORTH;
    }

    public static Direction getSOUTH() {
        return SOUTH;
    }

    public static Direction getEAST() {
        return EAST;
    }

    public static Direction getWEST() {
        return WEST;
    }

    public static List possibleDirections(Move previousMove) {
        List<Move> movesToMake;
        movesToMake = new ArrayList();
        int x = previousMove.getX();
        int y = previousMove.getY();
        
        for (Direction moves : Direction.values()) {
            int xMove = x+moves.X_OFFSET;
            int yMove = y+moves.Y_OFFSET;
            movesToMake.add(new Move(previousMove.getOpponent(),xMove,yMove,Location.UNSET_TARGET,previousMove));
}
        
        
                

        return  movesToMake;
    }

}
