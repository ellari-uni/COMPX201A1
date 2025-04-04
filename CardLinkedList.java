/*
 * File: CardLinkedList.java
 * Description: Create a LinkedList Data Structure, specifically for Card objects
 * Author: Hayden Gillanders
 * ID Number: 1636274
 * Date Modified: 2025-03-24
 */

import java.util.Random;
public class CardLinkedList {
    
    Node head;
    
    /**
     * Create a new Linked List, initialising head to null
     */
    public CardLinkedList(){

        head = null;

    }

    /**
     * Get a random suit from the enum of suits
     * @return a Suit from enum
     */
    public Card.Suits getRandomSuit(){
        Random rand = new Random();

        //Convert all suits to array, get a random index and use it for the return
        return Card.Suits.values()[rand.nextInt(Card.Suits.values().length - 1)];

    }

    /**
     * Gets and removes a random card from the LL 
     * @return The card that was chosen
     */
    public Card getRandomCard(){

        Random rand = new Random();
        //Remove a card from a random index in the list
        return remove(getCardAt(rand.nextInt(getLength()-1)));

    }

    /**
     * print out all values in the list, starting with head
     */
    public void print(){

        Node current = head;
        
        while (current != null){
            
            System.out.print(current.card + " -> ");
            current = current.next;
        }

        System.out.println();
 
    }

    /**
     * Add a card to the LinkedList (in stack form)
     * @param card
     */
    public void add (Card card){

        Node newNode = new Node(card);
        newNode.next = head;
        head = newNode;

    }

    /**
     * Take the first occurence from a particular card off the stack
     * @param card card to remove
     */
    public Card remove(Card card){
        if (!hasCard(card)) {

            System.out.println("List does not contain this card");
        }
        else{

            //Need current and previous so that the rest of the list doesn't get lost
            Node current = head;
            Node previous = null;
            
            //Iterate through cards in list until there is a match, then remove it by updating the head/previous
            while (current != null){
                if(current.card.equals(card)){
                    if(previous == null) {
                        head = current.next;
                        break;
                    }
                    else{
                        previous.next = current.next;
                        break;
                    }
                }
                else{
                    previous = current;
                    current = current.next;
                }
            }
            return card;
        }
        //Not reachable code, but java compiler throws an error if removed for some reason
        return null;
    }
    /**
     * Check whether the list is empty by comparing the head to null
     */
    public boolean isEmpty(){

        return head == null;
    }

    /**
     * get the length of the list by iterating through the list until current=null
     * @return Length as an int
     */
    public int getLength(){

        Node current = head;
        int len = 0;
        while (current != null){
            len++;
            current = current.next;
        }

        return len;
    }

    /**
     * Check whether the list has a particular card
     * @param card card to check
     * @return Boolean whether or not card is present
     */
    public boolean hasCard(Card card){
        Node current = head;
        while (current != null){

            if (current.card.equals(card)){

                return true;
            }

            current = current.next;
        }

        return false;
    }

    /**
     * Get a card at a given index in the list
     * @param index 
     * @return Card at the index (null if out of bounds)
     */
    public Card getCardAt(int index){
        
        try {

            //Compare to length -1 since index starts at 0 but length starts at 1
            if(index > getLength() -1) {

                throw new Exception("index must be within the bounds of the list");

            }
            else{

                //iterate until index is reached, then get given card
                Node current = head;
                for (int i = 0; i <= index; i++){

                    if(i == index) {
                        return current.card;
                    }

                    current = current.next;
                }

                return null;
            }
        }
        catch (Exception ex){

            System.out.println(ex.getMessage());
            return null;
            
        }
    }
}

