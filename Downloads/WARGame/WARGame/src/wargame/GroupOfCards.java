/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hash0
 */
public class GroupOfCards {
    
    private List<Card> deck;

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
    
    
    public GroupOfCards() {
        deck = new ArrayList<>();
        
        String[] ranks= {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack","Queen","King","ACE"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        
        for (String s : suits) {
            for (String r : ranks) {
                deck.add(new Card(s,r));
            } 
        } 
        Collections.shuffle(deck);
    }
    
    
    
    public Card drawCard() {
        if (deck.size() > 0) {
            return deck.remove(0);
        }
        return null; 
    }
    
    
    public Card chooseCard(int index) {
        if (index >= 0 && index < deck.size()) {
            return deck.remove(index);
        } return null;
    }
    
   
}
