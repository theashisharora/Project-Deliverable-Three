/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hash0
 */
public class Game {
    
    private Player user;
    private Player bot;
    private int rounds;
    private static final int TOTAL_ROUNDS = 7;
    private Scanner scanner;

    public Game(String user) {
        this.user = new Player(user);
        this.bot = new Player("Bot");
        this.rounds = 0;
        this.scanner=new Scanner(System.in);
    }
    
    

    public void PlayRound() {
        
        if (rounds >= TOTAL_ROUNDS) {
            Winner();
            return;
        }
        
        
        List<Card> humanDeck = user.getDeck();
        System.out.println(user.getPlayerName()+ ", here are your cards:");
        for (int i = 0; i < humanDeck.size(); i++) {
            Card card = humanDeck.get(i);
            System.out.println(i + ": " + card.getRank() + " of " + card.getSuit());
        } 
        
        System.out.println("Choose a card by its index:");
        int index = scanner.nextInt();
        Card userCard = user.chooseCard(index);
        
        
        Random random = new Random();
        Card computerCard = bot.drawCard();

        if (userCard != null && computerCard != null) {
            
            
            System.out.println(user.getPlayerName()+ " drew " + userCard.getRank() + " of " + userCard.getSuit());
            System.out.println(bot.getPlayerName() + " drew " + computerCard.getRank() + " of " + computerCard.getSuit());
            
            if (compareCards(userCard,computerCard)>0) {
                user.incrementScore(1);
                System.out.println(user.getPlayerName()+ " wins this round!");
            } else if (compareCards(userCard, computerCard) < 0) {
                bot.incrementScore(1);
                System.out.println(bot.getPlayerName()+ " wins this round!");
            } else {
                System.out.println("Tie!!");
            }
            rounds++;  
        }
    }
    
    
    
    
    public int compareCards(Card c1, Card c2) {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        List<String> rankList = Arrays.asList(ranks);
        return Integer.compare(rankList.indexOf(c1.getRank()), rankList.indexOf(c2.getRank()));
    }

    
    

    public void Winner() {
        System.out.println("Here's the Final scores : ");
        System.out.println(user.getPlayerName()+ ": " + user.getPlayerScore());
        System.out.println(bot.getPlayerName()+ ": " + bot.getPlayerScore());
        if (user.getPlayerScore()> bot.getPlayerScore()) {
            System.out.println(user.getPlayerName() + " wins the game!");
        } else if (user.getPlayerScore() < bot.getPlayerScore()) {
            System.out.println(bot.getPlayerName() + " wins the game!");
        } else {
            System.out.println("The game is a tie! Entering War phase.");
            playWar();
        }
    }

    
    
    
    
    public void playWar() {
        for (int i = 0; i < 3; i++) {
            PlayRound();
            if (user.getPlayerScore() > bot.getPlayerScore()) {
                System.out.println(user.getPlayerName()+ " wins this War phase!");
                return;
            } else if (user.getPlayerScore()< bot.getPlayerScore()) {
                System.out.println(bot.getPlayerName()+ " wins this War phase!");
                return;
            }
        }
        System.out.println("The War phase ended in a tie!");
    }
}

