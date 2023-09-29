public class Deck {

    public Card drawCard() {
        int valueNumber = (int)(Math.random() * 13) + 1;
        int suitNumber = (int)(Math.random() * 4) + 1;

        String suit = null;
        switch (suitNumber){
            case 1:
                suit = "Spades";
                break;
            case 2:
                suit = "Clubs";
                break;
            case 3:
                suit = "Hearts";
                break;
            case 4:
                suit = "Diamonds";
                break;
        }
        return new Card(valueNumber, suit);
    }
    
}
