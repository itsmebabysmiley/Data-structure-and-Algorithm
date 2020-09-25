
/**
 * one way linklist.
 * @author Nopparat Pengsuk 6288103 sec2
 */
class SinglyLinkist {

    Node newNode;
    Node head;
    Node curr;
    Node prev;
    
    public void add(Object newItem,int number) {
        //head node
        if(head == null){
            newNode = new Node(newItem,number);
        }
        //not head node
        else{
            newNode = new Node(newItem,head,number);
        }
        head = newNode;
    }

    public String search(int key) {
        curr = head; //curr is use to find node.
        while(curr != null){ //curr isn't at the end of linklist.
            if(curr.getNumber() == key){
                //return true if can find an item.
                return "Number "+key+", "+"Value "+curr.getItem(); 
                
            }else{
                curr = curr.getNext(); //move curr to next node.
            }
        }
        //if cann't find an item.
        return "Number "+key+", "+"Not found";
        
    }

    public void show() {
        curr = head;
        while(curr != null){
            System.out.println("Number "+curr.getNumber()+", "+"Value \""+curr.getItem()+"\"");
            curr = curr.getNext();
        }
    }

}