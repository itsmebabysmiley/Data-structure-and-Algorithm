package Queue;

public class OnewayQueue {
    private Node firstNode;
    private Node lastNode;
    //constructor
    public OnewayQueue(){
        firstNode = null;
        lastNode = null;
    }

    public boolean isEmpty() {
        return firstNode == null && lastNode == null;
    }

    public void dequeueAll() {
        firstNode = null;
        lastNode = null;
    }
    /**
     * add new iteam in queue.
     * if queue is empty set first node and last node to new node.
     * othewise make new node to last node.
     * @param newItem
     */
    public void enqueue(int newItem) {
        Node newNode = new Node(newItem); //create new node.
        if(isEmpty()){ // empty queue.
            firstNode = newNode; //set first node to refer to new node.
        }else{
            lastNode.setNext(newNode); //change new node to be last node.
        }
        lastNode = newNode; //make lastnode refer to new node.
    }
    /**
     * dequeue first node from queue.
     * move first node to next node. if queue has only 1 item(first queue and last queue refer to the same node), then set first node and last node to be null.
     * @return
     */
    public Object dequeue() {
        if(!isEmpty()){
            Node temp = firstNode; //create temp
            firstNode = firstNode.getNext(); //change first node to be next one.
            if(firstNode == null){ //queue has only 1 item
                lastNode = null; //set lastnode to null to make queue empty.
            }
            return temp.getItem(); //return item
        }else{
            return null;
        }
    }
    /**
     * peek is a method that peek first node but remove from queue.
     * @return first node if queue isn't empty, otherwise null or -1.
     */
    public Object peek() {
        if(!isEmpty()){
            return firstNode.getItem();
        }else{
            return null;
        }
    }
    public static void main(String[] args) {
        OnewayQueue queue = new OnewayQueue();
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(8);
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }

}