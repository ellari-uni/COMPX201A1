/*
 * File: Node.java
 * Description: Provide nodes to be used in the CardLinkedList
 * Author: Hayden Gillanders
 * ID Number: 1636274
 * Date Modified: 2025-03-24
 */
public class Node {
    Node next;
    Card card;

    public Node(Card card){
        this.card = card;
        next = null;
    }
}
