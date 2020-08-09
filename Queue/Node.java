package Queue;

public class Node {
    
    private Object item;
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
    public Node(Object newItem){
        item = newItem;
        next = null;
    }
    /**
     * assign item to be newItem.
     * assging next connect to next node.
     * @param newItem
     * @param nextNode
     */
    public Node(Object newItem, Node nextNode){
        item = newItem;
        next = nextNode;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}