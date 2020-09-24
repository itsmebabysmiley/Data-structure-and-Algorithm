
public class Node {
    
    private Deck item;
    private Node next;  //connect to next node;
    /**
     * create head node(starter node of linklist).
     */
    public Node(){
        next = null;
    }
    /**
     * assign item to be newItem.
     * no connection to next node.
     * @param newItem
     */
    public Node(Deck newItem){
        item = newItem;
        next = null;
    }
    /**
     * assign item to be newItem.
     * assging next connect to next node.
     * @param newItem
     * @param nextNode
     */
    public Node(Deck newItem, Node nextNode){
        item = newItem;
        next = nextNode;
    }

    public Deck getItem() {
        return item;
    }

    public void setItem(Deck item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}