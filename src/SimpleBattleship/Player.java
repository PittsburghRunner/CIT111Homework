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
import java.util.Collection;

/**
 *
 * @author ceckles
 */
public class Player {

    private static final String COMPUTER_STRING = "computer";
    private String playerName = "Not Sure";
    private int numberOfHits = 0;
    private int numberOfMisses = 0;
    private Board playerBoard;
    private Boolean isComputer = true;
    private Boolean isGameOver = false;
    private Collection<FiredMissle> firedMissles;

    //constructor
    public Player(String name) {
        this.firedMissles = new ArrayList<>();
        this.setPlayerName(name);
        this.isComputer = name.trim().toLowerCase().contains(COMPUTER_STRING);
        this.playerBoard = new Board(this);
    }

    private void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getNumberOfHits() {
        return numberOfHits;
    }

    public void incrementNumberOfHits() {
        this.numberOfHits++;
    }

    public int getNumberOfMisses() {
        return numberOfMisses;
    }

    public void incrementNumberOfMisses() {
        this.numberOfMisses++;
    }

    public Boolean getIsComputer() {
        return isComputer;
    }

    public void setIsComputer(Boolean isComputer) {
        this.isComputer = isComputer;
    }

    public Boolean isGameOver() {
        return playerBoard.isBoardGameOver();
    }

    public void addFiredMissle(Player opponent, int x, int y, String onTarget, FiredMissle previousMissle) {
        firedMissles.add(new FiredMissle(opponent, x, y, onTarget, previousMissle));
    }

    public Collection<FiredMissle> getFiredMissles(Player opponent) {
        return firedMissles;
    }

    public void printStats() {
        System.out.println("\n" + playerName + " stats: \nHits: " + numberOfHits + " \nMisses: " + numberOfMisses + "\nShips Left: " + playerBoard.getPiecesLeft());
    }
}
