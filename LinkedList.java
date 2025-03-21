public class LinkedList<T>{
    SLLNode head;

    public LinkedList(){
        head = null;
    }
    
    /**
     * Prints Values in the linked list
     */
    public void print(){
        SLLNode current = head;
        while(current != null){
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void add(T n){
        SLLNode newNode = new SLLNode(n);
        newNode.next = head;
        head = newNode;
    }
    
    public boolean hasElement(T n){
        SLLNode current = head;
        while (current != null){
            if (current.value == n) return true;
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getLength(){
        SLLNode current = head;
        int len = 0;
        while (current != null){
            len++;
            current = current.next;
        }
        return len;
    }

    public void remove(T n){
        if (isEmpty() || !hasElement(n)) return;

        if (head.value == n) {
            head = head.next;
            return;
        }
        else{
            SLLNode previous = head;
            SLLNode current = head.next;
            while(current != null){
                if(current.value == n) previous.next = current.next;
                else {
                    previous = current;
                    current = current.next;
                }
                return;
            }
        }
    }

    class SLLNode {
        T value;
        SLLNode next;
    
        public SLLNode(T n){
            value = n;
            next = null;
        }
    }
}
