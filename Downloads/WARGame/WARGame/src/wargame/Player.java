/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

import java.util.List;

/**
 *
 * @author hash0
 */
public class Player {
    private String playerName;
    private int playerScore;
    private GroupOfCards magicHand;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }
    
    public Player(String playerName) {
        this.playerName = playerName;
        this.playerScore = 0;
        this.magicHand=new GroupOfCards();
    }
    
    public void incrementScore(int points) {
        playerScore += points;
    }
    
    public void decrementScore(int points) {
        playerScore -= points;
    }
    
    public Card drawCard() {
        return magicHand.drawCard();
    }
  

    public Card chooseCard(int index) {
        return magicHand.chooseCard(index);
    }
    
    
    public List<Card> getDeck() {
        return magicHand.getDeck();
    }
    
    
}
