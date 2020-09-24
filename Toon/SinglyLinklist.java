

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
    /**
     * 
     * @param item is a target 
     * @return
     */
    public boolean search(Object item) {
        curr = head; //curr is use to find Node.
        prev = null; //prev is use to find previous Node.
        while(curr != null){ //curr isn't at the end of linklist.
            if(curr.getItem() == item){
                return true; //return true if can find an item.
            }else{
                prev = curr; //set prev to be current Node.
                curr = curr.getNext(); //move curr to next Node.
            }
        }
        return false; //if cann't find an item.
    }
    /**
     * 
     * @param item is a target.
     */
    public void delete(Object item) {
        if(search(item)){ //search an item
            if(prev == null){ // delete Node that connect to head Node.
                head = curr.getNext();
                //curr.setNext(null);
            }else{ //set prev to be next Node
                prev.setNext(curr.getNext());
                // curr.setNext(null);
            }
        }else{
            System.out.println("Not found :"+item);
        }
    }
    /**
     * 
     * @param iteminsert where you want to insert.
     * @param newItem item that you want to insert.
     */
    
    
    public void show() {
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

    void insertionSort(Node headref)  
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
            sortedInsert(current); 
            // Update current 
            current = next; 
        } 
        // Update head_ref to point to sorted linked list 
        head = sorted; 
    } 
  
    /* 
     * function to insert a new_Node in a list. Note that  
     * this function expects a pointer to head_ref as this 
     * can modify the head of the input linked list  
     * (similar to push()) 
     */
    void sortedInsert(Node newNode)  
    { 
        /* Special case for the head end */
        if (sorted == null || sorted.val >= newNode.val)  
        { 
            newNode.next = sorted; 
            sorted = newNode; 
        } 
        else 
        { 
            Node current = sorted; 
            /* Locate the Node before the point of insertion */
            while (current.next != null && current.next.val < newNode.val)  
            { 
                current = current.next; 
            } 
            newNode.next = current.next; 
            current.next = newNode; 
        } 
    } 

}