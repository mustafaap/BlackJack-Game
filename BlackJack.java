import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) throws InterruptedException {
        int playerWins = 0;
        int playerLosses = 0;
        int houseWins = 0;
        int houseLosses = 0;
        int ties = 0;
        int option = 1;
        Scanner scnr = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("Welcome to the BlackJack game!");
        System.out.println("******************************");


        while (option == 1) {
            Deck deck = new Deck();
            
            int houseTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);
            int playerTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);

            while (playerTotal <= 21){
                Thread.sleep(1000);
                System.out.println("\nThe house is showing: " + houseTotal);
                System.out.println("Player is showing: " + playerTotal);
                System.out.print("Would you like to hit or stand?\n\tEnter 1 for hit or 0 for stand: ");
                int choice = scnr.nextInt();
                if (choice == 0){
                    break;
                }
                else if (choice == 1){
                    Card nextCard = deck.drawCard();
                    System.out.println("Player draws the " + nextCard.declareCard());
                    playerTotal += nextCard.getValue(true);
                }
                else {
                    System.out.println("Invalid option try again.");
                }
            }
            if (playerTotal > 21) {
                System.out.println("Player is showing: " + playerTotal);
                Thread.sleep(1500);
                System.out.println("\nGame Results!\nThe Player has busted, the House wins");
                playerLosses = playerLosses + 1;
                houseWins = houseWins + 1;

            }
            else {
                Thread.sleep(1000);
                System.out.println("\nThe Player stands with " + playerTotal + " points.");
                System.out.println("The House will play next.");
                while (houseTotal <= 21){
                    Thread.sleep(1000);
                    System.out.println("\nThe House is showing: " + houseTotal);
                    if (houseTotal >= 17){
                    Thread.sleep(1000);
                    System.out.println("The House Stands!");
                    break;
                    }
                    else {
                    Thread.sleep(1000);
                    Card houseCard = deck.drawCard();
                    System.out.println("House draws the " + houseCard.declareCard());
                    houseTotal += houseCard.getValue(true);
                    }
                }
                if (houseTotal > 21){
                    Thread.sleep(1000);
                    System.out.println("\nHouse is showing: " + houseTotal);
                    Thread.sleep(1500);
                    System.out.println("\nGame Results!\nThe House has busted, the Player wins.");
                    playerWins = playerWins + 1;
                    houseLosses = houseLosses + 1;
                }
                else if (houseTotal > playerTotal){
                    Thread.sleep(1500);
                    System.out.println("\nGame Results!\nThe House's total exceeds the Player's, the House wins.");
                    houseWins = houseWins + 1;
                    playerLosses = playerLosses + 1;
                }
                else if (playerTotal > houseTotal){
                    Thread.sleep(1500);
                    System.out.println("\nGame Results!\nThe Player's total exceeds the House's, the Player wins.");
                    playerWins = playerWins + 1;
                    houseLosses = houseLosses + 1;
                }
                else {
                    Thread.sleep(1500);
                    System.out.println("\nGame Results!\nThe Player and House have the same total, they tie.");
                    ties = ties + 1;
                }
            }
            Thread.sleep(1000);
            System.out.print("\nEnter 1 if you would like to continue or 0 if you would want to quit: ");
            option = scnr.nextInt();
        }
        scnr.close();
        Thread.sleep(1000);
        System.out.println("\nFinal Results!");
        System.out.println("Player wins: " + playerWins);
        System.out.println("Player losses: " + playerLosses);
        System.out.println("House wins: " + houseWins);
        System.out.println("House losses: " + houseLosses);
        System.out.println("Ties: " + ties);
        System.out.println("\n**********************");
        System.out.println("Thank you for playing!");
        System.out.println("**********************");

      

 
    }
    
}
