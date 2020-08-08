package Linkedlist;

/**
 * one way linklist.
 */
public class SingleLinklist {

    Node newNode;
    Node head;
    Node curr;
    Node prev;
    
    public void add(Object newItem) {
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
        curr = head; //curr is use to find node.
        prev = null; //prev is use to find previous node.
        while(curr != null){ //curr isn't at the end of linklist.
            if(curr.getItem() == item){
                return true; //return true if can find an item.
            }else{
                prev = curr; //set prev to be current node.
                curr = curr.getNext(); //move curr to next node.
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
            if(prev == null){ // delete node that connect to head node.
                head = curr.getNext();
                //curr.setNext(null);
            }else{ //set prev to be next node
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
    public void insert(Object iteminsert, Object newItem) {
        newNode = new Node(newItem);
        if(search(iteminsert)){
            if(prev == null){ //insert new node to be head node
                newNode.setNext(curr);
                head = newNode;
            }else{ //insert new node between 2 nodes.
                newNode.setNext(curr);
                prev.setNext(newNode);
            }
        }else{ 
            if(head == null){ //linklist is empty?
                newNode.setNext(curr);
                head = newNode;
            }else if (curr == null){ //insert new node at last
                prev.setNext(newNode);
            }
        }
    }
    
    public void show() {
        curr = head;
        while(curr != null){
            System.out.print(curr.getItem()+" ");
            curr = curr.getNext();
        }System.out.println();
    }

    public static void main(String[] args) {
        SingleLinklist linklist = new SingleLinklist();
        for (int i = 10; i <= 20; i++) {
            linklist.add(i);
            System.out.printf("add %d: ", i);
            linklist.show();
        }

        linklist.delete(10);
        System.out.print("delete 10: ");
        linklist.show();
        
        linklist.insert(12, 99);
        System.out.print("insert 99 before 12: ");
        linklist.show();
        linklist.insert(13, 9);
        System.out.print("insert 9 before 13: ");
        linklist.show();
        linklist.insert(7, 999);
        System.out.print("insert 999 at last: ");
        linklist.show();
        
        
    }
}
