import java.util.Scanner;

/**
 * one way linklist.
 */
class SinglyLinkist {

    Node newNode;
    Node head;
    Node curr;
    Node prev;
    
    public void add(Object newItem,int number) {
        if(head == null){
            newNode = new Node(newItem,number);
        }else{
            newNode = new Node(newItem,head,number);
        }
        head = newNode;
    }

    public void search(Object item) {
        curr = head; //curr is use to find node.
        prev = null; //prev is use to find previous node.
        while(curr != null){ //curr isn't at the end of linklist.
            if(curr.getNumber() == (int)item){
                System.out.println("Number "+item.toString()+", "+"Value "+curr.getItem()); //return true if can find an item.
                return;
            }else{
                prev = curr; //set prev to be current node.
                curr = curr.getNext(); //move curr to next node.
            }
        }
        System.out.println("Number "+item.toString()+", "+"Not found");//if cann't find an item.
    }

    public void show() {
        curr = head;
        while(curr != null){
            System.out.println("Number "+curr.getNumber()+", "+"Value \""+curr.getItem()+"\"");
            curr = curr.getNext();
        }
    }

    public static void main(String[] args) {
        SinglyLinkist linklist = new SinglyLinkist();
        linklist.add("two", 2);
        linklist.add("one", 1);
        linklist.add("Twenty", 20);
        linklist.add("Sixtynine", 69);
        linklist.add("Eight", 8);
        linklist.add("three", 3);
        linklist.add("Nineteen", 19);
        linklist.show();
        Scanner scan = new Scanner(System.in);
        System.out.print("Input number to search: ");
        int key = scan.nextInt();
        linklist.search(key);

        
    }
}