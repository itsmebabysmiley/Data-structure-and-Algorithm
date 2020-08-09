package Stack;

public class StackLinklist {
    private Node top;
    //Constructer
    public StackLinklist(){
        top = null;
    }
    /**
     * check if is empty or not.
     * @return true if top equal null.
     */
    public boolean isEmpty(){
        return top == null;
    }
    /**
     * push item into stack.
     * we don't need to check if stack is full or not because it's Dynamic linked list.
     * create new node and this node has refer to previous node.
     * @param newItem
     */
    public void push(Object newItem){
        top = new Node(newItem,top); // it's not the same node(top)
        //top(new) = new Node(newItem,top(old)); top = new node [this.top]
    }
    /**
     * Pop is method that read an item on top off the stack. and then move to next item.
     * Check is stack empty. create temp to store then move to next node(top.getNext())
     * 
     * @return item if stack is not empty, otherwise null or -1.
     */
    public Object pop(){
        if(!isEmpty()){
            Node temp = top;
            top = top.getNext();
            return temp.getItem();
        }
        return null;
    }
    /**
     * remove all item in stack.
     */
    public void popAll() {
        top = null;
    }
    /**
     * Peek is method that read an item on top of the stack but not remove it.
     * @return item if stack is not empty, otherwise  return -1;
     */
    public Object peek() {
        if(!isEmpty()){
            return top.getItem();
        }
        return null;
    }
}

class StackLinklisttester{
    public static void main(String[] args) {
        StackLinklist stack = new StackLinklist();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}