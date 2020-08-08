package Linkedlist;

public class ArrayLinklist {
    final int Null = -1;

    int maxNode = 10;
    int newNode;
    int head = -1; //kinda root.
    int curr;
    int prev;
    int countNode = 0;
    ArrayNode[] node;
    /**
     * Constructer
     */
    public ArrayLinklist(){
        node = new ArrayNode[maxNode];
        for (newNode = 0; newNode < maxNode; newNode++) {
            node[newNode] = new ArrayNode();
            node[newNode].item = Null;
            node[newNode].next = Null;
        }
    }
    /**
     * check array linked list is full or not.
     * @return true if not full, otherwise false.
     */
    public boolean isNOtFull() {
        if(countNode != maxNode){
            return true;
        }
        return false;
    }
    /**
     * find empty node to strong new node.
     */
    public boolean findEmptyNode() {
        for (newNode = 0; newNode < maxNode; newNode++) {
            if(node[newNode].item == Null)
                return true;
        }
        return false;
    }

    public void add(int newItem) {
        if(isNOtFull() && findEmptyNode()){ //find empty node.
            node[newNode].item = newItem;
            if(head != Null){ //if it's not empty array.
                node[newNode].next = head; //add head to next.
            }
            head = newNode;
            countNode++;
        }else{
            System.out.println("Array linked list is full");
        }
    }

    public void delete(int item) {
        if(search(item)){
            node[curr].item = Null;
            if(prev == Null){ //delete head node.
                head = node[curr].next;
                // node[curr].next = Null;
            }else{ //delete node between 2 nodes or delete last node.
                node[prev].next = node[curr].next;
            }
            countNode--;
        }else{
            System.out.println("Not found item.");
        }
    }

    public boolean search(int item) {
        curr = head;
        prev = Null;
        while(curr != Null){
            if(node[curr].item == item){
                return true;
            }else{
                prev = curr;
                curr = node[curr].next;
            }
        }
        return false;
    }

    public void insert(int iteminsert, int newItem) {
        if(isNOtFull() && findEmptyNode()){
            node[newNode].item = newItem;
            countNode++;
            if(search(iteminsert)){ 
                if(prev == Null){ //insert at head node.
                    node[newNode].next = curr;
                    head = newNode;
                }else{ //insert between 2 node 
                    node[newNode].next = curr;
                    node[prev].next = newNode;
                }
            }else{
                if(head == Null){ //empty linked list?
                    head = newNode;
                }else if(curr == Null){ //insert at last node.
                    node[prev].next = newNode;
                }
            }
        }else{
            System.out.println("Array linked list is full");
        }
    }

    public void show() {
        curr = head;
        while(curr != Null){
            System.out.print(node[curr].item + " ");
            curr = node[curr].next;
        }System.out.println();
    }

    public static void main(String[] args) {
        ArrayLinklist linklist = new ArrayLinklist();
        for (int i = 9; i <= 12; i++) {
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
        linklist.insert(7, 999);
        System.out.print("insert 999 at last: ");
        linklist.show();
        
    }
    
}
/**
 * Node in array.
 */
class ArrayNode{
    int item;
    int next;

}