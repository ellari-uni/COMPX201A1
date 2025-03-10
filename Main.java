public class Main {
    public static void main(String[] args){        

        CardLinkedList ll = new CardLinkedList();
        TestingMethods(ll);
    }

    private static void TestingMethods(CardLinkedList ll){
        Card card = new Card(Card.Suits.Spades, 5);
        Card card2 = new Card(Card.Suits.Clubs, 5);
        Card card3= new Card(Card.Suits.Diamonds, 12);
        Card card4 = new Card(Card.Suits.Hearts, 1);
        Card card5 = new Card(Card.Suits.Spades, 7);
        card.print();
        
        System.out.println("Equivalence check: card 1 and card 2: "+ card.equals(card2));
        System.out.println("Equivalence check: card 1 and card 3: "+ card.equals(card3));
        System.out.println("Equivalence check: card 1 and card 4: "+ card.equals(card4));
        System.out.println("Equivalence check: card 1 and card 5: "+ card.equals(card5));
        //Testing non-Card inputs
        System.out.println("Equivalence check: card 1 and card 5: "+ card.equals("Test"));
        System.out.println();
        
        
        System.out.println("Length of LL: " + ll.getLength());

        System.out.println("LL is empty? " + ll.isEmpty());

        ll.add(card);
        ll.add(card2);
        ll.add(card3);
        ll.add(card4);
        ll.add(card5);

        System.out.println("LL is empty? " + ll.isEmpty());

        System.out.println("Length of LL: " + ll.getLength());

        System.out.println("List has card: " + card +" - " + ll.hasCard(card));

        System.out.println("Retrieving card " + card3 + " at index 2: "+ ll.getCardAt(2)); 
        System.out.println("Retrieving out of bounds at index 5: "+ ll.getCardAt(5)); 

        ll.print();
        ll.remove(card4);
        ll.print();
    }
}