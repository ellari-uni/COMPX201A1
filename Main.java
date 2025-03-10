
public class Main {
    public static void main(String[] args){
        Card card = new Card(Card.Suits.Clubs, 2);
        Card card2 = new Card(Card.Suits.Clubs, 3);
        Card card3 = new Card(Card.Suits.Spades, 5);
        Card card4 = new Card(Card.Suits.Spades, 2);

        Card card5 = new Card(Card.Suits.Clubs, 2);
        
        card.print();

        System.out.println("Equivalence check: card 1 and card 2: "+ card.equals(card2));
        System.out.println("Equivalence check: card 1 and card 3: "+ card.equals(card3));
        System.out.println("Equivalence check: card 1 and card 4: "+ card.equals(card4));
        System.out.println("Equivalence check: card 1 and card 5: "+ card.equals(card5));
        //Testing non-Card inputs
        System.out.println("Equivalence check: card 1 and card 5: "+ card.equals("Test"));
        System.out.println();
        CardLinkedList ll = new CardLinkedList();
        ll.add(card);
        ll.add(card2);
        ll.add(card3);
        ll.add(card4);
        ll.add(card5);
        ll.print();

        ll.remove(new Card(Card.Suits.Spades, 5));
        ll.print();
    }
}