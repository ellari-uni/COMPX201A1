public class CardDraw {
    public static void main(String[] args){        

        CardLinkedList deck = new CardLinkedList();
        for (Card.Suits suit : Card.Suits.values()){
            for (int i = 1; i <= 13; i++){
                deck.add(new Card(suit, i));
            }
        }
        CardLinkedList[] playerHands = new CardLinkedList[10];
        for (int i = 0; i < playerHands.length; i++){
            playerHands[i] = new CardLinkedList();
        }
        for(int i = 0; i < playerHands.length; i++){
            for(int j = 0; j < 5; j++) playerHands[i].add(deck.getRandomCard());
        }

        System.out.println("Populated Player Hands *** Remove once full implementation");
    }
    /**
     * Storage of tests for all LinkedList methods
     * ** Part One of assignment**
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
    /**
     * Method used for debugging the player hands
     * @param lla Array of Linked Lists (player hands)
     */
    private static void printAllHands(CardLinkedList[] lla){
        for(CardLinkedList hand : lla){
            hand.print();
            System.out.println();
        }
    }
}