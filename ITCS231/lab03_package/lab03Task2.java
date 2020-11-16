public class lab03Task2 {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertFirst(5);
        linkedList.insertFirst(15);
        linkedList.insertFirst(25);
        linkedList.insertFirst(30);

        linkedList.insertLast(3);
        linkedList.insertLast(13);
        linkedList.insertLast(23);
        linkedList.insertLast(33);

        linkedList.insertAfter(23, 100);

        linkedList.deleteFirst();
        System.out.println("delete first");
        System.out.println("delete last");
        linkedList.deleteLast();
        System.out.println("delete 25");
        linkedList.deleteKey(25);

        linkedList.displayForward();
        linkedList.displayBackward();
    }
}
