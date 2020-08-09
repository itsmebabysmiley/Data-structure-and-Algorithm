package Queue;
/**
 * Circular queue array.
 */
public class QueueArray {
    private final int MAX_QUEUE = 5;
    private int[] item;
    private int front,back,count;
    //Constructor
    public QueueArray(){
        item = new int[MAX_QUEUE];
        front = 0;
        back = MAX_QUEUE-1;
        count = 0;
    }
    
    public boolean isEmpty() {
        return ((count==0) );
    }

    public boolean isFull() {
        return ((count == MAX_QUEUE) );
    }
    /**
     * check queue isn't full.
     * find array index before add new item to queue.(to make sure that index
     * is not over queue size). 
     * Ex. if MAX_QUEUE = 5 and back is 4
     *     back = (4+1) % 5 = 0
     * add new item at index 0. increase count.
     * @param newItem
     */
    public void enqueue(int newItem) {
        if(!isFull()){
            back = (back+1)%MAX_QUEUE;
            item[back] = newItem;
            ++count;
        }else{
            System.out.printf("Can't add %d [Queue is full].\n",newItem);
        }
    }
    /**
     * queue is not empty.
     * bananananan
     * decrease count and then return item.
     * @return
     */
    public int dequeue() {
        if(!isEmpty()){
            if(front == MAX_QUEUE) front = 0;
            int queuefront =item[front];
            --count;
            return queuefront;
        }else{
            return -1;
        }

    }
    /**
     * remove all queue.
     */
    public void dequeueAll() {
        item = new int[MAX_QUEUE];
        front = 0;
        back = MAX_QUEUE-1;
        count = 0;
    }
    /**
     * 
     * @return item without remove it.
     */
    public Object peek() {
        if(!isEmpty()){
            return item[front];
        }else{
            return -1;
        }
    }
    public static void main(String[] args) {
        QueueArray queue = new QueueArray();
        int[] item = new int[5];
        for (int i = 0; i < item.length; i++) {
            item[i] = i;
            queue.enqueue(item[i]);
            
        }
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}