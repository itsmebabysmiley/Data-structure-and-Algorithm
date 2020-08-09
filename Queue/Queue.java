package Queue;
/**
 * Circular queue linked list.
 */
public class Queue {
    private Node lastNode;
    //Constructor
    public Queue(){
        lastNode = null;
    }
    /**
     * 
     * @return true if lastnode is null. otherwise false.
     */
    public boolean isEmpty() {
        return lastNode == null;
    }
    /**
     * remove all queue.
     */
    public void dequeueAll() {
        lastNode = null;
    }  
    /**
     * if queue is empty make new node refer to itself.
     * otherwise make new node refer to first node and change last node to be new node.
     * @param newItem
     */
    public void enqueue(Object newItem) {
        Node newNode = new Node(newItem); //create new node.
        if(isEmpty()){//queue is empty.
            newNode.setNext(newNode); //make new node refer to itself.
        }else{
            newNode.setNext(lastNode.getNext()); //new node refer to first node.
            lastNode.setNext(newNode);// make new node to be last node.
        }
        lastNode = newNode; //change last node to refer to new node.
    }
    /**
     * if queue has only 1 node, set queue to null.
     * otherwise move to next node and return first node.
     * @return first node if queue isn't empty, otherwise null or -1.
     */
    public Object dequeue() {
        if(!isEmpty()){
            Node firstnode = lastNode.getNext();
            if(firstnode == lastNode){
                lastNode = null;
            }else{
                lastNode.setNext(firstnode.getNext());
            }
            return firstnode.getItem();
        }
        return null;
    }
    /**
     * peek is a method that peek first node but remove from queue.
     * @return first node if queue isn't empty, otherwise null or -1.
     */
    public Object peek() {
        if(!isEmpty()){
            Node firstNode = lastNode.getNext();
            return firstNode.getItem();
        }else
            return null;
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }

}