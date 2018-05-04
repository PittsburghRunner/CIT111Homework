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
public class Player {

    private String playerName = "Not Sure";
    private int numberOfHits = 0;
    private int numberOfMisses = 0;
    private Board playerBoard;
    private Boolean isComputer = true;
    private Boolean isGameOver = false;

    //constructor
    public Player(String name) {
        this.setPlayerName(name);
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

    public void setNumberOfHits(int numberOfHits) {
        this.numberOfHits = numberOfHits;
    }

    public int getNumberOfMisses() {
        return numberOfMisses;
    }

    public void setNumberOfMisses(int numberOfMisses) {
        this.numberOfMisses = numberOfMisses;
    }

    public Boolean getIsComputer() {
        return isComputer;
    }

    public void setIsComputer(Boolean isComputer) {
        this.isComputer = isComputer;
    }

    public Boolean getIsGameOver(BattleShip game) {
        return isGameOver;
    }

    public void setIsGameOver(Boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}
