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
 * @author hash0, Ashish, Gursewak, Arshdeep
 */
public class Game {
    
    private Player user;
    private Player bot;
    private int rounds;
    private static final int TOTAL_ROUNDS = 7;
    private Scanner scanner;
    String designWin="========================";
    String invalid="!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";

    public Game(String user) {
        this.user = new Player(user);
        this.bot = new Player("Bot");
        this.rounds = 0;
        this.scanner=new Scanner(System.in);
    }

    public void playRound() {
        if (rounds >= TOTAL_ROUNDS) {
            determineWinner();
            return;
        }
        
        Card userCard = null;

        while (userCard == null) {
            System.out.print("\nChoose Rank (2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace): ");
            String rank = scanner.nextLine();

            System.out.print("Choose Suit (Hearts, Diamonds, Clubs, Spades): ");
            String suit = scanner.nextLine();

            userCard = user.chooseCard(suit, rank);

            if (userCard == null) {
                System.out.println("\n" + invalid);
                System.out.println("!! Invalid card choice, Please try again !!");
                System.out.println(invalid);
            }
        }


        Card botCard = bot.drawCard();

        System.out.println("\n"+user.getPlayerName() + " drew " + userCard.getRank() + " of " + userCard.getSuit());
        System.out.println(bot.getPlayerName() + " drew " + botCard.getRank() + " of " + botCard.getSuit());

        if (compareCards(userCard, botCard) > 0) {
            user.incrementScore(1);
            System.out.println("\n"+designWin);
            System.out.println(user.getPlayerName() + " wins this round!");
            System.out.println(designWin);
        } else if (compareCards(userCard, botCard) < 0) {
            bot.incrementScore(1);
            System.out.println("\n"+designWin);
            System.out.println(bot.getPlayerName() + " wins this round!");
            System.out.println(designWin);
        } else {
            System.out.println("\n========");
            System.out.println("Tie!!");
            System.out.println("========");
        }
        rounds++;
    }

    public int compareCards(Card c1, Card c2) {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        List<String> rankList = Arrays.asList(ranks);
        return Integer.compare(rankList.indexOf(c1.getRank()), rankList.indexOf(c2.getRank()));
    }

    public void determineWinner() {
        System.out.println("\nFinal scores :>> ");
        System.out.println(user.getPlayerName() + ": " + user.getPlayerScore());
        System.out.println(bot.getPlayerName() + ": " + bot.getPlayerScore());
        if (user.getPlayerScore() > bot.getPlayerScore()) {
            System.out.println("\n"+designWin);
            System.out.println(user.getPlayerName() + " wins the game!");
            System.out.println(designWin+"\n");
        } else if (user.getPlayerScore() < bot.getPlayerScore()) {
            System.out.println("\n"+designWin);
            System.out.println(bot.getPlayerName() + " wins the game!");
            System.out.println(designWin+"\n");
        } else {
            System.out.println("\nThe game tied!! Entering War phase :>>");
            playWar();
        }
    }

    public void playWar() {
        for (int i = 0; i < 3; i++) {
            playRound();
            if (user.getPlayerScore() > bot.getPlayerScore()) {
                System.out.println("\n"+designWin);
                System.out.println(user.getPlayerName() + " wins this War phase!\n");
                System.out.println(designWin);
                return;
            } else if (user.getPlayerScore() < bot.getPlayerScore()) {
                System.out.println("\n"+designWin);
                System.out.println(bot.getPlayerName() + " wins this War phase!\n");
                System.out.println(designWin);
                return;
            }
        }
        System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println("The War phase ended in a tie!");
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
    }
    
}   
