import java.util.Random;
public class CardDraw {
    public static void main(String[] args){        
        Random rand = new Random();

        CardLinkedList deck = new CardLinkedList();
        for (Card.Suits suit : Card.Suits.values()){
            for (int i = 1; i <= 13; i++){
                deck.add(new Card(suit, i));
            }
        }
        deck.print();
        System.out.println(deck.getLength());

        CardLinkedList[] hands = new CardLinkedList[10];
        for (int i = 0; i < 10; i++){
            hands[i] = new CardLinkedList();
            for (int j = 0; j < 5; j++){
                hands[i].add(deck.remove(deck.getRandomCard()));
                System.out.println(deck.getLength());
            }
            hands[i].print();
            System.out.println("Hand no: " + i);
        }
        System.out.println("Test");
        
        
        /*
        CardLinkedList ll = new CardLinkedList();
        //Place all tests for the class methods in a separate method to ensure the test code is saved when I create part 2
        TestingMethods(ll);
        */
    }
    /**
     * Storage of tests for all LinkedList methods
     * @param ll Linked List to test
     */
    private static void TestingMethods(CardLinkedList ll){
        //Initialize cards
        Card card = new Card(Card.Suits.Spades, 5);
        Card card2 = new Card(Card.Suits.Clubs, 5);
        Card card3 = new Card(Card.Suits.Diamonds, 12);
        Card card4 = new Card(Card.Suits.Hearts, 1);
        Card card5 = new Card(Card.Suits.Spades, 7);

        card.print();
        //Check equalities of various cards
        System.out.println("Equivalence check: card 1 and card 2: "+ card.equals(card2));
        System.out.println("Equivalence check: card 1 and card 3: "+ card.equals(card3));
        System.out.println("Equivalence check: card 1 and card 4: "+ card.equals(card4));
        System.out.println("Equivalence check: card 1 and card 5: "+ card.equals(card5));
        //Testing non-Card inputs
        System.out.println("Equivalence check: card 1 and card 5: "+ card.equals("Test"));

        System.out.println();
        
        //Check length and empty status while empty
        System.out.println("Length of LL: " + ll.getLength());

        System.out.println("LL is empty? " + ll.isEmpty());

        //Add bunch of cards
        ll.add(card);
        ll.add(card2);
        ll.add(card3);
        ll.add(card4);
        ll.add(card5);

        //Check length and empty status while not empty
        System.out.println("LL is empty? " + ll.isEmpty());

        System.out.println("Length of LL: " + ll.getLength());
        
        //Check hasCard
        System.out.println("List has card: " + card +" - " + ll.hasCard(card));

        //getCardAt -> valid and invalid indices
        System.out.println("Retrieving card " + card3 + " at index 2: "+ ll.getCardAt(2));
        System.out.println("Retrieving out of bounds at index 5: "+ ll.getCardAt(5));

        //testing before and after of remove
        ll.print();
        ll.remove(card4);
        ll.print();
    }
}