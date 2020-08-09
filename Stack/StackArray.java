package Stack;

public class StackArray {
    final int MAX_STACK = 50;
    private int[] item;
    private int top;
    //Constructer.
    public StackArray(){
        item = new int[MAX_STACK];
        top = -1;
    }
    /**
     * if top qual 0 or more than, then stack is not empty.
     * @return
     */
    public boolean isEmpty() {
        return top < 0;
    }
    /**
     * @return true when top equal MAX_STACK-1, otherwise false.
     */
    public boolean isFull() {
        return top == MAX_STACK-1;
    }
    /**
     * push item into stack.
     * Fisrt check stack is not full. then increase top value and then add item into stack.
     * @param newItem
     * @return true if can push, otherwise false.
     */
    public boolean push(int newItem) {
        if(!isFull()){ //check stack is full or not.
            item[++top] = newItem; //increase top and then add item.
            return true;
        }
        return false;
    }
    /**
     * remove all items in the stack.
     */
    public void popAll() {
        item = new int[MAX_STACK]; //make empty stack.
        top = -1; //empty stack top will -1.
    }
    /**
     * Pop is method that read an item on top off the stack. and then move to next item.
     * @return item if stack is not empty, otherwise return -1.
     */
    public int pop(){
        if(!isEmpty()){
            return item[top--]; //return an item and then decrease top.
        }
        return -1;
    }
    /**
     * Peek is method that read an item on top of the stack but not remove it.
     * @return item if stack is not empty, otherwise  return -1;
     */
    public int peek() {
        if(!isEmpty()){
            return item[top];
        }
        return -1;
    }

}

class StackArrayTester{
    public static void main(String[] args) {
        StackArray stack = new StackArray();
        int item[] = new int[5];
        for (int i = 0; i < item.length; i++) {
            if(!stack.isFull()){
                stack.push(item[i]=i);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}