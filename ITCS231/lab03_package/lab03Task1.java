public class lab03Task1 {
    public static void main(String[] args) {
        FirstLastList linklist = new FirstLastList();
        linklist.insertFirst(5);
        linklist.insertFirst(15);
        linklist.insertFirst(25);
        linklist.insertFirst(30);

        linklist.insertLast(3);
        linklist.insertLast(13);
        linklist.insertLast(23);
        linklist.insertLast(33);

        linklist.displayList();
        while(!linklist.isEmpty()){
            linklist.deleteFirst();
            linklist.displayList();
        }
    }
}
