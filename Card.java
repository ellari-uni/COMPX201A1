public class Card {
    public enum Suits{
        Spades,
        Hearts,
        Diamonds,
        Clubs
    }
    private int number = 0;
    private Suits suit = null;

    public Card(Suits suit, int number){
        this.suit = suit;
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public Suits getSuit(){
        return suit;
    }

    public void print(){
        String outString = number + " of " + suit;
        System.out.print(outString);
    }

    public boolean equals(Object o){
        if (!(o instanceof Card)) {
            return false;
        }


        if (((Card)o).number == number && ((Card)o).suit == suit) {
            return true;
        }
        else {
            return false;
        }
    }
}
