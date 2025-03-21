import java.util.Arrays;
import java.util.Collections;
public class CardDraw {
    public static void main(String[] args){        
        
        //Populate the deck with all card possibilities
        CardLinkedList deck = new CardLinkedList();
        //For every suit, add a card 1-13
        //The fact it is ordered doesn't matter as a card is removed from a random location anyway
        for (Card.Suits suit : Card.Suits.values()){
            for (int i = 1; i <= 13; i++){
                deck.add(new Card(suit, i));
            }
        }

        //Create array of playerHands. Later implementation could include specifying the players in the command argument, or doing a readLine
        CardLinkedList[] playerHands = new CardLinkedList[10];
        
        for (int i = 0; i < playerHands.length; i++){
            
            //For each player, initialise their hands as an empty LL
            playerHands[i] = new CardLinkedList();
        }
        
        //For Each player's hand
        for(int i = 0; i < playerHands.length; i++){
            
            //Add 5 random cards.
            for(int j = 0; j < 5; j++) {

                playerHands[i].add(deck.getRandomCard());
            }
        }
        Integer[][] scoring = new Integer[10][2];
        //Score every player's hand, and display the hand & the score
        for(int i = 1; i <= playerHands.length; i++){
            scoring[i-1][0] = i;
            System.out.print("Player " + i + " hand: ");
            playerHands[i-1].print();
            scoring[i-1][1] = scoreHand(playerHands[i-1]);
            System.out.println("Player " + i + " score: " + scoreHand(playerHands[i-1]));

            System.out.println();
        }
        Integer greatest = 0;
        Integer greatestPlayer = 0;
        for(int i = 0; i < scoring.length;i++){
            if(scoring[i][1] > greatest) {
                greatest = scoring[i][1];
                greatestPlayer = i+1;
            }
        }
        System.out.println("The Winner is Player " + greatestPlayer + " with a score of " + greatest);
        
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
    /**
     * Score a given hand
     * @param hand Hand to be scored
     * @return Score of the hand as an Integereger
     */
    private static Integer scoreHand(CardLinkedList hand){

        Integer score = 0;
        
        //Variable length, to ensure possibility of larger hand sizes
        Integer[] values = new Integer[hand.getLength()];
        
        //Format all number values as an Integereger array - as scoring doesn't rely on suits and it makes it easier to read
        for(int i = 0; i<values.length;i++){
            values[i] = hand.getCardAt(i).getNumber();
        }
        //Sort the array of values to make iteration easier
        Arrays.sort(values, Collections.reverseOrder());
        
        Integer counter = 1;
        
        //Store the greatest value, will be updated as new scores are calculated
        Integer greatest = 0;
        //For length of the list (+1 as we are checking backwards)
        for (int i = 0; i < values.length+1; i++){
            //If its the first iteration (e.g. if there is no i-1), skip this iteration
            if(i==0) continue;
            //If i has reached the maximum index, score (this needs to be specified due to the formatting of the if statement, i do not want to call the index when the index doesn't exist)
            if (i == values.length){
                //switch case as it is nicer to read in this scenario
                switch(counter){
                    case 1:
                        //System.out.println("Adding Score 1");
                        //score += values[i-1];
                        if (values[i-1] > greatest) greatest = values[i-1];
                        break;
                    case 2:
                        //System.out.println("Adding Score 2");
                        //score += (values[i-1] * 10);
                        if ((values[i-1]*10) > greatest) greatest = values[i-1]*10;
                        break;
                    case 3:
                        //System.out.println("Adding Score 3");
                        //score += (values[i-1] *100);
                        if ((values[i-1]*100) > greatest) greatest = values[i-1]*100;
                        break;
                    case 4:
                        //System.out.println("Adding Score 4");
                        //score += (values[i-1] * 1000);
                        if ((values[i-1]*1000) > greatest) greatest = values[i-1]*1000;
                        break;
                }
                //Set the counter to 1 to ensure it begins iterating correctly at next iteration
                counter = 1;
            }
            //If the previous value matches the current value, then increase this counter
            else if(values[i-1] == values[i]){
                counter++;
            }
            // (if the previous value doesn't match it means the total of this value has been reached)
            // (this has been guaranteed by the sort function, meaning all similar elements have been ordered)
            else{
                switch(counter){
                    case 1:
                        //System.out.println("Adding Score 1");
                        //score += values[i-1];
                        if (values[i-1] > greatest) greatest = values[i-1];
                        break;
                    case 2:
                        //System.out.println("Adding Score 2");
                        //score += (values[i-1] * 10);
                        if ((values[i-1]*10) > greatest) greatest = values[i-1]*10;
                        break;
                    case 3:
                        //System.out.println("Adding Score 3");
                        //score += (values[i-1] *100);
                        if ((values[i-1]*100) > greatest) greatest = values[i-1]*100;
                        break;
                    case 4:
                        //System.out.println("Adding Score 4");
                        //score += (values[i-1] * 1000);
                        if ((values[i-1]*1000) > greatest) greatest = values[i-1]*1000;
                        break;
                }
                counter = 1;
            }
        }
        score += greatest;
        return score;
    }
}