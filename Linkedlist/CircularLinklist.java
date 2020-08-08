package Linkedlist;

public class CircularLinklist{

    Node newNode;
    Node head;
    Node lastNode;
    Node curr;
    Node prev;
    
    public void add(Object newItem) {
        if(head == null){
            newNode = new Node(newItem);
            lastNode = newNode;
        }else{
            newNode = new Node(newItem,head);
        }
        lastNode.setNext(newNode);
        head = newNode;
    }

    public boolean search(Object item) {
        curr = head; //curr is use to find node.
        prev = null; //prev is use to find previous node.
        do{
            if(curr.getItem() == item){ //found item.
                return true; 
            }else{
                prev = curr; //set prev to be current node.
                curr = curr.getNext(); //move curr to next node.
            }
        }while(curr != head); //fist node to last node

        return false; //if cann't find an item.
    }

    public void delete(Object item) {
        if(search(item)){ //search an item
            if(prev == null){ // delete node that connect to head node.
                head = curr.getNext();
                lastNode.setNext(curr.getNext());
                curr.setNext(null);
            }else if(curr == lastNode){ //delete last node.
                prev.setNext(lastNode.getNext());
                lastNode = prev;
                curr.setNext(null);
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
                lastNode.setNext(newNode);
                head = newNode;
            }else{ //insert new node between 2 nodes.
                newNode.setNext(curr);
                prev.setNext(newNode);
            }
        }else{ 
            if(head == null){ //linklist is empty?
                newNode.setNext(curr);
                head = newNode;
            }else if (curr == head){ //insert new node at last
                newNode.setNext(head);
                lastNode.setNext(newNode);
                lastNode = newNode;
            }
        }
    }

    public void show() {
        curr = head;
        while(curr != lastNode){
            System.out.print(curr.getItem()+" ");
            curr = curr.getNext();
        }
        System.out.print(curr.getItem()+" ");
        curr = curr.getNext();
        System.out.print("head data = "+curr.getItem());
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinklist cLinklist = new CircularLinklist();
        cLinklist.add(6);
        cLinklist.add(9);
        cLinklist.add(5);
        cLinklist.delete(5);
        cLinklist.insert(6, 10);
        cLinklist.insert(12, 7);
        cLinklist.show();
        
    }
}