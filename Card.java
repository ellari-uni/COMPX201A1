public class Card {
    /**
     * Enum to avoid invalid values
     */
    public enum Suits{
        Spades,
        Hearts,
        Diamonds,
        Clubs
    }
    private int number = 0;
    private Suits suit = null;
    /**
     * Initialize a card
     * @param suit Card's suit
     * @param number Card's number
     */
    public Card(Suits suit, int number){
        this.suit = suit;
        this.number = number;
    }

    /**
     * Number associated with card
     * @return card number
     */
    public int getNumber(){
        return number;
    }

    /**
     * Suit associated with card
     * @return suit
     */
    public Suits getSuit(){
        return suit;
    }

    /**
     * Print out the card in proper format
     */
    public void print(){
        String outString = number + " of " + suit;
        System.out.print(outString);
    }

    /**
     * Override tostring so it is easier to use while debugging (not an assessment method but I got bored of writing the same thing over and over)
     */
    public String toString(){
        return number + " of " + suit;
    }

    /**
     * Check whether two cards are equal
     */
    public boolean equals(Object o){
        //Return false if the inputted object isnt actually a card
        if (!(o instanceof Card)) {
            return false;
        }

        //Cast o as a card, if the numbers and suits are the same return true
        if (((Card)o).number == number && ((Card)o).suit == suit) {
            return true;
        }
        else {
            return false;
        }
    }
}
