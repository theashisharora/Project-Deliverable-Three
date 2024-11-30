/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wargame;

import java.util.Scanner;

/**
 *
 * @author hash0
 */
public class WARGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Player Name: ");
        String playerName = scanner.nextLine();
        Game game = new Game(playerName);

        for (int i = 0; i < 7; i++) {
            game.PlayRound();
        }
        game.Winner();
    }
    
}
