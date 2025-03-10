public class CardLinkedList {
    Node head;
    
    public CardLinkedList(){
        head = null;
    }

    public void print(){
        Node current = head;
        
        while (current != null){
            System.out.print(current.card + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public void add (Card card){
        Node newNode = new Node(card);
        newNode.next = head;
        head = newNode;
    }

    /*
     * REMOVE FUNCTION GOES HERE
     */
    public void remove(Card card){
        if (!hasCard(card)) System.out.println("List does not contain this card");
        else{
            Node current = head;
            Node previous = null;

            while (current != null){
                if(current.card.equals(card)){
                    if(previous == null) head = current.next;
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
            System.out.println("Successfully removed " + card + " from linked list");
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getLength(){
        Node current = head;
        int len = 0;
        while (current != null){
            len++;
            current = current.next;
        }

        return len;
    }

    public boolean hasCard(Card card){
        Node current = head;
        while (current != null){
            if (current.card.equals(card)) return true;
            current = current.next;
        }
        return false;
    }
}
