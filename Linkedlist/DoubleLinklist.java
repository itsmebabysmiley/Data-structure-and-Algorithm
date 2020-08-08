package Linkedlist;
/**
 * two way linklist
 */
public class DoubleLinklist {
    DoubleLink newNode;
    DoubleLink head;
    DoubleLink last;
    DoubleLink curr;  //current node.
    DoubleLink prev1; //previous node.
    DoubleLink prev2; //next node. (curr.getNext());

    public void add(Object newItem) {
        if(head == null){
            newNode = new DoubleLink(newItem);
            last = newNode;
        }else{
            newNode = new DoubleLink(newItem,head,null);
            head.setPrecede(newNode);
        }
        head = newNode;
    }
    /**
     * 
     * @param item is a target.
     * @return 
     */
    public boolean search(Object item) {
        curr = head;  //curr is use to find node.
        prev1 = null; //pre1 is use to find previous node.
        while(curr != null){ //not at the end of linkedlist.
            if(curr.getItem() == item){ //find an item.
                prev2 = curr.getNext(); //set prev2 to next node.
                return true;
            }else{
                prev1 = curr; //set prev1 to be current node.
                curr = curr.getNext(); //move to next node.
            }
        }
        return false; // can't find item.
    }

    public void deleteNode(Object item) {
        if(search(item)){
            if(prev1 == null){ //delete head node.
                head = curr.getNext(); // make head node connect to next node.
                if(prev2 != null){
                    prev2.setPrecede(null); //disconnect from next node.
                }
            }else if(prev2 == null){ //delete last node.
                prev1.setNext(null);
                curr.setPrecede(null);
            }else{
                prev1.setNext(curr.getNext());
                //prev1.setNext(prev2);
                prev2.setPrecede(curr.getPrecede());  
                //prev2.setPrecede(prev1);
            }
        }else{
            System.out.println("NOt found: "+item);
        }
    }

    public void insert(Object itemInsert, Object newItem) {
        newNode = new DoubleLink(newItem);
        if(search(itemInsert)){
            prev2 = curr;
            if(prev1 == null){ //insert new node at head node.
                newNode.setNext(curr);
                curr.setPrecede(newNode);
                head = newNode;
            }else{ //insert new node between 2 nodes.
                //--connect to new next node--\\
                newNode.setNext(prev1.getNext()); 
                //newNode.setNext(curr);
                prev1.setNext(newNode);
                //-----------------------------\\
                //--connect to new previous node--\\
                newNode.setPrecede(prev2.getPrecede());
                //newNode.setPrecede(prev1);
                prev2.setPrecede(newNode);
                //---------------------------------\\
            }
        }else{
            if(head == null){ //empty linked list?
                newNode = new DoubleLink(newItem);
                last= newNode;
            }else{ //insert new node at last position.
                newNode = new DoubleLink(newItem,null,last);
                last.setNext(newNode);
                last = newNode;
            }
        }
    }

    public void show() {
        curr = head;
        while(curr != null){
            System.out.print(curr.getItem()+" ");
            curr = curr.getNext();
        }
        if(head != null){
            System.out.print("\n    backward : ");
            curr = last;
            while(curr != null){
                System.out.print(curr.getItem()+" ");
                curr = curr.getPrecede();
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        DoubleLinklist linklist = new DoubleLinklist();
        for (int i = 9; i < 13; i++) {
            linklist.add(i);
            System.out.printf("add %d : ", i);
            linklist.show();
        }
            linklist.deleteNode(10);
            System.out.print("delete 10 :");
            linklist.show();
            linklist.deleteNode(12);
            System.out.print("delete 12 :");
            linklist.show();

            linklist.insert(11, 15);
            System.out.print("insert 15 before 11 :");
            linklist.show();
            linklist.insert(20, 17);
            System.out.print("insert 17 at last :");
            linklist.show();
    }

    

}



class DoubleLink {
    private Object item; 
    private DoubleLink next; //next node
    private DoubleLink precede; //precede node

    public DoubleLink(){
        next = null;
        precede = null;
    }
    /**
     * create head node.
     * @param newItem
     */
    public DoubleLink(Object newItem){
        item = newItem;
        next = null;
        precede = null;
    }

    public DoubleLink(Object newItem, DoubleLink nextNode, DoubleLink precedeNode){
        item = newItem;
        next = nextNode;
        precede = precedeNode;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public DoubleLink getNext() {
        return next;
    }

    public void setNext(DoubleLink next) {
        this.next = next;
    }

    public DoubleLink getPrecede() {
        return precede;
    }

    public void setPrecede(DoubleLink precede) {
        this.precede = precede;
    }
}