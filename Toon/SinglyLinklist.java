

/**
 * one way linklist.
 */
class SinglyLinkist {

    Node newNode;
    Node head;
    Node curr;
    Node prev;
    Node sorted;

    public void add(Deck newItem) {
        if(head == null){
            newNode = new Node(newItem);
        }else{
            newNode = new Node(newItem,head);
        }
        head = newNode;
    }
    
    public void insertionSort(Node headref)  
    { 
        // Initialize sorted linked list 
        sorted = null; 
        Node current = headref; 
        // Traverse the given linked list and insert every 
        // Node to sorted 
        while (current != null)  
        { 
            
            // Store next for next iteration 
            Node next = current.getNext(); 
            // insert current in sorted linked list 
            insertAt(current);
            show(sorted);
            // Update current 
            current = next; 
        } 
        // Update head to point to sorted linked list 
        head = sorted;
        
    }
    
  
    /* 
     * function to insert a new_Node in a list. Note that  
     * this function expects a pointer to head_ref as this 
     * can modify the head of the input linked list  
     * (similar to add()) 
     */
    
    void insertAt(Node newNode)  
    { 
        //Special case for the head end 
        if (sorted == null || sorted.getItem().compareTo(newNode.getItem())>=0)  
        {   newNode.setNext(sorted);
            sorted = newNode; 
        } 
        else 
        { 
            Node current = sorted;
            //Locate the Node before the point of insertion
            while (current.getNext() != null && current.getNext().getItem().compareTo(newNode.getItem())<0)  
            { 
                current = current.getNext(); 
            }
            newNode.setNext(current.getNext()); 
            current.setNext(newNode);
        } 
    } 
    public void show(Node head) {
        curr = head;
        while(curr != null){
            System.out.print(curr.getItem().toString()+" ");
            curr = curr.getNext();
        }System.out.println();
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getCurr() {
        return curr;
    }

    public void setCurr(Node curr) {
        this.curr = curr;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNewNode() {
        return newNode;
    }

    public void setNewNode(Node newNode) {
        this.newNode = newNode;
    }

    public Node getSorted() {
        return sorted;
    }

    public void setSorted(Node sorted) {
        this.sorted = sorted;
    }
    
}