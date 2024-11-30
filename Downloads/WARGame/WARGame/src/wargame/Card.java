/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

/**
 *
 * @author hash0
 */
public class Card {
    
   private String suit; //clubs, spades, diamonds, hearts
   private String rank;//2-13

   
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
   
//
//   public static final String [] suits= {"Hearts", "Diamonds", "Spades", "Clubs"};
//   int[] ranks={2,3,4,5,6,7,8,9,10,11,12,13};

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
    
}
